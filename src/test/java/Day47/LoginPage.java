package Day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    // Locators

   By text_userName_Loc = By.xpath("//input[@placeholder='Username']");
   By text_password_Loc = By.xpath("//input[@placeholder='Password']");
   By text_login_Loc = By.xpath("//button[normalize-space()='Login']");

    //Constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // ActionMethods
    public void setUserName(String user) {
        driver.findElement(text_userName_Loc).sendKeys(user);
    }
    public void setPassword(String password) {
        driver.findElement(text_password_Loc).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(text_login_Loc).click();
    }
}
