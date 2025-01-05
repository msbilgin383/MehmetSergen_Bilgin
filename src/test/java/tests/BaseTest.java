package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class BaseTest {
    public WebDriver driver;

    public WebDriver setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Tarayıcı desteklenmiyor: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result);
        }
        if (driver != null) {
            driver.quit();
        }
    }
    private void takeScreenshot(ITestResult result) throws IOException {
        DateFormat dateFormat = new java.text.SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./screenshots/" + result.getName() +"-" +dateFormat.format(date)+ ".png"));
    }

}
