package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().setup();
//            WebDriverManager.edgedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--incognito");
//            driver = new ChromeDriver(options);
//            driver = new EdgeDriver();
//            System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
//            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            capabilities.setCapability("marionette",true);
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    public void launchApplication(){

        getDriver().get("https://www.automationexercise.com/login");
    }

    public void productPageLaunch(){
        getDriver().get("https://www.automationexercise.com/products");
    }


    public void tearDown(){
        driver.quit();
        WebDriverManager.chromedriver().quit();
//        driver = null;
    }
}
