package testpkg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import pagepkg.Menupage;

public class MenuTest extends Baseclass {

    @Test
    public void testMenuOperations() {
    	ExtentTest test = extent.createTest("Menu Operations Test");
        Menupage menu = new Menupage(driver);

        // Navigate menus
        test.info("Clicking About menu");
        menu.clickAboutMenu();
        test.pass("About menu opened successfully");
        test.info("Clicking Combo Offer menu");
        menu.clickComboOfferMenu();
        test.pass("Combo Offer menu opened");
        test.info("Adding first product to cart");
        menu.clickFirstProductAddToCart();
        test.pass("Product added to cart");

        // Cart operations
        test.info("Opening cart");
        menu.clickViewCart();  
        test.pass("Cart opened");
        test.info("Removing item from cart");
        menu.clickRemoveItem();
        test.pass("Item removed successfully");
        
        test.info("Clicking Continue Shopping");
        menu.clickContinueShopping();
        test.pass("Continue Shopping worked");

        // Track order
        test.info("Opening Track Your Order menu");
        menu.clickTrackYourOrderMenu();
        test.info("Entering Track ID and Email");
        menu.enterTrackID("12345");
        menu.enterOrderEmail("test@example.com");
        menu.clickTrackButton();
        test.pass("Track order button clicked");

        // Request book
        test.info("Opening Request Book menu");
        menu.clickRequestBookMenu();
        menu.enterBookName("Java Basics");
        menu.enterEmail("book@test.com");
        menu.enterPhoneNo("9876543210");
        test.pass("Request a Book submitted");

        // Contact form
        test.info("Entering contact form details");
        menu.clickContactMenu();
        menu.enterName("Priya P");
        menu.enterPhoneNo2("1234567898");
        menu.enterEmail2("priya@test.com");
        test.pass("Contact form filled successfully");

        test.pass("Menu operations test completed");
    }}
       
     