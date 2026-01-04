package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ScrollPage {
    public static  void main(String[] args) throws InterruptedException {
       // WebDriver driver = new ChromeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.google.com");

        driver.executeScript("window.scrollBy(0,1000)","");
        System.out.println(driver.executeScript("return window.pageYOffset;"));// 1000
        // Scroll till the end of the page
        driver.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        // Scroll to initial position
        driver.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        driver.executeScript("document.body.style.zoom='90%'");

    }
}
