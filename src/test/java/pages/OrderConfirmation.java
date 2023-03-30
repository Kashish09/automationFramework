package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {

    public OrderConfirmation(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,\"/download_invoice\")]")
    WebElement invoiceDownload;

    public void downloadInvoice(){
        invoiceDownload.click();
    }
}
