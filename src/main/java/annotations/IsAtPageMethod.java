package annotations;

import config.ConfigurationProvider;
import io.qameta.htmlelements.context.Context;
import io.qameta.htmlelements.exception.WebPageException;
import io.qameta.htmlelements.extension.MethodHandler;
import io.qameta.htmlelements.util.WebDriverUtils;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Method;

import static io.qameta.htmlelements.context.Store.DRIVER_KEY;

public @interface IsAtPageMethod {

    class Extension implements MethodHandler {

        @Override
        public Object handle(Context context, Object proxy, Method method, Object[] args) {
            WebDriver driver = context.getStore().get(DRIVER_KEY, WebDriver.class)
                    .orElseThrow(() -> new WebPageException("HtmlElements handler: WebDriver missing!"));

            String pageNotLoadedMessage = getLoadTimeoutDetails(args);
            Matcher<String> urlMatcher = getUrlMatcher(args);

            int timeout = ConfigurationProvider.getRunConfiguration().pageLoadTimeout();
            new WebDriverWait(driver, timeout) // TODO: Create timeout as configurable property
                    .withMessage(pageNotLoadedMessage)
                    .ignoring(Throwable.class)
                    .until((driver1) -> (driver != null && urlMatcher.matches(driver.getCurrentUrl()) &&
                            WebDriverUtils.pageIsLoaded(driver)));
            return proxy;
        }

        private static String getLoadTimeoutDetails(final Object[] args) {
            int timeout = ConfigurationProvider.getRunConfiguration().pageLoadTimeout();
            String url = args != null && args.length > 0 ? String.valueOf(args[0]) : null;
            return String.format("Page \"%s\" was not loaded in %s seconds!", url, timeout); // TODO: Create timeout as configurable property
        }

        private static Matcher<String> getUrlMatcher(final Object... args) {
            return args != null && args.length > 0 ? (Matcher<String>) args[0] : null;
        }
    }

}
