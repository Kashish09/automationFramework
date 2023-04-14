package pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class Payment {

    static Logger log = (Logger) LoggerFactory.getLogger(Payment.class);

    WebDriverWait wait;
    WebDriver driver;
    public Payment(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;

    }

    @FindBy(xpath = "//div[@class=\"step-one\"]")
    WebElement pageName;
    @FindBy(name = "name_on_card")
    WebElement cardName;

    @FindBy(name = "card_number")
    WebElement cardNumber;

    @FindBy(name = "cvc")
    WebElement cvcNumber;

    @FindBy(name = "expiry_month")
    WebElement expirationMonth;

    @FindBy(name = "expiry_year")
    WebElement expirationYear;

    @FindBy(id = "submit")
    WebElement payAndConfirm;

    @FindBy(xpath = "//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]")
    WebElement adPopUp;

    @FindBy(xpath = "//descendant::div[@id=\"dismiss-button\"]")
    WebElement adClose;

    public String getPageName(){
        String name = pageName.getText();
        return name;
    }
    public void enterCardName(){

        log.info("*****************************************************************");
        log.info("Payment Page entered");
        try {
//            wait.until(ExpectedConditions.visibilityOf(cardName));
            wait.until(ExpectedConditions.visibilityOf(cardName));
        } catch (Exception e) {

        }
        cardName.sendKeys("qwerty");
        log.info("Card Name entered");
    }

    public void enterCardNumer(){
        cardNumber.sendKeys("1234567");
        log.info("Card Number entered");
    }

    public void enterCvcNumber(){
        cvcNumber.sendKeys("000");
        log.info("Card CVC number entered");
    }

    public void enterExpirationMonth(){
        expirationMonth.sendKeys("01");
        log.info("Card expiry month entered");
    }

    public void enterExpirationYear(){
        expirationYear.sendKeys("2030");
        log.info("Card expiry year entered");
    }

    public void payAndConfirmButton(){
//        Utils.WebElementWait.waitForElementToBeClickable(payAndConfirm);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", payAndConfirm);
//        payAndConfirm.click();
        log.info("Pay and Confirm Button clicked");
        log.info("Payment Page end");
        log.info("*****************************************************************");
    }

    public void adPopUpClose(){
//        adPopUp.click();
        if(adPopUp.isDisplayed()) {

            adClose.click();
        }
    }
}
