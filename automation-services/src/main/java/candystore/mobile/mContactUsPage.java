package candystore.mobile;

import com.agiletestingframework.toolbox.ATFHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class mContactUsPage extends LoadableComponent<mContactUsPage>{

	public mContactUsPage()
	{
		PageFactory.initElements(ATFHandler.getInstance().getMobileAutomation().getMobileDriver(), this);
	}
	
	@Override
	protected void load() {
		ATFHandler.getInstance().getMobileAutomation().getMobileDriver().navigate().to("http://store.agiletestingframework.com/candystore/contact");
		isLoaded();
	}
	
	@Override
	protected void isLoaded() throws Error {
		
		
	}
	
	@FindBy(id="txtLastName")
	WebElement lastName;
	
	public String getLastNameValue()
	{
		return lastName.getAttribute("value");		
	}
	
	public void enterLastName(String lastNameToEnter)
	{
		lastName.clear();
		lastName.sendKeys(lastNameToEnter);
	}
	
	public String getFirstNameValue()
	{
		WebElement firstNameElement = ATFHandler.getInstance().getMobileAutomation().getMobileDriver().findElement(By.id("txtFirstName"));
		return firstNameElement.getAttribute("value");		
	}
	
	public void enterFirstName(String firstNameToEnter)
	{
		WebElement firstNameElement = ATFHandler.getInstance().getMobileAutomation().getMobileDriver().findElement(By.id("txtFirstName"));
		firstNameElement.clear();
		firstNameElement.sendKeys(firstNameToEnter);
	}
}