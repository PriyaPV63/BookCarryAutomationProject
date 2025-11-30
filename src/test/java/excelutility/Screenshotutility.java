package excelutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotutility {
	 public static void captureScreenshot(WebDriver driver, String name) 
{
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File dest = new File("./screenshots/" + name + ".png");
	            FileHandler.copy(src, dest);
	        } 
	        catch (IOException e) {
	            System.out.println("Screenshot failed: " + e.getMessage());
	        }
	    }
	}


