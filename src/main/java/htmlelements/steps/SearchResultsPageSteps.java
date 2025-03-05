package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.SearchResultsPage;

import static org.junit.Assert.assertEquals;

public class SearchResultsPageSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

    private SearchResultsPage searchResultsPage(){
        return pageFactory.on(SearchResultsPage.class);
    }

    public SearchResultsPageSteps verifyNumberOfProductIsDisplayed(int expectedCount) throws InterruptedException {

        Thread.sleep(5000);
        int actualCount = searchResultsPage().searchResults().size();
        assertEquals("Number of products displayed is incorrect", expectedCount, actualCount);
        System.out.println("Verified " + expectedCount + " products displayed");

        return this;
    }
}
