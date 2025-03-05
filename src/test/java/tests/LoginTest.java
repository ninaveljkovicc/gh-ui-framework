package tests;

import htmlelements.steps.OpenPageSteps;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testEmptyEmailAndPassword(){
        new OpenPageSteps()
                .openHomePage()
                .handleCookieConsent()
                .clickAccountIcon()
                .clickSignIn()
                .clickSignIn()
                .verifyErrorMessage("Hold up, there's a problem.");
    }

    @Test
    public void testValidLogin(){
        new OpenPageSteps()
                .openHomePage()
                .handleCookieConsent()
                .clickAccountIcon()
                .clickSignIn()
                .enterCredentials("ninaveljkovic999@gmail.com", "uiframework2")
                .clickSignIn()
                .verifyLoginunSuccess();
    }
}
