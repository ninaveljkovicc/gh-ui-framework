package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

public interface AccountSidebar extends ExtendedWebPage {

    @Description("Sign in button on account sidebar")
    @FindBy("//div[@class=\"modal-body\"]/div/button")
    ExtendedMyWebElement signInButton();

    @Description("Create Account button")
    @FindBy("//div[@class=\"modal-body\"]/div/a")
    ExtendedMyWebElement createAccountButton();
}
