package Day47;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
    WebDriver driver;

    // Locators
//   By text_userName_Loc = By.xpath("//input[@placeholder='Username']");
//   By text_password_Loc = By.xpath("//input[@placeholder='Password']");
//   By text_login_Loc = By.xpath("//button[normalize-space()='Login']");
//    @FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
//    WebElement username;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement txt_username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement button_login;

    //Constructors
    public LoginPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // initElements will initiate all the elements using driver.
        // pageFactory is predefined class already there in selenium webderiver

    }
//    @FindBy(tagName = "a")
//    List<WebElement> links;// we can locate group of web elements.
    // ActionMethods
    public void setUserName(String user) {
        txt_username.sendKeys(user);
    }
    public void setPassword(String password) {
        txt_password.sendKeys(password);
    }
    public void clickLogin() {
        button_login.click();
    }
}
