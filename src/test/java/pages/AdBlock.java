package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdBlock {

    WebDriver driver;
    public AdBlock(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//iframe[contains(@name,'aswift') and contains(@style,'visibility: visible')]")
    WebElement frame;
    public void closeAd(){
        if(frame.isDisplayed()){
            driver.switchTo().frame(frame);
            try{
                WebElement button = driver.findElement(By.id("dismiss-button"));
                if(button.isDisplayed() && button.isEnabled()){
                    button.click();
                }
            } catch (Exception e) {
                if (driver.findElement(By.id("ad_iframe")).isDisplayed()) {
                    System.out.println("First");
                    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
                    driver.switchTo().frame(frame2);
                    System.out.println(driver.findElement(By.id("dismiss-button")));
                    WebElement button = driver.findElement(By.id("dismiss-button"));

                    button.click();
                    driver.switchTo().defaultContent();
                }
            }

//            WebElement frame1 = driver.findElement(By.id("ad_iframe"));
//            WebElement frame1 = driver.findElement(By.xpath("//iframe[contains(@id,'ad_iframe') and contains(@title,'Advertisement')]"));
//            driver.switchTo().frame(frame1);
//            if(driver.findElement(By.id("ad_iframe")).isDisplayed()) {
//                System.out.println("First");
//                WebElement frame2 = driver.findElement(By.id("ad_iframe"));
//                driver.switchTo().frame(frame2);
//                System.out.println(driver.findElement(By.id("dismiss-button")));
//                WebElement button = driver.findElement(By.id("dismiss-button"));
//
//                button.click();
//                driver.switchTo().defaultContent();
////                driver.switchTo().defaultContent();
//
//
//            }
//            else{
//                System.out.println("Second");
//                WebElement button = driver.findElement(By.id("dismiss-button"));
//                if (button.isDisplayed() && button.isEnabled()) {
//                    System.out.println(button.getText());
//                    button.click();
//                    driver.switchTo().defaultContent();
//                }
//            }

//            System.out.println(driver.findElement(By.id("dismiss-button")).getText());
//            actions.click(driverManager.getDriver().findElement(By.id("dismiss-button"))).perform();

        }
    }
}
