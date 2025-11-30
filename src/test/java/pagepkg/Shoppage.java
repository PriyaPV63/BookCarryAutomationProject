package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shoppage {
    WebDriver driver;
    WebDriverWait wait;
    Actions act;
    JavascriptExecutor js;

    public Shoppage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        act = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

   
    @FindBy(xpath = "//*[@id=\"menu-item-604\"]/a")
    WebElement shopbtn;

    @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-13\"]/ul/li[8]/a")
    WebElement comedymenu;

    @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-13\"]/ul/li[31]/a")
    WebElement novelmenu;

    @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-13\"]/ul/li[14]/a")
    WebElement healthmenu;

    @FindBy(xpath = "//*[@id=\"woocommerce_product_categories-13\"]/ul/li[11]/a")
    WebElement englishmenu;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[4]/a")
    WebElement bookquickview;

    @FindBy(xpath = "//*[@id=\"product-5220\"]/div[2]/div/form/button")
    WebElement addtocart;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div[1]/div[4]/ul/li[2]/a/span[1]")
    WebElement cartoptionview;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div/div[1]/div/a")
    WebElement checkout;

    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")
    WebElement firstname;

    @FindBy(xpath = "//*[@id=\"billing_last_name\"]")
    WebElement lastname;

    @FindBy(xpath = "//*[@id=\"select2-billing_country-container\"]")
    WebElement countrydropdown;

    @FindBy(xpath = "//*[@id=\"billing_address_1\"]")
    WebElement houseaddress;

    @FindBy(xpath = "//*[@id=\"billing_city\"]")
    WebElement city;

    @FindBy(xpath = "//*[@id=\"select2-billing_state-container\"]")
    WebElement statedropdown;

    @FindBy(xpath = "//*[@id=\"billing_postcode\"]")
    WebElement pincode;

    @FindBy(xpath = "//*[@id=\"billing_phone\"]")
    WebElement phoneno;

    @FindBy(xpath = "//*[@id=\"billing_email_field\"]")
    WebElement emailfield;

    // -----------------------------
    // SHOPPING FLOW
    // -----------------------------
    public void shopping() {

        // Navigate to Shop
        wait.until(ExpectedConditions.elementToBeClickable(shopbtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(comedymenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(novelmenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(healthmenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(englishmenu)).click();

        // Scroll and hover on the book
        js.executeScript("arguments[0].scrollIntoView(true);", bookquickview);
        act.moveToElement(bookquickview).perform();
        wait.until(ExpectedConditions.elementToBeClickable(bookquickview)).click();

        // Add to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

        
        By addtocart2Locator = By.xpath(
                "//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/a");
        wait.until(ExpectedConditions.elementToBeClickable(addtocart2Locator)).click();

        // View Cart and Checkout
        wait.until(ExpectedConditions.elementToBeClickable(cartoptionview)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    
    
    
    private void selectFromDropdown(WebElement dropdown, String value) {
        dropdown.click();
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@class='select2-search__field']")));
        searchInput.sendKeys(value);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[contains(@class,'select2-results__option') and text()='" + value + "']")));
        option.click();
    }

   
    
    
    private void setValue(WebElement element, String value) {
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    
    // BILLING DETAILS
   
    public void billingaddress(String fn, String ln, String country, String address,
                               String cityname, String state, String pin,
                               String phone, String email) {

        firstname.sendKeys(fn);
        lastname.sendKeys(ln);

        selectFromDropdown(countrydropdown, country);

        houseaddress.sendKeys(address);
        city.sendKeys(cityname);

        selectFromDropdown(statedropdown, state);

        pincode.sendKeys(pin);
        phoneno.sendKeys(phone);

        
        setValue(emailfield, email); 
    }
}