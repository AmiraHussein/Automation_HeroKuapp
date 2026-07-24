package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage
{
    WebDriver driver;

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
    }

    //Attributes (page elements)
    By JSAlertLocator=By.xpath("//button[text()=\"Click for JS Alert\"]");
    By JSAlertMessage=By.id("result");

    //Methods(Actions on elements)
    public void clickOnJSAlertLocator()
    {
        driver.findElement(JSAlertLocator).click();
    }
    public String getAlertMessage()
    {
        return driver.findElement(JSAlertMessage).getText();
    }
}
