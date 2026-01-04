package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GetandNavMethods {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        URL myurl = new URL("https://www.google.com/");
        driver.navigate().to(myurl);
//System.out.println("PageSource" + driver.getPageSource());
WebElement gmail = driver.findElement(By.xpath("//a[normalize-space()='Gmail']"));
System.out.println("class " + gmail.getDomAttribute("class"));
System.out.println("TagName" + gmail.getTagName());
System.out.println("url" + driver.getCurrentUrl() );
System.out.println("Text " + gmail.getText());
System.out.println("Attribute " + gmail.getDomAttribute("aria-label"));


// 	Previous page = blank internal page (data:,) so navigate again
        driver.navigate().to("https://mail.google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("backward" + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println("forward" + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println("Refreshed" + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();




    }
}

