package testpkg;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import excelutility.Utility;


public class Logintest extends Baseclass {

    String xl = "D:\\luminarseleniumprj.xlsx"; 
    String sheet = "Sheet1";

    
    @Test
    public void verifyLoginFromExcel() throws InterruptedException {
    	ExtentTest test = extent.createTest("Login Test Using Excel Data");
        int rowCount = Utility.getRowCount(xl, sheet);
        test.info("Total rows found in Excel: " + rowCount);

        for (int i = 1; i < rowCount; i++) {

            String email = Utility.getCellValue(xl, sheet, i, 0);
            String password = Utility.getCellValue(xl, sheet, i, 1);

            test.info("Trying login with -> Email: " + email + " | Password: " + password);

            driver.navigate().refresh();
            Thread.sleep(3000);

            
            test.info("Opening account section");

            login.accountclick();      
            Thread.sleep(2000);
            test.info("Entering credentials");

            login.signin(email, password);
            test.info("Verifying login...");

            String currentUrl = login.signinVerification();
            test.pass("Login verification done -> URL: " + currentUrl);

            driver.navigate().to("https://bookcarry.com/");
            Thread.sleep(2000);
        }
        test.pass("All login attempts completed successfully");
    }}