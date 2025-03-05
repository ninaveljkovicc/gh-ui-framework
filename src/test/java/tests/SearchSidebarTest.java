package tests;

//import htmlelements.MyPageFactory;
//import htmlelements.pages.HomePage;
import htmlelements.pages.SearchResultsPage;
import htmlelements.pages.SearchSidebar;
//import htmlelements.utils.WebElementUtils;
import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import selenium.WebDriverFactory;

import static org.junit.Assert.assertFalse;

public class SearchSidebarTest extends BaseTest{
    /*private WebDriver driver;
    private MyPageFactory pageFactory;

    @Before
    public void setUp() {
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        pageFactory = new MyPageFactory();
        driver.get("https://www.ae.com/");
    }

    @Test
    public void testSearchFunctionality() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        HomePage homePage = pageFactory.on(HomePage.class);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(homePage.searchButton()));
        Thread.sleep(2000);
        homePage.searchButton().click();
        System.out.println("Search button clicked on Homepage.");

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"modal-content _modal-content_1vao1q\"]")));
        System.out.println("Search Sidebar opened.");

        Thread.sleep(2000);
        SearchSidebar searchSidebar = pageFactory.on(SearchSidebar.class);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchSidebar.searchInput()));

        Thread.sleep(2000);
        //searchSidebar.searchInput().click();  // Focus the input field
        //Thread.sleep(2000);
        //searchSidebar.searchInput().sendKeys("3171-6055-106");
        WebElement searchInputElement = (WebElement) searchSidebar.searchInput();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", searchInputElement);
        System.out.println("Product ID entered.");

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(searchSidebar.searchSubmitButton()));
        Thread.sleep(2000);
        searchSidebar.searchSubmitButton().click();
        System.out.println("Search submitted successfully!");

        SearchResultsPage searchResultsPage = pageFactory.on(SearchResultsPage.class);
        //wait.until(ExpectedConditions.visibilityOfAllElements(searchResultsPage.searchResults()));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-content-focus\"]/div[2]/div[2]/div/div[2]/div/div")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"main-content-focus\\\"]/div[2]/div[2]/div/div[2]/div/div")));

        assert !searchResultsPage.searchResults().isEmpty();
        System.out.println("Search results are displayed successfully!");
    }

    @After
    public void tearDown() {
        WebDriverFactory.end();
    }*/

   /* @Test
    public void testSearchFunctionality() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(homePage.searchButton()));
        homePage.searchButton().click();
        System.out.println("Search button clicked on homepage");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"modal-dialog\"]")));
        System.out.println("Search Sidebar opened");
        ////*[@class="modal-content _modal-content_1vao1q"]
        ////*[@class="modal-dialog"]

        SearchSidebar searchSidebar = pageFactory.on(SearchSidebar.class);

        wait.until(ExpectedConditions.elementToBeClickable(searchSidebar.searchInput()));

        //WebElement searchInputElement = WebElementUtils.unwrapWebElement(searchSidebar.searchInput());
        WebElement searchInputElement = driver.findElement(By.xpath("//div[@class=\"modal-dialog\"]/div/div[2]/form/div[1]"));

        searchInputElement.sendKeys("3171-6055-106");
        System.out.println("Product ID entered");

        WebElement searchButtonElement = driver.findElement(By.xpath("//div[@class=\"modal-dialog\"]/div/div[2]/form/button"));
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchButtonElement.click();
        System.out.println("Search button clicked inside Sidebar");

        SearchResultsPage searchResultsPage = pageFactory.on(SearchResultsPage.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-content-focus\"]/div[2]/div[2]/div/div[2]/div/div")));

        assertFalse(searchResultsPage.searchResults().isEmpty());
        System.out.println("Search results are displayed successfully");
    }*/
}
