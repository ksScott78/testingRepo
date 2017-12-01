import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

    private String url = "https://github.com/login";
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
    public void qaTest(){
        webDriver.navigate().to(url);
        WebElement username = webDriver.findElement(By.cssSelector("#login_field"));
        WebElement password = webDriver.findElement(By.cssSelector("#password"));
        username.sendKeys("ksScott78");
        password.sendKeys("");
        WebElement link = webDriver.findElement(By.cssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block"));
        link.click();
        String userSignedIn = "ksScott78";
        WebElement checkUser = webDriver.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > summary"));
        checkUser.click();
        WebElement goToProfile = webDriver.findElement(By.cssSelector("  #user-links > li:nth-child(3) > details > ul > li:nth-child(3) > a"));
        goToProfile.click();
        String currentUrl = webDriver.getCurrentUrl();
        String expected = "https://github.com/ksScott78";
        Assert.assertEquals(expected,currentUrl);
    }
}
