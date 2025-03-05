package config;

import org.openqa.selenium.WebDriver;
import selenium.WebDriverFactory;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Homepage URL: " + ConfigurationProvider.getEnvironmentConfig().homepageUrl());
        System.out.println("Browser Name: " + ConfigurationProvider.getRunConfiguration().browserName());
        System.out.println("Browser Width: " + ConfigurationProvider.getRunConfiguration().browserWidth());
        System.out.println("Browser Height: " + ConfigurationProvider.getRunConfiguration().browserHeight());
        System.out.println("Selenium Version: " + ConfigurationProvider.getRunConfiguration().seleniumVersion());

        System.out.println(ConfigurationProvider.getEnvironmentConfig().homepageUrl());
        System.out.println(ConfigurationProvider.getRunConfiguration().browserName());


        WebDriverFactory.initialize();

        WebDriver driver = WebDriverFactory.get();

        //driver.get("https://www.google.com");
        driver.get("https://www.google.co.uk/");
        System.out.println("Opened google successfully");

        WebDriverFactory.end();
    }
}
