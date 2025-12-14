package testpkg;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import basepkg.Baseclass;

public class MenuTest extends Baseclass {

    @Test
    public void testAboutMenu() {
        ExtentTest test = extent.createTest("About Menu Test");
        test.info("Clicking About menu");
        menu.clickAboutMenu();
        test.pass("About menu opened successfully");
    }

    @Test
    public void testComboOfferMenu() {
        ExtentTest test = extent.createTest("Combo Offer Menu Test");
        test.info("Clicking Combo Offer menu");
        menu.clickComboOfferMenu();
        test.pass("Combo Offer menu opened");
        test.info("Adding first product to cart");
        menu.clickFirstProductAddToCart();
        test.pass("Product added to cart");
    }

    @Test
    public void testCartOperations() {
        ExtentTest test = extent.createTest("Cart Operations Test");

        test.info("Opening Combo Offer menu");
        menu.clickComboOfferMenu();

        test.info("Adding first product to cart");
        menu.clickFirstProductAddToCart();

        test.info("Waiting and then opening cart");
        menu.clickViewCart();  

        test.pass("Cart opened");

        test.info("Removing item from cart");
        menu.clickRemoveItem();
        test.pass("Item removed successfully");

        test.info("Clicking Continue Shopping");
        menu.clickContinueShopping();
        test.pass("Continue Shopping worked");
    }

    @Test
    public void testTrackOrder() {
        ExtentTest test = extent.createTest("Track Order Test");
        test.info("Opening Track Your Order menu");
        menu.clickTrackYourOrderMenu();
        test.info("Entering Track ID and Email");
        menu.enterTrackID("12345");
        menu.enterOrderEmail("test@example.com");
        menu.clickTrackButton();
        test.pass("Track order button clicked");
    }

    @Test
    public void testRequestBook() {
        ExtentTest test = extent.createTest("Request Book Test");
        test.info("Opening Request Book menu");
        menu.clickRequestBookMenu();
        menu.enterBookName("Java Basics");
        menu.enterEmail("book@test.com");
        menu.enterPhoneNo("9876543210");
        test.pass("Request a Book submitted");
    }

    @Test
    public void testContactForm() {
        ExtentTest test = extent.createTest("Contact Form Test");
        test.info("Opening Contact menu");
        menu.clickContactMenu();
        menu.enterName("Priya P");
        menu.enterPhoneNo2("1234567898");
        menu.enterEmail2("priya@test.com");
        test.pass("Contact form filled successfully");
    }

    @Test
    public void testLinkCount() {
        ExtentTest test = extent.createTest("Link Count Test");
        test.info("Counting all links on the page");
        int count = menu.getTotalLinks();
        System.out.println("Total number of links: " + count);
        test.pass("Total links found: " + count);

        test.info("Printing all links in console");
        menu.printAllLinks();
        test.pass("All links printed successfully");
    }
}