package tests;

import context.ContextConstants;
import context.ScenarioContext;
import htmlelements.steps.LoginSteps;
import htmlelements.steps.OpenPageSteps;
import org.junit.Test;

public class CreateAndLoginTest extends BaseTest{

    @Test
    public void testCreateAccountAndLogin(){
        new OpenPageSteps()
                .openHomePage()
                .handleCookieConsent()
                .clickAccountIcon()
                .clickCreateAccount()
                .enterAccountDetails("gmail.com")
                .acceptTermsAndConditions()
                .submitRegistration();
                //.verifyAccountCreated();

        //new LoginSteps().clickSignOut();

        String createdEmail = ScenarioContext.getInstance().get(ContextConstants.ACCOUNT_EMAIL, String.class);
        System.out.println("Using created email for login: " + createdEmail);

        new OpenPageSteps()
                .openHomePage()
                .clickAccountIcon()
                .clickSignIn()
                .enterCredentials(createdEmail, "uiframework2")
                .clickSignIn()
                .verifyLoginunSuccess();
                //.clickSignOut();

        ScenarioContext.getInstance().removeAll();
    }
}
