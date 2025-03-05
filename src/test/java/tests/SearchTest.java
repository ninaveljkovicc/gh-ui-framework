package tests;

import htmlelements.steps.OpenPageSteps;
import org.junit.Test;

public class SearchTest extends BaseTest{

    @Test
    public void testProductSearch() throws InterruptedException {
        new OpenPageSteps()
                .openHomePage()
                .handleCookieConsent()
                .clickSearchButton()
                .inputSearchTerm("3171-6055-106")
                .clickSearchIcon()
                .goToSearchResults()
                .verifyNumberOfProductIsDisplayed(1);
    }
}
