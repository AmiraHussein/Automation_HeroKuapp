import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;

import javax.imageio.plugins.tiff.TIFFImageReadParam;

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
        loginPage.Login("invalid","SuperSecretPassword!");
        String actualMessage, expectedMessage;
        expectedMessage="Your username is invalid!";
        actualMessage=loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}


