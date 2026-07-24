package testCases;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest
{

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Test
    public void testValidLogin() throws InterruptedException {
        System.out.println("---Test case--");
        loginPage=new LoginPage(driver);
        secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login("tomsmith","SuperSecretPassword!");
        String actualMessage, expectedMessage;
        expectedMessage="You logged into a secure area!";
        Thread.sleep(5000);
        actualMessage=secureAreaPage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testLoginWithInvalidUsername()
    {
        loginPage=new LoginPage(driver);
        secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login("userName","password");
        String actualMessage, expectedMessage;
        expectedMessage="Your username is invalid!";
        actualMessage=loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}


