package candystore.screenimage;

import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.Relative;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

import atf.toolbox.ATFHandler;

public class EventBudgetReport {

	public void GenerateEventBudgetReport() {
		ClassLoader classLoader = getClass().getClassLoader();
        try {
        	File file = new File(classLoader.getResource("Eventbudget.pdf").getFile());
			Desktop.getDesktop().open(file);
			
			//Thread.sleep(5000); // wait for the report to generate
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
 	}
	
	/**
	 * CloseEventBudgetReport
	 * Close the budget report
	 */
	public void CloseEventBudgetReport() {
		String imagePattern = "patterns/EventBudget_TabPattern.PNG";
		ClassLoader classLoader = getClass().getClassLoader();
        File pattern = new File(classLoader.getResource(imagePattern).getFile());
        
        Target imageTarget = new ImageTarget(pattern);
             
        ScreenRegion foundRegion = ATFHandler.getInstance().getScreenImageAutomation().getFullScreen().wait(imageTarget, 10000);
		
        Mouse mouse = new DesktopMouse();
        mouse.click(Relative.to(foundRegion).topRight().left(10).below(5).getScreenLocation());
	}
	
	/**
	 * isImageDisplayed
	 * @param imagePatternFile image pattern to match and 
	 * @return
	 */
	public boolean isImageDisplayed(String imagePatternFile) {

		ScreenRegion foundRegion = locateImageByPattern(imagePatternFile);
		
        if (foundRegion != null) return true;
        else return false;
	}
	
	public void saveMyImage(String imagePatternFile) {
		ScreenRegion imageToSave = locateImageByPattern(imagePatternFile);
		
		ATFHandler.getInstance().getScreenImageAutomation().saveBufferedImage("myCaptureScreenTest.png", imageToSave.capture());
	}
	
	private ScreenRegion locateImageByPattern(String imagePattern) {
		ClassLoader classLoader = getClass().getClassLoader();
        File pattern = new File(classLoader.getResource(imagePattern).getFile());
        
        Target imageTarget = new ImageTarget(pattern);
             
        ScreenRegion foundRegion = ATFHandler.getInstance().getScreenImageAutomation().getFullScreen().wait(imageTarget, 50000);

        return foundRegion;
	}
}
