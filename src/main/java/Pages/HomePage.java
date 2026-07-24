package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Attributes (locators of element in this page)

    By FormAuthenticationLocator=By.linkText("Form Authentication");
    By DropdownLocator=By.linkText("Dropdown");
    By JavaScriptAlertsLocator=By.linkText("JavaScript Alerts");



    //Methods (Actions)
    /*
      click on button
      enter text field

     */

    public void clickOnFormAuthenticationLink()
    {
        driver.findElement(FormAuthenticationLocator).click();
    }
    public void clickOnDropdownLink()
    {
        driver.findElement(DropdownLocator).click();
    }

    public void clickOnJavaScriptAlertLink()
    {
        driver.findElement(JavaScriptAlertsLocator).click();
    }



}
