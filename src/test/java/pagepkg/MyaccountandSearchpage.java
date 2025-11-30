package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyaccountandSearchpage {

    WebDriver driver;

    @FindBy(id = "woocommerce-product-search-field-0")
    WebElement searchfiled;

    @FindBy(xpath = "//*[@id='masthead']/div[1]/div[3]/ul/li/div/div/form/div[1]/div[3]/button/i")
    WebElement searchbtn;

    @FindBy(xpath = "//*[@id='menu-item-605']/a")
    WebElement myaccount;

    @FindBy(xpath = "//*[@id='main']/div[2]/div/div/div[2]/div/div/ul/li[2]/a")
    WebElement orders;

    @FindBy(xpath = "//*[@id='main']/div[2]/div/div/div[2]/div/div/ul/li[3]/a")
    WebElement dowenloads;

    @FindBy(xpath = "//*[@id='main']/div[2]/div/div/div[2]/div/div/ul/li[4]/a")
    WebElement Address;

    @FindBy(xpath="//a[contains(@href,'edit-address/billing')]")
    WebElement addbilladdress;

    @FindBy(id = "billing_first_name")
    WebElement firstname;

    @FindBy(id = "billing_last_name")
    WebElement lastname;

    @FindBy(id = "billing_company")
    WebElement companydetails;

    @FindBy(id = "select2-billing_country-container")
    WebElement countrydropdown;

    @FindBy(id = "billing_address_1")
    WebElement houseaddress;

    @FindBy(id = "billing_city")
    WebElement city;

    @FindBy(id = "select2-billing_state-container")
    WebElement statedropdown;

    @FindBy(id = "billing_postcode")
    WebElement pincode;

    @FindBy(id = "billing_phone")
    WebElement phoneno;

   
    @FindBy(name = "save_address")
    WebElement savebtn;

   
    @FindBy(xpath="//a[contains(@href,'edit-address/shipping')]")
    WebElement shippingaddress;

    @FindBy(name = "shipping_first_name")
    WebElement shippingfirstname;

    @FindBy(name = "shipping_last_name")
    WebElement shippinglastname;

    @FindBy(name = "shipping_address_1")
    WebElement streetaddress;

    @FindBy(name = "shipping_city")
    WebElement shippingcity;

    @FindBy(id = "select2-shipping_state-container")
    WebElement shippingstatedropdown;

    @FindBy(id = "shipping_postcode")
    WebElement shippingpostcode;

    @FindBy(name = "save_address")
    WebElement shippingsaveaddress;

    @FindBy(xpath = "//*[@id='my-account-nav']/li[5]/a")
    WebElement accountdetails;

    @FindBy(name = "account_first_name")
    WebElement accountdetailsfirstname;

    @FindBy(name = "account_last_name")
    WebElement accountdetailslastname;

    @FindBy(name = "account_display_name")
    WebElement accountdetailsdisplayname;

    @FindBy(name = "account_email")
    WebElement accountdetailsemailaddress;

    @FindBy(name = "save_account_details")
    WebElement saveaccountdetails;

    @FindBy(xpath = "//*[@id='my-account-nav']/li[6]/a")
    WebElement whishlist;

    @FindBy(xpath = "//*[@id='my-account-nav']/li[7]/a")
    WebElement logout;
    
    @FindBy(xpath="//*[@id=\"main\"]/div[2]/div/div/div[2]/div/div/div/div/div/a")
    WebElement cnfirmlogout;
    
    

    public MyaccountandSearchpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Search Section 
    public void enterSearch(String product) {
        searchfiled.sendKeys(product);
    }

    public void clickSearchButton() {
        searchbtn.click();
    }

    // My Account 
    public void openMyAccount() {
        myaccount.click();
    }

    //  Billing Address
    public void openAddressSection() {
        Address.click();
    }

    public void clickAddBillingAddress() {
        addbilladdress.click();
    }

    public void enterBillingDetails(
            String fname, String lname, String comp,
            String addr, String cityName, String pin, String phone, String mail) {

        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        companydetails.sendKeys(comp);
        houseaddress.sendKeys(addr);
        city.sendKeys(cityName);
        pincode.sendKeys(pin);
        phoneno.sendKeys(phone);
        
    }

    public void saveBillingAddress() {
        savebtn.click();
    }

    // Shipping Address 
    public void openShippingAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shippingaddress)).click();
    }

    public void enterShippingDetails(String fname, String lname, String street, String cityName, String pin) {
        shippingfirstname.sendKeys(fname);
        shippinglastname.sendKeys(lname);
        streetaddress.sendKeys(street);
        shippingcity.sendKeys(cityName);
        shippingpostcode.sendKeys(pin);
    }

    public void saveShippingAddress() {
        shippingsaveaddress.click();
    }

    // Account Details
    public void openAccountDetails() {
        accountdetails.click();
    }

    public void updateAccountDetails(String fname, String lname, String display, String mail) {
        accountdetailsfirstname.sendKeys(fname);
        accountdetailslastname.sendKeys(lname);
        accountdetailsdisplayname.sendKeys(display);
        accountdetailsemailaddress.sendKeys(mail);
    }

    public void saveAccountDetails() {
        saveaccountdetails.click();
    }

    // Wishlist 
    public void openWishlist() {
        whishlist.click();
    }

    // Logout
    public void logoutAccount() {
        logout.click();
    }
    //  logout confirmation
    public void logoutcnfrm()
    {
    	cnfirmlogout.click();
    }
}