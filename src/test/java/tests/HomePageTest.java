package tests;

//import htmlelements.MyPageFactory;
import htmlelements.pages.CookieConsentModal;
import htmlelements.pages.HomePage;
//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import selenium.WebDriverFactory;

public class HomePageTest extends BaseTest{

    @Test
    public void testHomePageElements() throws InterruptedException {
        HomePage homePage = pageFactory.on(HomePage.class);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"onetrust-banner-sdk\"]")));

        WebElement consentButton = driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']"));
        wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButton.click();

        System.out.println("Don't Accept button clicked");

        wait.until(ExpectedConditions.elementToBeClickable(homePage.accountIcon()));
        assert homePage.accountIcon().isDisplayed();
        assert homePage.accountIcon().isEnabled();
        homePage.accountIcon().click();
        System.out.println("Account Icon clicked successfully");
        homePage.xButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.searchButton()));
        assert homePage.searchButton().isDisplayed();
        assert homePage.searchButton().isEnabled();
        homePage.searchButton().click();
        System.out.println("Search Button clicked successfully");
        homePage.xButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(homePage.cartIcon()));
        assert homePage.cartIcon().isDisplayed();
        assert homePage.cartIcon().isEnabled();
        homePage.cartIcon().click();
        System.out.println("Cart Icon clicked successfully");
    }
}
