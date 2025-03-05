package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.CookieConsentModal;
import htmlelements.pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

public class HomePageSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePageSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, 15);
    }

    private HomePage homePage(){
        return pageFactory.on(HomePage.class);
    }

    public HomePageSteps handleCookieConsent(){

        HomePage homePage = pageFactory.on(HomePage.class);
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.dontAcceptButton()));
        cookieButton.click();

        System.out.println("Don't Accept button clicked");

        return this;
    }

    public SearchSteps clickSearchButton(){
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(homePage().searchButton()));
        searchButton.click();
        System.out.println("Search button clicked on home page");

        return new SearchSteps();
    }

    public AccountSidebarSteps clickAccountIcon(){

        try {
            WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(homePage().accountIcon()));

            AccountSidebarSteps accountSidebarSteps = new AccountSidebarSteps();
            if(accountSidebarSteps.isAccountSidebarOpen()){
                System.out.println("Account sidebar is already open, skipping click");
                return accountSidebarSteps;
            }

            accountIcon.click();
            System.out.println("Account icon clicked on home page");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"modal-body\"]/div/button")));
        } catch (Exception e) {
            System.out.println("Account icon click intercepted. Retrying with JavaScript");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", homePage().accountIcon());
        }

        return new AccountSidebarSteps();
    }
}
