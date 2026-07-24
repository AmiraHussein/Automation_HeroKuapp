package testCases;

import Pages.JavaScriptAlertPage;
import baseTest.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TestJavaScriptAlert extends BaseTest
{
    @Test
    public void acceptJSAlert()
    {

        homePage.clickOnJavaScriptAlertLink();
        JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickOnJSAlertLocator();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
}
