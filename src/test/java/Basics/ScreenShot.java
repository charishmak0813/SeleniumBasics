package Basics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ScreenShot {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File( System.getProperty("user.dir")+"/testData/GoogleSearchimage.png");
        FileUtils.copyFile(srcFile, targetFile);
        // Locate the section/element
        WebElement section = driver.findElement(By.id("sectionId"));
        File sourceFile = section.getScreenshotAs(OutputType.FILE);

        // Save to target location
        File targetLocation = new File(System.getProperty("user.dir")
                + "/ScreenShots/section.png");
        FileUtils.copyFile(sourceFile, targetLocation);
        driver.quit();
        //driver.close();

    }
}
