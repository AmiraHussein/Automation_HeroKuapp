import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin
{
    @Test
    public void testValidLogin()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        SecureAreaPage secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login("tomsmith","SuperSecretPassword!");
        String actualMessage, expectedMessage;
        expectedMessage="You logged into a secure area!";
        actualMessage=secureAreaPage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        driver.quit();
    }

    @Test
    public void testLoginWithInvalidUsername()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        SecureAreaPage secureAreaPage=new SecureAreaPage(driver);
        homePage.clickOnFormAuthenticationLink();
        loginPage.Login("invalid","SuperSecretPassword!");
        String actualMessage, expectedMessage;
        expectedMessage="Your username is invalid!";
        actualMessage=loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        driver.quit();

    }
}


