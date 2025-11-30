package testpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import excelutility.Screenshotutility;
import pagepkg.MyaccountandSearchpage;

import java.time.Duration;

public class MyaccountandSearchtest extends Baseclass {

    MyaccountandSearchpage ob;

    @Test(priority = 1)
    public void addShippingAddress() {
    	ExtentTest test = extent.createTest("Add Shipping Address");

        ob = new MyaccountandSearchpage(driver);
        test.info("Opening My Account");
        ob.openMyAccount();
        test.info("Opening Address Section");
        ob.openAddressSection();
        test.info("Opening Shipping Address form");
        ob.openShippingAddress();
        test.info("Entering shipping address details");
        ob.enterShippingDetails(
                "Priya", "P", "Street 123",
                "Palakkad", "678001"
        );
        test.info("Saving shipping address");
        ob.saveShippingAddress();
        test.pass("Shipping address added successfully");
    }

    @Test(priority = 2)
    public void openWishlistThenLogout() {
    	ExtentTest test = extent.createTest("Wishlist & Logout Test");

        ob = new MyaccountandSearchpage(driver);
        test.info("Opening My Account");
        ob.openMyAccount();
        test.info("Opening Wishlist");
        ob.openWishlist();

        // Go back before logout (Wishlist page has no logout link)
        test.info("Navigating back to My Account to access logout");
        driver.navigate().back();
        

        // Wait until My Account menu becomes visible again
        test.info("Waiting for Logout button to appear");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='my-account-nav']/li[7]/a")
        ));
        test.info("Clicking Logout");
        ob.logoutAccount();
        test.info("Confirming Logout");
        ob.logoutcnfrm();
        Screenshotutility.captureScreenshot(driver, "LogoutSuccess");
        test.pass("Logout completed successfully. Screenshot captured.");
    }
}