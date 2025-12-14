package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pagepkg.Loginpage;
import pagepkg.Menupage;
import pagepkg.MyaccountandSearchpage;
import pagepkg.Shoppage;

public class Baseclass {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;

    //Page Object references (used in all tests)
    public Loginpage login;
    public Menupage menu;
    public MyaccountandSearchpage myacc;
    public Shoppage shop;

     @BeforeSuite
    public void startReport() {

        reporter = new ExtentSparkReporter("./Reports/BookCarry_Report.html");

        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Project", "BookCarry");
        extent.setSystemInfo("Tester", "Priya");
        extent.setSystemInfo("Browser", "Chrome");
    }

   @BeforeTest
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bookcarry.com/");

        System.out.println("=== Browser Launched ===");
    }

   @BeforeMethod
    public void createPageObjects() {

        //page objects ONCE for each test method
        login = new Loginpage(driver);
        menu = new Menupage(driver);
        myacc = new MyaccountandSearchpage(driver);
        shop = new Shoppage(driver);

        System.out.println("Page Objects Created for Test");
    }

   

    @AfterSuite
    public void closeReport() {
        extent.flush();
        System.out.println("=== Report Generated ===");
    }
}


