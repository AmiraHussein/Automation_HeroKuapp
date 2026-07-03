import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestJavaScriptAlert
{
    @Test
    public void acceptJSAlert()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage=new HomePage(driver);
        homePage.clickOnJavaScriptAlertLink();
        JavaScriptAlertPage javaScriptAlertPage=new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickOnJSAlertLocator();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
}
