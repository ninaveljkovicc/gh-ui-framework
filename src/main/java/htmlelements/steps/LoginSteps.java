package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.AccountSidebar;
import htmlelements.pages.HomePage;
import htmlelements.pages.LoginModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginSteps(){
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, 15);
    }

    private HomePage homePage(){
        return pageFactory.on(HomePage.class);
    }

    private AccountSidebar accountSidebar(){
        return pageFactory.on(AccountSidebar.class);
    }

    private LoginModal loginModal(){
        return pageFactory.on(LoginModal.class);
    }

    public LoginSteps openLoginModal(){
        WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(homePage().accountIcon()));
        accountIcon.click();
        System.out.println("Clicked account icon");

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(accountSidebar().signInButton()));
        signInButton.click();
        System.out.println("Clicked sign in button");
        return this;
    }

    public LoginSteps enterCredentials(String email, String password){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(loginModal().emailInput()));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(loginModal().passwordInput()));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        System.out.println("Entered email: " + email + " and password");

        return this;
    }

    public LoginSteps clickSignIn(){
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(loginModal().signInButton()));
        signInButton.click();
        System.out.println("Clicked sign in button");

        return this;
    }

    public LoginSteps verifyLoginSuccess(){

        WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(homePage().accountIcon()));
        accountIcon.click();
        System.out.println("Clicked Account icon to display account info");

        wait.until(ExpectedConditions.visibilityOf(loginModal().userName()));
        wait.until(ExpectedConditions.visibilityOf(loginModal().signOutButton()));

        assertTrue("User name is not displayed", loginModal().userName().isDisplayed());
        assertTrue("Sign out button is not displayed", loginModal().signOutButton().isDisplayed());

        System.out.println("Login successful. User name and sign out button are visible");
        return this;
    }

    public LoginSteps verifyLoginunSuccess(){

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginModal().errorMessage2()));
        String text = "We've encountered an unexpected error on our end. Please try again later.";

        assertEquals(text, errorMessage.getText());

        return this;
        ////div[@class='alert-content']
    }

    public LoginSteps verifyErrorMessage(String expectedMessage){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(loginModal().errorMessage()));

        assertEquals("Error message does not match", expectedMessage, errorMessage.getText());
        System.out.println("Verified message: " + expectedMessage);

        return this;
    }

    public LoginSteps clickSignOut() {
        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(loginModal().signOutButton()));
        signOutButton.click();
        System.out.println("Clicked Sign out button");
        return this;
    }
}
