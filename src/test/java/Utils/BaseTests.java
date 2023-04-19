package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            //Chrome WebDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

            //Edge WebDriver
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();

            //Firefox WebDriver
//            WebDriverManager.firefoxdriver().setup();
//            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            capabilities.setCapability("marionette",true);
//            driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }


    public void launchApplication(){

        getDriver().get("https://www.automationexercise.com/login");
    }

}
