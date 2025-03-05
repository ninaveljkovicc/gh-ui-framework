package htmlelements.steps;

import config.ConfigurationProvider;
import htmlelements.MyPageFactory;
import htmlelements.MyPageFactoryProvider;
import htmlelements.pages.HomePage;
import selenium.WebDriverFactory;

public class OpenPageSteps {
    private static final MyPageFactory pageFactory = MyPageFactoryProvider.getInstance();

    private HomePage homePage(){
        return pageFactory.on(HomePage.class);
    }

    public HomePageSteps openHomePage(){
        String homePageUrl = ConfigurationProvider.getEnvironmentConfig().homepageUrl();
        WebDriverFactory.get().get(homePageUrl);
        System.out.println("Opened home page: " + homePageUrl);
        return new HomePageSteps();
    }
}
