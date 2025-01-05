package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
    public static WebElement find(By locator){
        return driver.findElement(locator);
    }
    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public static void waitForWebElementAndClick(By locator){
        //wait(1500);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static void scrollToElements(By locator) {
        wait(2500);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", find(locator));
    }
    public static void moveToElement (By locator) {
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(find(locator)).build().perform();
    }
    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void navigateToUrl(String url){
        driver.get(url);
    }
    public static String getTitle(){
        return driver.getTitle();
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected static void windowHandle() {
        String currentTab = driver.getWindowHandle();
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTab))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no new tab"));

        driver.switchTo().window(newTab);
    }
    public static void clickIfElementExists(By locator) {
        wait(1000);
            WebElement element = find(locator);
            if (element.isDisplayed() && element.isEnabled()) {
                waitForWebElementAndClick(locator);
            }
    }

}
