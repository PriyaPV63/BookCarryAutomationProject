package testpkg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import pagepkg.Shoppage;

public class ShopTest extends Baseclass {
	 @BeforeClass 
	    public void navigateToBookCarry() {
		 ExtentTest test = extent.createTest("Navigating to homepage");
	        // Navigate to the BookCarry homepage
		 test.info("navigating to homepage");
	        driver.get("https://bookcarry.com/");
	        test.info("navigated successfully");
	    }
	   
	 @Test
	    public void shoppingFlowTest() throws InterruptedException {
		 ExtentTest test = extent.createTest("Shopping flow test");

	        Shoppage sp = new Shoppage(driver);

	        // SHOPPING STEPS
		 test.info("clicking shopping");
	        sp.shopping();

	        // BILLING DETAILS FILLING
		 test.info("Entring billing address");
	        sp.billingaddress(
	                "Priya",           // First Name
	                "P",               // Last Name
	                "India",           // Country
	                "House 123",       // Address
	                "Kochi",           // City
	                "Kerala",          // State
	                "679521",          // Pincode
	                "9207424032",      // Phone
	                "priyavenugopalan632000@gmail.com"  // Email
	        );
	        driver.get("https://bookcarry.com/");

	        // Optional wait to ensure homepage loads
	        Thread.sleep(2000);
	    }
	}
	


