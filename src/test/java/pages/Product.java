package pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {

    static Logger log = (Logger) LoggerFactory.getLogger(Product.class);
    Actions actions;
    WebDriverWait wait;
    public Product(WebDriver driver){
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "search_product")
    WebElement searchProduct;
    @FindBy(id = "submit_search")
    WebElement searchClick;
//    @FindBy(xpath = "//div[@class=\"features_items\"]/descendant::div[@class=\"productinfo text-center\"]/descendant::a[@data-product-id]")
    @FindBy(xpath = "//*[@class=\"productinfo text-center\"]//a[@data-product-id]")
    List<WebElement> tshirtCollection;
//    @FindBy(xpath = "//div[@id=\"cartModal\"]/descendant::div/descendant::button[@data-dismiss=\"modal\"]")
    @FindBy(xpath = "//button[@data-dismiss=\"modal\"]")
    WebElement continueShop;

    @FindBy(xpath = "//div[@id=\"cartModal\"]")
    WebElement continuePage;
    @FindBy(xpath = "//div[@id=\"cartModal\"]/descendant::div/descendant::a[contains(.,\"View Cart\")]")
    WebElement viewCart;

    //This list store all tshirt ids visible on product page after search
    List<String> tshirtId = new ArrayList<>();

    public void searchProductFromSearchBar(String value){
        log.info("*****************************************************************");
        log.info("Product Page entered");

        wait.until(ExpectedConditions.visibilityOf(searchProduct));

        searchProduct.sendKeys(value);
        log.info("Wrote product to be searched in search bar");
    }


    public void clickSearchButton(){

        wait.until(ExpectedConditions.elementToBeClickable(searchClick));

        searchClick.click();
        log.info("Clicked the search button on product page");
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
        int tshirt1 = r.nextInt(length/2);
        int tshirt2 = r.nextInt(length/2, length);
//        int[] twoRandomNumbers = r.ints(2,0,length/2).toArray();


        actions.moveToElement(tshirtCollection.get(tshirt1));
        tshirtCollection.get(tshirt1).click();


        wait.until(ExpectedConditions.visibilityOf(continueShop));

        continueShop.click();

        wait.until(ExpectedConditions.visibilityOf(tshirtCollection.get(tshirt2)));
        actions.moveToElement(tshirtCollection.get(tshirt2));

        tshirtCollection.get(tshirt2).click();
        wait.until(ExpectedConditions.visibilityOf(viewCart));
        log.info("Added product in the cart");
        viewCart.click();
        log.info("Leaving product page");
        log.info("*****************************************************************");
    }

}
