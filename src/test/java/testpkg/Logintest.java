package testpkg;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import basepkg.Baseclass;
import excelutility.Utility;
import pagepkg.Loginpage;

public class Logintest extends Baseclass {

    String xl = "D:\\luminarseleniumprj.xlsx"; // 🔸 Update Excel file path
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

            Loginpage lp = new Loginpage(driver);
            test.info("Opening account section");

            lp.accountclick();      
            Thread.sleep(2000);
            test.info("Entering credentials");

            lp.signin(email, password);
            test.info("Verifying login...");

            String currentUrl = lp.signinVerification();
            test.pass("Login verification done -> URL: " + currentUrl);

            driver.navigate().to("https://bookcarry.com/");  // ✅ FIXED URL
            Thread.sleep(2000);
        }
        test.pass("All login attempts completed successfully");
    }}