package htmlelements.steps;

import context.ContextConstants;
import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.AccountCreatedPage;
import htmlelements.pages.CreateAccountPage;
import htmlelements.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverFactory;

public class CreateAccountSteps {

    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateAccountSteps() {
        this.driver = WebDriverFactory.get();
        this.wait = new WebDriverWait(driver, 15);
    }

    private CreateAccountPage createAccountPage() {
         return pageFactory.on(CreateAccountPage.class);
    }

    public CreateAccountSteps enterAccountDetails(String domain){

        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().emailInput()));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().firstNameInput()));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().lastNameInput()));
        WebElement mobileField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().mobileNumberInput()));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().passwordInput()));
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().confirmPasswordInput()));
        WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOf(createAccountPage().zipCodeInput()));
        WebElement birthMonthDropdown = wait.until(ExpectedConditions.visibilityOf(createAccountPage().birthMonthDropdown()));
        WebElement birthDayDropdown = wait.until(ExpectedConditions.visibilityOf(createAccountPage().birthDayDropdown()));

        String uniqueEmail = RandomUtils.generateRandomEmail(domain);

        emailField.click();
        firstNameField.click();
        emailField.sendKeys(uniqueEmail);
        firstNameField.sendKeys("Test");
        lastNameField.sendKeys("User");
        mobileField.sendKeys("4158675309");
        passwordField.sendKeys("uiframework2");
        confirmPasswordField.sendKeys("uiframework2");
        zipCodeField.sendKeys("93101");

        new Select(birthMonthDropdown).selectByVisibleText("May");
        new Select(birthDayDropdown).selectByVisibleText("10");

        WebElement h2Text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Sign Up for Emails & Texts']")));
        h2Text.click();

        System.out.println("Entered account details: Email = " + uniqueEmail);

        context.ScenarioContext.getInstance().put(ContextConstants.ACCOUNT_EMAIL, uniqueEmail);
        return this;
    }

    public CreateAccountSteps acceptTermsAndConditions(){
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(createAccountPage().termsCheckbox()));
        termsCheckbox.click();
        System.out.println("Accepted Terms & Conditions");
        return this;
    }

    public CreateAccountSteps submitRegistration(){
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(createAccountPage().createAccountSubmitButton()));
        submitButton.click();
        System.out.println("Clicked Submit button to create an account");
        return this;
    }

    public CreateAccountSteps verifyAccountCreated(){
        AccountCreatedPage accountCreatedPage = pageFactory.on(AccountCreatedPage.class);

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(accountCreatedPage.successMessage()));
        assert successMessage.isDisplayed();

        System.out.println("Account created successfully");
        return this;
    }
}
