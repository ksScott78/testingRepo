import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmLoginPage {

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    WebElement loginBar;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    WebElement passBar;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    WebElement loginButton;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    WebElement loginConfirmation;

    public void login(){
        loginButton.click();
    }

    public void fillUserName(String uName){
        loginBar.sendKeys(uName);
    }

    public void fillPass(String pass){
        passBar.sendKeys(pass);
    }

    public String getMessage(){
        return loginConfirmation.getText();
    }
}
