package Day46;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(Day46.MyListener.class)
public class OrangeHRM {
    WebDriver driver;
    @BeforeClass
    void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }
    @Test(priority = 1)
    void testLogo() {
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertTrue(status);
    }
    @Test(priority = 2)
    void testAppUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");

    }
    @Test(priority = 3, dependsOnMethods = {"testAppUrl"})
    void testHomePageTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
