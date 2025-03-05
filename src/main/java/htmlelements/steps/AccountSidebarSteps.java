package htmlelements.steps;

import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.AccountSidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

public class AccountSidebarSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AccountSidebarSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, 15);
    }

    private AccountSidebar accountSidebar() {
        return pageFactory.on(AccountSidebar.class);
    }

    public LoginSteps clickSignIn(){
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(accountSidebar().signInButton()));
        signInButton.click();
        System.out.println("Clicked Sign In button on Account Sidebar");
        return new LoginSteps();
    }

    public boolean isAccountSidebarOpen(){
        try{
            return accountSidebar().signInButton().isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public CreateAccountSteps clickCreateAccount(){
        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class=\"modal-body\"]/div/a"))));
        createAccountButton.click();
        System.out.println("Clicked 'Create Account' button");

        //wait.until(ExpectedConditions.urlContains("create-account"));

        return new CreateAccountSteps();
    }
}
