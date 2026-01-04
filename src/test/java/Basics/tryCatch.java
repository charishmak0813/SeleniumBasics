package Basics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class tryCatch {
    public static void main(String[] args) throws IOException {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']"));
        try {
            loginButton.click();
            System.out.println("Login button clicked.");
        } catch (Exception e) {
            System.out.println("Click failed, using JavaScript Executor.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginButton);
        }
        // try login catch and take screenshot of error
        try{
            WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
            userName.sendKeys("Test");
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.sendKeys("Test122");
            WebElement login = driver.findElement(By.xpath("//button[@id='login']"));
            login.click();

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("Login failed. Taking screenshot...");
            e.printStackTrace();
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
//            File target = new File(System.getProperty("user.dir") + "\\screenshots\\Test.png");
//            FileUtils.copyFile(src, target);

            File dir = new File(System.getProperty("user.dir") + "/screenshots");
            if (!dir.exists()) {
                dir.mkdir();
            }

            File target = new File(dir, "LoginError_" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(src, target);

        }
        finally {
            driver.quit();
        }



    }
}
