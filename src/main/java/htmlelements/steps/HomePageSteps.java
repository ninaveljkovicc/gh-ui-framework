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
        /*try{
            CookieConsentModal cookieConsent = homePage().cookieConsent();

            if (cookieConsent == null) {
                System.out.println("Cookie consent modal is null");
                return this;
            }

            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieConsent.dontAcceptButton()));
            //WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(cookieConsent.dontAcceptButton().getWrappedElement().getCoordinates()));

            if(cookieButton.isDisplayed() && cookieButton.isEnabled()){
                System.out.println("Cookie modal appeared, clicking 'Don't Accept'");
                cookieButton.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieButton));
            }
        } catch (TimeoutException e) {
            System.out.println("No cookie consent modal appeared");
        } catch (NullPointerException e) {
            System.out.println("Cookie modal reference was null.");
        }*/

        HomePage homePage = pageFactory.on(HomePage.class);
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.dontAcceptButton()));
        cookieButton.click();

        /*WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onetrust-banner-sdk\"]")));

        WebElement consentButton = driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']"));
        wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButton.click();*/

        System.out.println("Don't Accept button clicked");

        return this;
    }

    public SearchSteps clickSearchButton(){
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(homePage().searchButton()));
        searchButton.click();
        //homePage().searchButton().click();
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
