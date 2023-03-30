package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {

    Actions actions;
    public Product(WebDriver driver){
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(id = "search_product")
    WebElement searchProduct;
    @FindBy(id = "submit_search")
    WebElement searchClick;
    @FindBy(xpath = "//div[@class=\"features_items\"]/descendant::div[@class=\"productinfo text-center\"]/descendant::a[@data-product-id]")
    List<WebElement> tshirtCollection;
    @FindBy(xpath = "//div[@id=\"cartModal\"]/descendant::div/descendant::button[@data-dismiss=\"modal\"]")
    WebElement continueShop;

    @FindBy(xpath = "//div[@id=\"cartModal\"]")
    WebElement continuePage;
    @FindBy(xpath = "//div[@id=\"cartModal\"]/descendant::div/descendant::a[contains(.,\"View Cart\")]")
    WebElement viewCart;

    //This list store all tshirt ids visible on product page after search
    List<String> tshirtId = new ArrayList<>();

    public void searchProductFromSearchBar(String value){
        searchProduct.sendKeys(value);
    }


    public void clickSearchButton(){
        searchClick.click();
    }

    public void addTshirtsToCart(){
        int length = tshirtCollection.size();

        //Variable to be used in while loop for storing all tshirt ids into list
        int i = 0;
        while(i < length){
            tshirtId.add(tshirtCollection.get(i).getAttribute("data-product-id"));
            i++;
        }

        //Random function to generate two numbers at random for selecting different tshirts at every run
        Random r = new Random();
        int[] twoRandomNumbers = r.ints(2,0,6).toArray();

        actions.moveToElement(tshirtCollection.get(twoRandomNumbers[0]));
        tshirtCollection.get(twoRandomNumbers[0]).click();


        actions.moveToElement(continueShop);
        actions.click(continueShop);
        actions.moveToElement(tshirtCollection.get(twoRandomNumbers[1]));
        tshirtCollection.get(twoRandomNumbers[1]).click();
        viewCart.click();
    }

}
