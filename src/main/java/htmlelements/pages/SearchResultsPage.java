package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;

import java.util.List;

public interface SearchResultsPage extends ExtendedWebPage {
    @Description("List of search result products")
    @FindBy("//div[contains(@class, '_container_1r11ya')]")
    List<ExtendedMyWebElement> searchResults();
}
