package htmlelements.pages;

import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import htmlelements.ExtendedMyWebElement;

public interface AccountCreatedPage extends ExtendedWebPage {
    @Description("Success message after account creation")
    @FindBy("//h6[contains(@class, 'qa-notification-msg-title')]")
    ExtendedMyWebElement successMessage();
}
