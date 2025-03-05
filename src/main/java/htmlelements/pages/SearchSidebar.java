package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;

public interface SearchSidebar extends ExtendedWebPage {

    @Description("Search input field")
    @FindBy("//input[@name='search']")
    ExtendedMyWebElement searchInput();

    @Description("Search button in sidebar")
    @FindBy("//button[@name='submit']")
    ExtendedMyWebElement searchSubmitButton();
}
