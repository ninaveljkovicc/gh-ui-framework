package htmlelements.utils;

import io.qameta.htmlelements.handler.WebBlockMethodHandler;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class WebElementUtils {
    public static WebElement unwrapWebElement(Object proxyElement) {
        if (Proxy.isProxyClass(proxyElement.getClass())) {
            InvocationHandler handler = Proxy.getInvocationHandler(proxyElement);
            if (handler instanceof WebBlockMethodHandler) {
                try {
                    Field elementField = WebBlockMethodHandler.class.getDeclaredField("element");
                    elementField.setAccessible(true);
                    return (WebElement) elementField.get(handler);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException("Failed to unwrap WebElement from proxy", e);
                }
            }
        }
        throw new IllegalArgumentException("Unable to unwrap WebElement from proxy");
    }
}
