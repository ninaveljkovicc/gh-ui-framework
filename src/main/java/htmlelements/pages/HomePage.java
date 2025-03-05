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
    //*[@id="main-header"]/div/div[1]/ul/li[4]/a

    @Description("Search button in header")
    @FindBy("//*[@name=\"search-cta\"]")
    ExtendedWebElement searchButton();

    @Description("Cart icon in header")
    @FindBy("//a[@class='ember-view bag-button underline-on-hover qa-tnav-bag-icon']")
    ExtendedWebElement cartIcon();

    @Description("Cookie Consent Modal")
    //@FindBy("//*[@id=\"onetrust-banner-sdk\"]/div/div")
    @FindBy("//*[@id=\"onetrust-banner-sdk\"]")
    CookieConsentModal cookieConsent();

    @Description("Don't Accept Cookies button")
    //@FindBy("//div[contains(@class, 'onetrust-pc-dark-filter')]")
    @FindBy("//button[@id='onetrust-reject-all-handler']")
    ExtendedMyWebElement dontAcceptButton();
    //button[@id='onetrust-accept-btn-handler']

    @Description("Exit button in modal")
    @FindBy("//button[@data-test-btn='close']")
    ExtendedMyWebElement xButton();
}
