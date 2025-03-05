package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SearchResultsPageSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

    private SearchResultsPage searchResultsPage(){
        return pageFactory.on(SearchResultsPage.class);
    }

    public SearchResultsPageSteps verifyNumberOfProductIsDisplayed(int expectedCount) throws InterruptedException {
        /*WebDriver driver = WebDriverFactory.get();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        List<WebElement> searchResultsElements = searchResultsPage().searchResults()
                .stream()
                .map(element -> (WebElement) element)
                .collect(Collectors.toList());

        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultsElements));
*/
        Thread.sleep(5000);
        int actualCount = searchResultsPage().searchResults().size();
        assertEquals("Number of products displayed is incorrect", expectedCount, actualCount);
        System.out.println("Verified " + expectedCount + " products displayed");

        return this;
    }
}
