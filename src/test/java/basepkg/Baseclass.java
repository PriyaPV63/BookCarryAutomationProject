package basepkg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Baseclass {
	 public static WebDriver driver;
	    public static ExtentReports extent;
	    public static ExtentSparkReporter reporter;

	    @BeforeSuite
	    public void startReport() {

	        // Path where report will be created
	        reporter = new ExtentSparkReporter("./Reports/BookCarry_Report.html");

	        // Report appearance
	        reporter.config().setDocumentTitle("Automation Report");
	        reporter.config().setReportName("Functional Test Report");

	        // Attach report
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);

	        // Optional info
	        extent.setSystemInfo("Project", "BookCarry");
	        extent.setSystemInfo("Tester", "Priya");
	        extent.setSystemInfo("Browser", "Chrome");
	    }

	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://bookcarry.com/");
		
	}
	@AfterSuite
    public void closeReport() {
        extent.flush();  // VERY IMPORTANT — Saves the report
    }
}


