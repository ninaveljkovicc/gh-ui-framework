package tests;

import htmlelements.steps.OpenPageSteps;
import org.junit.Test;

public class CreateAccountTest extends BaseTest{

    @Test
    public void testCreateValidAccount(){
        new OpenPageSteps()
                .openHomePage()
                .handleCookieConsent()
                .clickAccountIcon()
                .clickCreateAccount()
                .enterAccountDetails("gmail.com")
                .acceptTermsAndConditions()
                .submitRegistration();
                //.verifyAccountCreated();
    }
}
