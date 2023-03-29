package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
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
}
