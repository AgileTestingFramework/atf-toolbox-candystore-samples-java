package candystore.website;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import atf.toolbox.ATFHandler;
import candystore.website.pageobjects.ContactUsPage;
import candystore.website.pageobjects.IndexPage;

public class CandyStorePageFactory {

	private static Logger log = LoggerFactory.getLogger(CandyStorePageFactory.class);
    private static final CandyStorePageFactory instance = new CandyStorePageFactory();
    
    private CandyStorePageFactory() { }
    public static CandyStorePageFactory getInstance()
    {
    	log.info("Initializing candy store page factory.");
        return instance;
    }
    
    
    /** Each page object should return an instance of itself here **/
    private IndexPage indexPage;
    public IndexPage getIndexPage()
    {
    	if (indexPage == null)
        {
    		indexPage = new IndexPage();
        }
    	
        PageFactory.initElements(ATFHandler.getInstance().getWebAutomation().getWebDriver(), indexPage);
        return indexPage;
    }
    
    private ContactUsPage contactUsPage;
	public ContactUsPage getContactUsPage() {
    	if (contactUsPage == null)
        {
    		contactUsPage = new ContactUsPage();
        }
    	
        PageFactory.initElements(ATFHandler.getInstance().getWebAutomation().getWebDriver(), contactUsPage);
        return contactUsPage;
	}
}
