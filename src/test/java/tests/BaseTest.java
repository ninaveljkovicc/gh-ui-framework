package tests;

import context.ScenarioContext;
import htmlelements.MyPageFactory;
import htmlelements.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected MyPageFactory pageFactory;
    protected HomePage homePage;

    @Before
    public void setUp() {
        WebDriverFactory.initialize();
        driver = WebDriverFactory.get();
        pageFactory = new MyPageFactory();
        driver.get("https://www.ae.com/");
        homePage = pageFactory.on(HomePage.class);
    }

    @After
    public void tearDown() {
        WebDriverFactory.end();
        ScenarioContext.getInstance().removeAll();
    }
}
