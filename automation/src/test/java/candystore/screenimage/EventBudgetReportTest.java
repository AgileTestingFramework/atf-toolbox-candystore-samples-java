package candystore.screenimage;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventBudgetReportTest {

	public EventBudgetReport eventBudgetRpt;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		eventBudgetRpt = new EventBudgetReport();
	}
	
	@Test
	public void ValidateEventBudgetPieGraph()
	{
		String piePattern = "patterns/EventBudget_EstimatedPiePattern.PNG";
        
		eventBudgetRpt.GenerateEventBudgetReport();
       
        assertThat(eventBudgetRpt.isImageDisplayed(piePattern)).isTrue();
        
        eventBudgetRpt.CloseEventBudgetReport();
	}
	
	@Test
	public void CapturePieFromScreen() {
		String piePattern = "patterns/EventBudget_EstimatedPiePattern.PNG";
		
		eventBudgetRpt.GenerateEventBudgetReport();
		eventBudgetRpt.saveMyImage(piePattern);
		eventBudgetRpt.CloseEventBudgetReport();
	}
}
