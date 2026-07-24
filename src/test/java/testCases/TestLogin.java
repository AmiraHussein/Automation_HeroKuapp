package testCases;

import Pages.LoginPage;
import Pages.SecureAreaPage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestLogin extends BaseTest
{

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    @DataProvider (name = "login data")
    public Object[][] getLogindata()
    {
        return new Object[][]{
                {"tomsmith","invalid" },
                {"invalid","SuperSecretPassword"},
                { "invaid","invalid"}
        };
    }

    @Test (priority = 1 ,groups = {"login"})
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

    @Test(dataProvider ="login data",priority  =2,dependsOnMethods ="testValidLogin" )
    public void testLoginWithInvalidUsername(String username,String Password)
    {
        loginPage=new LoginPage(driver);
        secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login(username,Password);
        String actualMessage, expectedMessage;
        expectedMessage="Your username is invalid!";
        actualMessage=loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
    @Test
    public void testLoginWithInvalidPassword()
    {
        loginPage=new LoginPage(driver);
        secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login("tomsmith","password");
        String actualMessage, expectedMessage;
        expectedMessage="Your username is invalid!";
        actualMessage=loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}


