package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Menupage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu-item-2261\"]/a")
    WebElement aboutmenu;

    @FindBy(xpath = "//*[@id=\"col-1838586808\"]/div/div/div/div/div[1]/div/div[2]/div[1]/div[4]/a")
    WebElement firstitemquickview;

    @FindBy(xpath = "//*[@id=\"col-1838586808\"]/div/div/div/div/div[1]/div/div[2]/div[2]/div[3]/a")
    WebElement addtocart;

    @FindBy(xpath = "//div[contains(@class,'widget_shopping_cart')]//a[contains(text(),'View cart')]")
    WebElement viewCartButton;

     @FindBy(xpath="//a[contains(@class,'remove')]")
    WebElement removeitem;

     @FindBy(xpath="//a[@class='button continue-shopping']")
    WebElement continueshopping;

    @FindBy(xpath = "//*[@id=\"menu-item-2110\"]/a")
    WebElement combooffermenu;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div[3]/a")
    WebElement firstprdaddtocart;

   
    @FindBy(xpath = "//*[@id=\"woocommerce_product_search-2\"]/form/div[1]/div[1]/select")
    WebElement filterdropdown;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div/div/div[2]/form/select")
    WebElement sortfilterdropdwon;

    @FindBy(xpath = "//*[@id=\"menu-item-696\"]/a")
    WebElement trackyourordermenu;

    @FindBy(xpath = "//*[@id=\"orderid\"]")
    WebElement trackid;

    @FindBy(id = "order_email")
    WebElement orderid;

    @FindBy(name = "track")
    WebElement trackbtn;

    @FindBy(xpath = "//*[@id=\"menu-item-660\"]/a")
    WebElement requestbookmenu;

    @FindBy(xpath = "//*[@id=\"wpcf7-f615-p606-o1\"]/form/p[1]/label/span/input")
    WebElement bookname;

    @FindBy(xpath = "//*[@id=\"wpcf7-f615-p606-o1\"]/form/p[2]/label/span/input")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"wpcf7-f615-p606-o1\"]/form/p[3]/label/span/input")
    WebElement phoneno;

    @FindBy(xpath = "//*[@id=\"menu-item-257\"]/a")
    WebElement contactmenu;

    @FindBy(xpath = "//*[@id=\"wpcf7-f13-p90-o1\"]/form/p[1]/span/input")
    WebElement name;

    @FindBy(xpath = "//*[@id=\"wpcf7-f13-p90-o1\"]/form/p[2]/span/input")
    WebElement phoneno2;

    @FindBy(xpath = "//*[@id=\"wpcf7-f13-p90-o1\"]/form/p[3]/span/input")
    WebElement email2;
    
    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public Menupage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    
    public void scrollAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

   

    public void clickAboutMenu() 
    { 
    	scrollAndClick(aboutmenu); 
    	}

    public void clickFirstItemQuickView() 
    { 
    	scrollAndClick(firstitemquickview);
    	}

    public void clickAddToCart() 
    { 
    	scrollAndClick(addtocart); 
    	}

    public void clickViewCart() {
    	scrollAndClick(viewCartButton);
    }

    public void clickRemoveItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement remove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@class,'remove')])[1]")));
        remove.click();
    }

    public void clickContinueShopping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By continueButton = By.xpath("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'continue shopping')]");

        
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI, .overlay")));
        } catch (Exception e) {}

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
    public void clickComboOfferMenu() 
    { 
    	scrollAndClick(combooffermenu); 
    	}

    public void clickFirstProductAddToCart() 
    { 
    	scrollAndClick(firstprdaddtocart);
    	}

   

   

    public void selectFilterDropdown(String value) 
    {
        new Select(filterdropdown).selectByVisibleText(value);
    }

    public void selectSortFilterDropdown(String value) 
    {
        new Select(sortfilterdropdwon).selectByVisibleText(value);
    }

    //TRACK ORDER 

    public void clickTrackYourOrderMenu() 
    { 
    	scrollAndClick(trackyourordermenu); 
    	}

    public void enterTrackID(String id) 
    { 
    	trackid.sendKeys(id); 
    	}

    public void enterOrderEmail(String emailValue) 
    { 
    	orderid.sendKeys(emailValue); 
    	}

    public void clickTrackButton() 
    { 
    	scrollAndClick(trackbtn);
    	}

    //REQUEST BOOK

    public void clickRequestBookMenu() 
    { 
    	scrollAndClick(requestbookmenu); 
    }

    public void enterBookName(String book) 
    { 
    	bookname.sendKeys(book); 
    }

    public void enterEmail(String mail) 
    { 
    	email.sendKeys(mail);
    	}

    public void enterPhoneNo(String phone) 
    { 
    	phoneno.sendKeys(phone); 
    	}

    //CONTACT 

    public void clickContactMenu() 
    {
    	scrollAndClick(contactmenu); 
    	}

    public void enterName(String yourName) 
    { 
    	name.sendKeys(yourName); 
    }

    public void enterPhoneNo2(String phone)
    { 
    	phoneno2.sendKeys(phone);
    	}

    public void enterEmail2(String mail) 
    { 
    	email2.sendKeys(mail); }


public int getTotalLinks() {
    return allLinks.size();
}

public void printAllLinks() {
    for (WebElement link : allLinks) {
        System.out.println("Link Text : " + link.getText());
        System.out.println("URL       : " + link.getAttribute("href"));
        System.out.println("----------------------------------");
    }}}