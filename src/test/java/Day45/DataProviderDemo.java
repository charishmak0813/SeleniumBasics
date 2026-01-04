package Day45;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;


public class DataProviderDemo {
    WebDriver driver;
    @BeforeClass
    void setup(){
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(dataProvider ="dp")
    void testLogin(String email, String password) throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
       Thread.sleep(2000);
       boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
       if (status){
           Thread.sleep(2000);
           driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
           Assert.assertTrue(true);
       } else{
           Assert.fail();
       }
    }
    @AfterClass
    void teardown(){
         driver.quit();
    }
    @DataProvider(name ="dp",indices = {1,2})// indices = {1,2} array index so passing 2,3rd values.
    Object[][] loginData(){
        Object[][] data = {
                {"Charishmatest13@gmail.com","test@123"},
                {"abc@gmail.com","test@123"},
                {"xyz@gmail.com","test@123"},
                {"johncandey@gmail.com","test@123"}

        };
        return data;
    }
}
