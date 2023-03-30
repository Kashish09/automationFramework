package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    public Checkout(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id=\"cart_items\"]/descendant::a[contains(@href,\"/payment\")]")
    WebElement order;

    public void placeTheOrder(){
        order.click();
    }
}
