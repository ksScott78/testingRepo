import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private String url = "http://thedemosite.co.uk";
    private WebDriver webDriver;

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void qaTest() throws InterruptedException{
        //Navigate to site and go to add user page.
        webDriver.navigate().to(url);
        WebElement link = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        link.click();
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl="http://thedemosite.co.uk/addauser.php";
        Assert.assertEquals(currentUrl, expectedUrl);

        //Enter login information and click on the save button
        WebElement username = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        WebElement password = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        username.sendKeys("test1");
        password.sendKeys("pass1");
        WebElement saveDetails = webDriver.findElement((By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")));
        saveDetails.click();
        WebElement goToLogin = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        goToLogin.click();

        //Now on login page attempt login with new details and assert it was done correctly.
        WebElement loginUsr = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        WebElement loginPass = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        loginUsr.sendKeys("test1");
        loginPass.sendKeys("pass1");
        WebElement confirmLogin = webDriver.findElement(By.cssSelector(("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")));
        confirmLogin.click();

        //Now we have hopefully logged in. Check the return message for successful login.
        WebElement message = webDriver.findElement(By.cssSelector(("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")));
        String returnedMessage = message.getText();
        String loggedIn = "**Successful Login**";
        Thread.sleep(2000);
        Assert.assertEquals(loggedIn,returnedMessage);

    }
}
