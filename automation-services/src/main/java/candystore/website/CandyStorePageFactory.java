package candystore.website;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import atf.toolbox.ATFHandler;
import candystore.website.pageobjects.ContactUsPage;
import candystore.website.pageobjects.IndexPage;

@SuppressWarnings("rawtypes")
public class CandyStorePageFactory {
	private static final Map<String, LoadableComponent> instances = new HashMap<String, LoadableComponent>();

    /** Create all page object constants here for easy access **/
    public static final String INDEX = "index";
    public static final String CONTACTUS = "contactUs";

    private CandyStorePageFactory() {}

    public static synchronized LoadableComponent getInstance(String pageObjectType) {

        // Our "per key" singleton
        LoadableComponent instance = instances.get(pageObjectType);

        if (instance == null) {
            // Lazily create instance
			if (pageObjectType == INDEX) {
				instance = new IndexPage();
			} else if (pageObjectType == CONTACTUS) {
				instance = new ContactUsPage();
			}
            
			// Add it to map   
            instances.put(pageObjectType, instance);
        }
		
		// Initialize the page object elements
        PageFactory.initElements(ATFHandler.getInstance().getWebAutomation().getWebDriver(), instance);
        
        return instance;
    }
}