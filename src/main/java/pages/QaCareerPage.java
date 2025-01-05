package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class QaCareerPage extends BasePage {
    public QaCareerPage(WebDriver driver) {
        super(driver);
    }

    public static By positionDepartment = By.className("position-department");
    public static By positionLocation = By.className("position-location");
    public static By positionListItem = By.className("position-list-item");
    public static By positionTitle = By.xpath("//div[@class='position-list-item-wrapper bg-light']/p");
    public static By seeAllQaJobs = By.xpath("//a[normalize-space()='See all QA jobs']");
    public static By viewRoleButton = By.xpath("//*[@id=\"jobs-list\"]/div[1]/div/a");
    public static List<WebElement> positionList;
    public static List<WebElement> departmentList;
    public static List<WebElement> locationList;
    public static By locationContainer = By.id("select2-filter-by-location-container");
    public static By locations = By.xpath("//li[contains(text(),'Istanbul, Turkey')]");
    public static By departmentContainer = By.id("select2-filter-by-department-container");
    public static By departments = By.xpath("//li[contains(text(),'Quality Assurance')]");
    public static void clickSeeAllQAJobs() {
        waitForWebElementAndClick(seeAllQaJobs);
    }

    public static void clickFilterByLocation() {
        wait(2000);
        scrollToElements(locationContainer);
        waitForWebElementAndClick(locationContainer);
        wait(2000);
        waitForWebElementAndClick(locations);
    }

    public static void clickFilterByDepartment() {
        wait(2000);
        waitForWebElementAndClick(departmentContainer);
        waitForWebElementAndClick(departments);
        wait(2000);
    }

    public static void clickViewRole() {
        moveToElement(viewRoleButton);
        waitForWebElementAndClick(viewRoleButton);
    }
    public static void checkPositionList(){
        Assert.assertFalse(findElements(positionListItem).isEmpty(), "Position list is empty");
        //return !findElements(positionListItem).isEmpty();
    }
    public static void checkPositionAttributes(){
        wait(2000);
        positionList = findElements(positionTitle);
        departmentList = findElements(positionDepartment);
        locationList = findElements(positionLocation);

        for (int i=0; i<positionList.size(); i++) {
            Assert.assertTrue(positionList.get(i).getText().contains("Software Q")," check position  " + positionList);
            Assert.assertTrue(departmentList.get(i).getText().contains("Quality Assurance"), "check department " + departmentList);
            Assert.assertTrue(locationList.get(i).getText().contains("Istanbul, Turkey"), "check location" + locationList);
        }
    }
}