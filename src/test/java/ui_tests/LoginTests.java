package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginPositiveTest() {
        User user = User.builder()
                .username("sveta548@smd.com")
                .password("Password123!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegistrationForm(user);
        loginPage.clickBtnLogin();
        softAssert.assertTrue(new ContactsPage(getDriver())
                .validateTextInBtnAdd(), "validate text in element add");
        softAssert.assertTrue(new ContactsPage(getDriver())
                .isURLContainsText("contacts"), "validate url");
        softAssert.assertTrue(new ContactsPage(getDriver())
                .isBtnSignOutDisplayed(), "validate btn signOut displayed");
        softAssert.assertAll();
    }


//    @Test
//    public void testMethod(){
//        new HomePage(getDriver()).method();
//    }
//
//    @Test
//    public void testAjaxMethod(){
//        new HomePage(getDriver()).ajaxMethod();
//    }
}
