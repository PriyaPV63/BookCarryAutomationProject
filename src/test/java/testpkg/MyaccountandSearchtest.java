package testpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import excelutility.Screenshotutility;


import java.time.Duration;

public class MyaccountandSearchtest extends Baseclass {

    

    @Test(priority = 1)
    public void addShippingAddress() {
    	ExtentTest test = extent.createTest("Add Shipping Address");

        
        test.info("Opening My Account");
        myacc.openMyAccount();
        test.info("Opening Address Section");
        myacc.openAddressSection();
        test.info("Opening Shipping Address form");
        myacc.openShippingAddress();
        test.info("Entering shipping address details");
        myacc.enterShippingDetails(
                "Priya", "P", "Street 123",
                "Palakkad", "678001"
        );
        test.info("Saving shipping address");
        myacc.saveShippingAddress();
        test.pass("Shipping address added successfully");
    }

    @Test(priority = 2)
    public void openWishlistThenLogout() {
    	ExtentTest test = extent.createTest("Wishlist & Logout Test");

        
        test.info("Opening My Account");
        myacc.openMyAccount();
        test.info("Opening Wishlist");
        myacc.openWishlist();

       
        test.info("Navigating back to My Account to access logout");
        driver.navigate().back();
        

       
        test.info("Waiting for Logout button to appear");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='my-account-nav']/li[7]/a")
        ));
        test.info("Clicking Logout");
        myacc.logoutAccount();
        test.info("Confirming Logout");
        myacc.logoutcnfrm();
        Screenshotutility.captureScreenshot(driver, "LogoutSuccess");
        test.pass("Logout completed successfully. Screenshot captured.");
    }
}