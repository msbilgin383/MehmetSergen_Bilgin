package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {
    private static final String URL = "https://useinsider.com/";
    private static final String EXPECTED_TITLE = "#1 Leader in Individualized, Cross-Channel CX — Insider";

    public static By companyMenu = By.xpath("/html/body/nav/div[2]/div/ul[1]/li[6]/a");
    public static By careersLink = By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]/div/div[2]/a[2]");
    public static By declineCookie = By.id("wt-cli-reject-btn");
    public static By acceptCookie = By.id("wt-cli-accept-all-btn");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateToUrl(URL);
    }

    public static void isHomePageDisplayed() {
        Assert.assertEquals(getTitle(), EXPECTED_TITLE, "Home page is not displayed");
    }

    public static void navigateToCareers() {
        waitForWebElementAndClick(companyMenu);
        waitForWebElementAndClick(careersLink);
    }
    public static void acceptCookie() {
        clickIfElementExists(acceptCookie);
    }
    public static void declineCookie() {
        clickIfElementExists(declineCookie);
    }
}
