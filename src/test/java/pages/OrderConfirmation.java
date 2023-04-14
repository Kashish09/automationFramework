package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmation {

    WebDriverWait wait;
//    WebDriver driver;
    public OrderConfirmation(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
//        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@href,\"/download_invoice\")]")
    WebElement invoiceDownload;

    public void downloadInvoice(){
        wait.until(ExpectedConditions.elementToBeClickable(invoiceDownload));
        invoiceDownload.click();

    }
}
