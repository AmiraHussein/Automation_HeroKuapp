package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userNameLocator=By.id("username");
    By passwordLocator=By.id("password");
    //Login
    By loginButtonLocator=By.className("fa");
    By errorMessageLocator=By.id("flash");


    public void Login(String userName,String password)
    {
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        // click on login button
        driver.findElement(loginButtonLocator).click();
    }




    public String getErrorMessage() {
        return driver.findElement(errorMessageLocator).getText();
    }
}
