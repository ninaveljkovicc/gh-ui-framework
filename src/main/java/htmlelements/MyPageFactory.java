package htmlelements;

import config.ConfigurationProvider;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import io.qameta.htmlelements.statement.RetryStatement;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;

public class MyPageFactory {

    public <T extends WebPage> T on(Class<T> webpage) {

        WebPageFactory webPageFactory = new WebPageFactory();
        int timeout = ConfigurationProvider.getRunConfiguration().pageLoadTimeout();
        webPageFactory.property(RetryStatement.TIMEOUT_KEY, String.valueOf(timeout));
        return webPageFactory.get(getDriver(), webpage);
    }

    public WebDriver getDriver() {
        return WebDriverFactory.get();
    }

}
