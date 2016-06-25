package candystore.website;

import candystore.website.pageobjects.IndexPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class IndexPageTest {

	public IndexPage indexPage;
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethodSetup()
	{
		indexPage = (IndexPage)CandyStorePageFactory.getInstance(CandyStorePageFactory.INDEX);
		indexPage.load();
	}
	
    /**
     * Validate the expected logo for Candy Store is displayed
     */
    @Test(groups = { "smoke" } )
    public void candyStoreLogoIsDisplayed() {
        assertThat(indexPage.logoIsDisplayed()).isTrue();
    }
    
    /**
     * Validate the explanation of why we love candy is correct
     */
    @Test
    public void candyStoreExplanationValid() {
    	assertThat(indexPage.whyWeLoveCandyText()).contains("because it is sweet");
    }

    /**
     * Validate there is at least one article on the page displayed
     */
    @Test
    public void candyStoreArticleTitle() {
    	assertThat(indexPage.articleTitleIsDisplayed()).isTrue();
        assertThat(indexPage.articleTitleText()).containsIgnoringCase("June 29th 2014 by ATF Framework");
    }

    /**
     * Validate that there are 2 blockquotes on the page
     */
    @Test
    public void candyStoreBlockQuotes() {
        assertThat(indexPage.blockQuotesIsDisplayed()).isTrue();
        assertThat(indexPage.blockQuotesCount()).isEqualTo(2);
    }

    /**
     * Validate that only div tags utilize the clear class
     */
    @Test
    public void candyStoreClears() {
        assertThat(indexPage.clearsIsDisplayed()).isTrue();

        // Iterate through all the WebElements returned and check each one that
        // it is a 'div' tag
        for (String tagName : indexPage.clearsGetTags()) {
            assertThat(tagName).containsIgnoringCase("div");
        }
    }

    /**
     * Validate the Contact link menu is present on the page and pointing to the
     * right location
     */
    @Test
    public void candyStoreMenuContact() {
    	assertThat(indexPage.contactUsLinkIsDisplayed()).isTrue();
    	assertThat(indexPage.contactUsLinkIsEnabled()).isTrue();
    	assertThat(indexPage.contactUsLinkURL()).containsIgnoringCase("contact");
    }

    /**
     * Validate the Second Category link menu is on the page
     */
    @Test
    public void candyStoreMenuSecondCategory() {
    	assertThat(indexPage.secondCategoryIsDisplayed()).isTrue();;
    	assertThat(indexPage.secondCategoryIsEnabled()).isTrue();;
    	assertThat(indexPage.secondCategoryLinkURL()).containsIgnoringCase("underConstruction");
    }

    /**
     * Validate that the head tag on the page has the standard required tags
     * applied - title is required on all head tags by our standards
     */
    @Test
    public void candyStoryHeaderCheck() {
        assertThat(indexPage.headerTitle().length()).isEqualTo(0);
    }
}
