package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    public Cart(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
