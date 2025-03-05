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
    //za prazan email i password polja

    @Description("Error message for 'valid' login")
    @FindBy("//div[@class='alert-content']//ul//li")
    ExtendedMyWebElement errorMessage2();
    //kad izadje: We've encountered an unexpected error on our end. Please try again later.

    @Description("User's name displayed after login")
    @FindBy("//h2[@class=\"modal-title\"]") //ovde pise Nina's Account npr
    ExtendedMyWebElement userName();

    @Description("Sign Out button")
    @FindBy("//button[@name=\"sign-out\"]")
    ExtendedMyWebElement signOutButton();
}
