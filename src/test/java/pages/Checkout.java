package pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class Checkout {

    static Logger log = (Logger) LoggerFactory.getLogger(Checkout.class);
    WebDriverWait wait;
    public Checkout(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

//    @FindBy(xpath = "//section[@id=\"cart_items\"]/descendant::a[contains(@href,\"/payment\")]")
    @FindBy(xpath = "//a[contains(@href,\"/payment\")]")
    WebElement order;

    public void placeTheOrder(){
        log.info("*****************************************************************");
        log.info("Checkout Page entered");
        wait.until(ExpectedConditions.elementToBeClickable(order));
        order.click();
        log.info("Leaving Checkout Page");
        log.info("*****************************************************************");
    }
}
