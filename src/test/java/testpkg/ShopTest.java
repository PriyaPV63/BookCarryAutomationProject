package testpkg;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;


public class ShopTest extends Baseclass {
	
	    @Test
	    public void shoppingFlowTest() throws InterruptedException {
		 ExtentTest test = extent.createTest("Shopping flow test");

	        

	       
		 test.info("clicking shopping");
	        shop.shopping();

	        // BILLING DETAILS FILLING
		 test.info("Entring billing address");
	        shop.billingaddress(
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

	       
	        Thread.sleep(2000);
	    }
	}
	


