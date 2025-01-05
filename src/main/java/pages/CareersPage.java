package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }
    private static final String qaCareerPageUrl = "https://useinsider.com/careers/quality-assurance/";
    public static By locationsBlock = By.xpath("//*[@id=\"career-our-location\"]/div/div/div/div[1]/h3");
    public static By teamsBlock = By.id("career-find-our-calling");
    public static By lifeAtInsiderBlock = By.xpath("(//div[@class='elementor-widget-container'])[13]");

    public static boolean isLocationsBlockDisplayed() {
        scrollToElements(locationsBlock);
        return find(locationsBlock).isDisplayed();
    }

    public static boolean isTeamsBlockDisplayed() {
        scrollToElements(teamsBlock);
        return find(teamsBlock).isDisplayed();
    }

    public static boolean isLifeAtInsiderBlockDisplayed() {
        scrollToElements(lifeAtInsiderBlock);
        return find(lifeAtInsiderBlock).isDisplayed();
    }

    public static void areAllSectionsDisplayed() {
        Assert.assertTrue(isLocationsBlockDisplayed(), "Locations block is not displayed");
        Assert.assertTrue(isTeamsBlockDisplayed(), "Teams block is not displayed");
        Assert.assertTrue(isLifeAtInsiderBlockDisplayed(), "Life at Insider block is not displayed");
        //return isLocationsBlockDisplayed() &&
        //        isTeamsBlockDisplayed() &&
        //        isLifeAtInsiderBlockDisplayed();
    }
    public static void navigateToQaCareerPage() {
        driver.get(qaCareerPageUrl);
    }

}
