import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup()
    {
        System.out.println("---BeforeMethod--");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        homePage=new HomePage(driver);


    }
    @AfterMethod
    public void teardown()
    {
        System.out.println("---AfterMethod--");
        driver.quit();
    }
}
