package Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;


public class WindowHandles {
    public static void  main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = driver.findElement(By.id("gb"));
        List<WebElement> gLinks = header.findElements(By.tagName("a"));
        System.out.println(gLinks.size());
        for(int i=1; i <gLinks.size(); i++){
            System.out.println(gLinks.get(i).getText());
            Actions actions = new Actions(driver);
           actions.keyDown(Keys.COMMAND)
                .click(gLinks.get(i))
                .keyUp(Keys.COMMAND)
                .perform();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

//        Actions actions = new Actions(driver);
//        WebElement gmail = driver.findElement(By.xpath("//a[normalize-space()='Gmail']"));
//        actions.keyDown(Keys.COMMAND)
//                .click(gmail)
//                .keyUp(Keys.COMMAND)
//                .perform();
//
//        WebElement images = driver.findElement(By.xpath("//a[normalize-space()='Images']"));
//        actions.keyDown(Keys.COMMAND)
//                .click(images)
//                .keyUp(Keys.COMMAND)
//                .perform();
//        WebElement gProducts = driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
//
//        String gProductsUrl = gProducts.getDomProperty("href");
//
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get(gProductsUrl);
//
//        Set<String> allWindowHandles = driver.getWindowHandles();
//        System.out.println("All window handles: " + allWindowHandles);
//        List<String> tabs = new ArrayList<>(allWindowHandles);
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//            if (driver.getTitle().contains("Gmail")) {
//                System.out.println("Gmail tab found");
//                driver.close();
//                break;
//            }
//        }
//
//        driver.switchTo().window(tabs.get(0));
       //driver.quit();
        driver.quit();

    }
}
