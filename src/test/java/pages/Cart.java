package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cart {

    public Cart(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    String productID;
    @FindBy(xpath = "//table[@id=\"cart_info_table\"]/descendant::tbody/descendant::tr")
    List<WebElement> cartRows;

//    @FindBy(xpath = "//table[@id=\"cart_info_table\"]/descendant::tbody/descendant::tr/descendant::a[@data-product-id=$productID]")
//    WebElement deleteButton;

    @FindBy(xpath = "//section[@id=\"do_action\"]/descendant::a[contains(.,\"Proceed To Checkout\")]")
    WebElement checkout;
    List<String> tshirtToRemoveFromCart = new ArrayList<>();


    public void deleteOneTshirtFromCart(){
        int cartSize = cartRows.size();
        Random r = new Random();
        int tshirtRemoval = r.nextInt(cartSize);

        String productIDComplete = cartRows.get(tshirtRemoval).getAttribute("id");
        String[] splittingProductID = productIDComplete.split("-");
        productID = splittingProductID[1];
//        deleteButton.click();

        cartRows.get(tshirtRemoval).findElement(By.xpath("//descendant::tr/descendant::a[@data-product-id]")).click();

    }

    public void proceedToCheckout(){
        checkout.click();
    }

}
