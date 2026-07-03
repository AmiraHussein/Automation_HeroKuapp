import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage
{
    WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    By successMessageLocator=By.id("flash");

    public String getSuccessMessage() {
        return driver.findElement(successMessageLocator).getText();
    }
}
