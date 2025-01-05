package tests;

import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;
import pages.JobApplyPage;
import pages.QaCareerPage;

public class TestAutomation extends BaseTest {


    @Test
    public void testAutomation()  {
        setUp("firefox");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        HomePage.isHomePageDisplayed();
        HomePage.declineCookie();
        HomePage.navigateToCareers();

        CareersPage.areAllSectionsDisplayed();
        CareersPage.navigateToQaCareerPage();

        QaCareerPage.clickSeeAllQAJobs();
        QaCareerPage.clickFilterByLocation();
        QaCareerPage.clickFilterByDepartment();
        QaCareerPage.checkPositionList();
        QaCareerPage.checkPositionAttributes();
        QaCareerPage.clickViewRole();

        JobApplyPage.checkApplyPageTitle();
        JobApplyPage.isJobApplyPageDisplayed();
        JobApplyPage.isApplyButtonDisplayed();
    }
}
