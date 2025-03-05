package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

public interface CreateAccountPage extends ExtendedWebPage {

    @Description("Email input field")
    @FindBy("//input[@placeholder='Email']")
    ExtendedMyWebElement emailInput();

    @Description("First Name input field")
    @FindBy("//input[@class=\"form-control form-input-firstname autofill-detect\"]")
    ExtendedMyWebElement firstNameInput();

    @Description("Last Name input field")
    @FindBy("//input[@class=\"form-control form-input-lastname autofill-detect\"]")
    ExtendedMyWebElement lastNameInput();

    @Description("Mobile Number input field")
    @FindBy("//input[@class=\"form-control form-control form-input-phone-number\"]")
    ExtendedMyWebElement mobileNumberInput();

    @Description("Password input field")
    @FindBy("//div[@class=\"form-group aeo-input qa-input-password\"]//input")
    ExtendedMyWebElement passwordInput();

    @Description("Confirm Password input field")
    @FindBy("//div[@class=\"form-group aeo-input qa-input-confirm-password\"]//input")
    ExtendedMyWebElement confirmPasswordInput();

    @Description("Zip Code input field")
    @FindBy("//input[@class=\"form-control form-input-postal-code autofill-detect\"]")
    ExtendedMyWebElement zipCodeInput();

    @Description("Birthday Month dropdown")
    @FindBy("//select[@name=\"month\"]")
    ExtendedMyWebElement birthMonthDropdown();

    @Description("Birthday Day dropdown")
    @FindBy("//select[@name=\"day\"]")
    ExtendedMyWebElement birthDayDropdown();

    @Description("Terms & Conditions checkbox")
    @FindBy("//div[@data-test-checkbox='acceptTerms']")
    ExtendedMyWebElement termsCheckbox();

    @Description("Create account button")
    @FindBy("//button[@name='submit']")
    ExtendedMyWebElement createAccountSubmitButton();

    /*@Description("Success message after account creation")
    @FindBy("//h6[contains(@class, 'qa-notification-msg-title')]")
    ExtendedMyWebElement successMessage();*/
}
