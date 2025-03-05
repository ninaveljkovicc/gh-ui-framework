package htmlelements.pages;

import htmlelements.ExtendedMyWebElement;
import htmlelements.ExtendedWebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;

public interface HomePage extends ExtendedWebPage {

    @Description("Account icon in header menu")
    @FindBy("//li[contains(@class, 'account')]")
    ExtendedMyWebElement accountIcon();

    @Description("Search button in header")
    @FindBy("//*[@name=\"search-cta\"]")
    ExtendedWebElement searchButton();

    @Description("Cart icon in header")
    @FindBy("//a[@class='ember-view bag-button underline-on-hover qa-tnav-bag-icon']")
    ExtendedWebElement cartIcon();

    @Description("Cookie Consent Modal")
    @FindBy("//*[@id=\"onetrust-banner-sdk\"]")
    CookieConsentModal cookieConsent();

    @Description("Don't Accept Cookies button")
    @FindBy("//button[@id='onetrust-reject-all-handler']")
    ExtendedMyWebElement dontAcceptButton();

    @Description("Exit button in modal")
    @FindBy("//button[@data-test-btn='close']")
    ExtendedMyWebElement xButton();
}
