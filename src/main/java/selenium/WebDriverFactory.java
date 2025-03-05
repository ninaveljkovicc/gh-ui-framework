package selenium;

import config.ConfigurationProvider;
import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static WebDriver driver;

    public static void initialize(){
        if(driver != null){
            System.out.println("WebDriver is already initialized");
            return;
        }

        String browserName = ConfigurationProvider.getRunConfiguration().browserName();
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser){
            case CHROME:
                driver = createChromeDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        int width = ConfigurationProvider.getRunConfiguration().browserWidth();
        int height = ConfigurationProvider.getRunConfiguration().browserHeight();
        driver.manage().window().setSize(new Dimension(width, height));

        System.out.println("WebDriver initialized successfully");
    }

    private static WebDriver createChromeDriver(){
        String seleniumVersion = ConfigurationProvider.getRunConfiguration().seleniumVersion();

        WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().forceDownload();

        if(seleniumVersion != null && !seleniumVersion.isEmpty()){
            WebDriverManager.chromedriver().driverVersion(seleniumVersion).setup();
        }
        else {
            WebDriverManager.chromedriver().setup();
        }
        ChromeOptions options = new ChromeOptions();
        //options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        //options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        //options.addArguments("--headless");
        options.addArguments("--incognito");

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(){
        String seleniumVersion = ConfigurationProvider.getRunConfiguration().seleniumVersion();
        if(seleniumVersion != null && !seleniumVersion.isEmpty()){
            WebDriverManager.firefoxdriver().driverVersion(seleniumVersion).setup();
        } else {
            WebDriverManager.firefoxdriver().setup();
        }
        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
        return new FirefoxDriver();
    }

    public static void end(){
        if(driver != null){
            driver.quit();
            driver = null;
            System.out.println("WebDriver session ended");
        }
    }

    public static WebDriver get(){
        if(driver == null){
            throw new IllegalStateException("WebDriver is not initialized");
        }
        return driver;
    }
}
