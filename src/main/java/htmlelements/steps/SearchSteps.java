package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
//import htmlelements.pages.SearchResultsPage;
import htmlelements.pages.SearchSidebar;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

public class SearchSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, 15);
    }

    private SearchSidebar searchSidebar(){
        return pageFactory.on(SearchSidebar.class);
    }

    public SearchSteps inputSearchTerm(String term){
        try {
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOf(searchSidebar().searchInput()));

            if(searchInput.isDisplayed() && searchInput.isEnabled()){
                searchInput.clear();
                searchInput.sendKeys(term);
                System.out.println("Entered search term: " + term);
            } else {
                System.out.println("Search input is not interactable.");
            }
        } catch (TimeoutException e){
            System.out.println("Search input did not become interactable in time");
        }
        return this;
    }

    public SearchSteps clickSearchIcon(){


        searchSidebar().searchSubmitButton().click();
        System.out.println("Clicked search button in Search sidebar");

        return this;
    }

    public SearchResultsPageSteps goToSearchResults(){
        return new SearchResultsPageSteps();
    }
}
