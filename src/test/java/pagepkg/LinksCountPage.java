package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksCountPage {
	WebDriver driver;
	
	@FindBy(tagName = "a")
    List<WebElement> allLinks;

    public LinksCountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Return total number of links
    public int getLinksCount() {
        return allLinks.size();
    }

    // Print all link texts and URLs
    public void printAllLinks() {
        for (WebElement link : allLinks) {
            System.out.println("Link Text : " + link.getText());
            System.out.println("URL       : " + link.getAttribute("href"));
            System.out.println("----------------------------------");
        }
    }
}