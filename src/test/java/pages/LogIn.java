package pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class LogIn {

    static Logger log = (Logger) LoggerFactory.getLogger(LogIn.class);
    WebDriverWait wait;

    public LogIn(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy(name = "email")
    WebElement loginEmailAddress;
    @FindBy(name = "password")
    WebElement loginPassword;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    WebElement loginLogInButton;
//    @FindBy(xpath = "//header[@id=\"header\"]/descendant::ul/descendant::li/descendant::a[contains(.,\"Logged in as\")]")
    @FindBy(xpath = "//*[contains(text(),\"Logged in as\")]")
    WebElement loginName;

//    @FindBy(xpath = "//header[contains(@id,'header')]/descendant::a[contains(.,'Products')]")
    @FindBy(xpath = "//*[contains(text(),'Products')]")
    WebElement productPageLink;
    public void setLoginEmailAddress(String value) {
        log.info("*****************************************************************");
        log.info("Login Page entered");

        loginEmailAddress.sendKeys(value);
        log.info("Email entered");
    }

    public void setLoginPassword(String value) {
        loginPassword.sendKeys(value);
        log.info("Password entered");
    }

    public void submit() {
        loginLogInButton.click();
        log.info("Login Button clicked");
    }

    public String loggedUserNameVisible(){
        String loggedUserName = loginName.getText();
        return loggedUserName;

    }

    public void openProductPage(){
        wait.until(ExpectedConditions.visibilityOf(productPageLink));
        productPageLink.click();
    }
}
