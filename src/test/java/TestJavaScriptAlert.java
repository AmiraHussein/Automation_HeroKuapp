import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
