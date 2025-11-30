package testpkg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import pagepkg.LinksCountPage;

public class LinksCountTest extends Baseclass{
	 @Test
	    public void verifyAllLinks() {
		 ExtentTest test = extent.createTest("Verify All Links on BookCarry");
		 test.info("Navigating to BookCarry homepage");
		

	        driver.get("https://bookcarry.com/");
	        

	        LinksCountPage lp = new LinksCountPage(driver);
	        test.info("Counting all links in the page");

	        int count = lp.getLinksCount();
	        test.pass("Total links found: " + count);

	        test.info("Printing all links in console");
	        System.out.println("Total number of links : " + count);

	        lp.printAllLinks();
	        test.pass("All links printed successfully");
	    }
	}
