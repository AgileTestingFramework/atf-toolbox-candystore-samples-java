package candystore.website.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.Fail;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

import atf.toolbox.ATFHandler;
import atf.toolbox.managers.ConfigurationManager;

public class IndexPage extends LoadableComponent<IndexPage>{

    @FindBy(id = "candyStoreLogo")
    private WebElement logo;

    @FindBy(name = "whyWeLoveCandy")
    private WebElement whyWeLoveCandy;

    @FindBy(css = "#main.clear")
    private WebElement articleTitle;

    @FindBy(xpath = "//blockquote[@cite]")
    private List<WebElement> blockQuotes;

    @FindBy(className = "clear")
    private List<WebElement> clears;
    
    @FindBy(linkText = "Contact Us")
    private WebElement contactUsLink;
	
    @FindBy(partialLinkText = "Second")
    private WebElement secondCategory;
    
   @FindBy(tagName = "head")
    private WebElement headerTag;
	
	@Override
	public void load() {
		ATFHandler.getInstance().getWebAutomation().getWebDriver().get(ConfigurationManager.getInstance().getWebBaseUrl());
		isLoaded();
	}

	@Override
	protected void isLoaded() throws Error {
		
	}
	
	/**
	 * logoIsDisplayed
	 * @return TRUE if the logo is displayed, FALSE if the logo is not displayed
	 */
	public boolean logoIsDisplayed()
	{
		try { return logo.isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.Logo", ex);
		}
		
		return false;
	}

	public String whyWeLoveCandyText() {
		try { return whyWeLoveCandy.getText(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.whyWeLoveCandy", ex);
		}
		
		return "";
	}
	
	/**
	 * articleTitleIsDisplayed
	 * @return TRUE if the article title is displayed, FALSE if the article title is not displayed
	 */
	public boolean articleTitleIsDisplayed()
	{
		try { return articleTitle.isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.ArticleTitle", ex);
		}
		
		return false;
	}

	public String articleTitleText() {
		try { return articleTitle.getText(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.articleTitle", ex);
		}
		
		return "";
	}
	
	/**
	 * blockQuoteIsDisplayed
	 * @return TRUE if the block quote is displayed, FALSE if the block quote is not displayed
	 */
	public boolean blockQuotesIsDisplayed()
	{
		try { return blockQuotes.get(0).isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.BlockQuote", ex);
		}
		
		return false;
	}
	
	/**
	 * blockQuoteCount
	 * @return count of block quotes found
	 */
	public int blockQuotesCount()
	{
		try { return blockQuotes.size(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.BlockQuote", ex);
		}
		
		return 0;
	}

	/**
	 * clearsIsDisplayed
	 * @return TRUE if the clears are displayed, FALSE if clears are not displayed
	 */
	public boolean clearsIsDisplayed()
	{
		try { return clears.get(0).isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.Clears", ex);
		}
		
		return false;
	}
	
	/**
	 * clearsIsDisplayed
	 * @return TRUE if the clears are displayed, FALSE if clears are not displayed
	 */
	public List<String> clearsGetTags()
	{
		List<String> tags = new ArrayList<String>();
		
		try { 
			for (WebElement clear : clears) {
				tags.add(clear.getTagName());
			}
		}
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.Clear", ex);
		}
		
		return tags;
	}
	
	/**
	 * clickContactUsLink
	 * Locate then click on the link
	 */
	public void clickContactUsLink()
	{
		try { contactUsLink.click(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.ContactUsLink", ex);
		}
	}
	
	/**
	 * contactUsLinkIsDisplayed
	 * @return TRUE if the contactUsLink is displayed, FALSE if contactUsLink is not displayed
	 */
	public boolean contactUsLinkIsDisplayed()
	{
		try { return contactUsLink.isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.ContactUsLink", ex);
		}
		
		return false;
	}
	
	/**
	 * contactUsLinkIsEnabled
	 * @return TRUE if the contactUsLink is enabled, FALSE if contactUsLink is not enabled
	 */
	public boolean contactUsLinkIsEnabled()
	{
		try { return contactUsLink.isEnabled(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.ContactUsLink", ex);
		}
		
		return false;
	}
	
	/**
	 * contactUsLinkURL
	 * @return link url
	 */
	public String contactUsLinkURL()
	{
		try { return contactUsLink.getAttribute("href").toString(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.ContactUsLink", ex);
		}
		
		return "";
	}
	
	/**
	 * secondCategoryIsDisplayed
	 * @return TRUE if the secondCategory is displayed, FALSE if secondCategory is not displayed
	 */
	public boolean secondCategoryIsDisplayed()
	{
		try { return secondCategory.isDisplayed(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.SecondCategory", ex);
		}
		
		return false;
	}
	
	/**
	 * secondCategoryIsEnabled
	 * @return TRUE if the secondCategory is enabled, FALSE if secondCategory is not enabled
	 */
	public boolean secondCategoryIsEnabled()
	{
		try { return contactUsLink.isEnabled(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.SecondCategory", ex);
		}
		
		return false;
	}
	
	/**
	 * secondCategoryLinkURL
	 * @return link url
	 */
	public String secondCategoryLinkURL()
	{
		try { return secondCategory.getAttribute("href").toString(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.SecondCategory", ex);
		}
		
		return "";
	}
	
	/**
	 * headerTitle
	 * @return title
	 */
	public String headerTitle()
	{
		try { return headerTag.getAttribute("title").toString(); }
		catch (StaleElementReferenceException | NoSuchElementException ex)
		{
			Fail.fail("IndexPage.headerTag", ex);
		}
		
		return "";
	}
}
