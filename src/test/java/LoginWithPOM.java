import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginWithPOM {

    private String url = "http://thedemosite.co.uk";
    private WebDriver webDriver;
    private static ExtentReports report;
    private SpreadSheetReader spreadSheetReader;

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        spreadSheetReader = new SpreadSheetReader("testingValues.xlsx");
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Test
    public void qaTest() throws AssertionError, IOException {

        List<String> row = spreadSheetReader.readRow(0,"Sheet1");
        String username = row.get(0);
        String password = row.get(1);
        String loginCon = row.get(2);


        ExtentTest test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "Starting Test");
        test.log(Status.DEBUG, "Initialising test and navigating to correct page.");

        webDriver.navigate().to(url);
        //PAGE1
        HomePage start = PageFactory.initElements(webDriver,HomePage.class);
        start.moveToAddUser();
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl="http://thedemosite.co.uk/addauser.php";
        Assert.assertEquals(currentUrl, expectedUrl);
        //PAGE2
        LoginPage createUser = PageFactory.initElements(webDriver,LoginPage.class);
        createUser.setUserBar(username);
        createUser.setPassBar(password);
        createUser.createUser();
        createUser.moveToLogin();
        //PAGE3
        ConfirmLoginPage confirm = PageFactory.initElements(webDriver,ConfirmLoginPage.class);
        confirm.fillUserName(username);
        confirm.fillPass(password);
        confirm.login();
        //Confirm everything worked
        String expected ="**Successful Login**";
        try{
            Assert.assertEquals(expected,loginCon);
            test.log(Status.INFO, "Login Successful");
            test.log(Status.DEBUG, "Login Confirmed and Web elements found");
        }
        catch(AssertionError e){
            test.log(Status.INFO,"Login Has Failed");
            test.log(Status.DEBUG, e.toString());
            ScreenShot shot = new ScreenShot();
            String imagePath = shot.take(webDriver,"errorScreenshot");
            test.addScreenCaptureFromPath(imagePath);
        }
        finally {
            test.log(Status.INFO, "Test Completed");
        }
    }


}
