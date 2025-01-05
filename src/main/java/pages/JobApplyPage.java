package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobApplyPage extends BasePage{
    static By applyButton = By.xpath("(//a[@class='postings-btn template-btn-submit shamrock'])[1]");

    public JobApplyPage(WebDriver driver) {
        super(driver);
    }
    public static void checkApplyPageTitle(){
        wait(2000);
        windowHandle();
        Assert.assertTrue(getTitle().contains("Software Q"),"Job apply page title is not correct");
    }
    public static void isJobApplyPageDisplayed() {
        Assert.assertTrue(getCurrentUrl().contains("jobs.lever.co"), "Job apply page is not displayed");
    }

    public static void isApplyButtonDisplayed() {
        wait(2000);//added for firefox performance issue
        Assert.assertTrue(find(applyButton).isDisplayed(), "Apply button is not displayed");
    }
}
