package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

public interface LoginModal extends ExtendedWebPage {

    @Description("Email input field in login modal")
    @FindBy("//input[@name='username']")
    ExtendedMyWebElement emailInput();

    @Description("Password input field in login modal")
    @FindBy("//input[@name='password']")
    ExtendedMyWebElement passwordInput();

    @Description("Sign In button inside login modal")
    @FindBy("//button[@name='submit']")
    ExtendedMyWebElement signInButton();

    @Description("Error message for invalid login")
    @FindBy("//*[@class=\"alert-header alert-danger\"]")
    ExtendedMyWebElement errorMessage();
    //za prazna email i password polja: //*[@class="ember-view help-block qa-error-help-block has-error"]
    //kad izadje: We've encountered an unexpected error on our end. Please try again later.
    ////*[@class="ember-view help-block qa-error-help-block has-error _help-block_21ei9c"]
    // za to moze i ovo: //*[@class="alert-content"]

    @Description("Error message for valid login")
    @FindBy("//div[@class='alert-content']//ul//li")
    ExtendedMyWebElement errorMessage2();

    @Description("User's name displayed after login")
    @FindBy("//h2[@class=\"modal-title\"]") //ovde pise Nina's Account npr
    ExtendedMyWebElement userName();

    @Description("Sign Out button")
    @FindBy("//button[@name=\"sign-out\"]")
    ExtendedMyWebElement signOutButton();
}
