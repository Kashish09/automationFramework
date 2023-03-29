package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    public LogIn(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "email")
    WebElement loginEmailAddress;
    @FindBy(name = "password")
    WebElement loginPassword;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    WebElement loginLogInButton;
    @FindBy(xpath = "//header[@id=\"header\"]/descendant::ul/descendant::li/descendant::a[contains(.,\"Logged in as\")]")
    WebElement loginName;
    public void setLoginEmailAddress(String value) {
        loginEmailAddress.sendKeys(value);
    }

    public void setLoginPassword(String value) {
        loginPassword.sendKeys(value);
    }

    public void submit() {
        loginLogInButton.click();
    }

    public String loggedUserNameVisible(){
        String loggedUserName = loginName.getText();
        return loggedUserName;
//        System.out.println(loggedUserName);
    }
}
