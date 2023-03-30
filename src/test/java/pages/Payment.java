package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {

    public Payment(WebDriver driver){
        PageFactory.initElements(driver, this);
//        driver.getWindowHandle();
    }

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

//    @FindBy(xpath = "//div[@id=\"ad_position_box\"]/descendant::div[@id=\"heading\"]")
//    @FindBy(xpath = "//descendant::div[@id=\"ad_position_box\"]/descendant::div[@id=\"creative\"]")
    @FindBy(xpath = "//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]")
    WebElement adPopUp;

    @FindBy(xpath = "//descendant::div[@id=\"dismiss-button\"]")
    WebElement adClose;
    public void enterCardName(){
        cardName.sendKeys("qwerty");
    }

    public void enterCardNumer(){
        cardNumber.sendKeys("1234567");
    }

    public void enterCvcNumber(){
        cvcNumber.sendKeys("000");
    }

    public void enterExpirationMonth(){
        expirationMonth.sendKeys("01");
    }

    public void enterExpirationYear(){
        expirationYear.sendKeys("2030");
    }

    public void payAndConfirmButton(){
        payAndConfirm.click();
    }

    public void adPopUpClose(){
//        adPopUp.click();
        if(adPopUp.isDisplayed()) {

            adClose.click();
        }
    }
}
