import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    WebElement userBar;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    WebElement passBar;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    WebElement loginButton;

    @FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
    WebElement goToLogin;



    public void setUserBar(String uName){
        userBar.sendKeys(uName);
    }

    public void setPassBar(String pass){
        passBar.sendKeys(pass);
    }

    public void createUser(){
        loginButton.click();
    }

    public void moveToLogin(){
        goToLogin.click();
    }



}
