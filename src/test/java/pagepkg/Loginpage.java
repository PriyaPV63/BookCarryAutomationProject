package pagepkg;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Loginpage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menu-item-605\"]/a")
    WebElement myaccountbtn;

    @FindBy(id="username")
    WebElement emailfield;

    @FindBy(id="password")
    WebElement passwordfield;

    @FindBy(name="login")
    WebElement submitbtn;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void accountclick()
    {
    	myaccountbtn.click();
    }

    public void signin(String email, String password) {
      emailfield.clear();
            emailfield.sendKeys(email);

            passwordfield.clear();
            passwordfield.sendKeys(password);

            submitbtn.click();
    }
       

    public String signinVerification() {
        return driver.getCurrentUrl();
    }
}