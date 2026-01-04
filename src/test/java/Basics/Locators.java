package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Locators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userName = driver.findElement(By.name("userName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.className("password"));
        WebElement login = driver.findElement(By.tagName("button"));
        WebElement forgotPassword = driver.findElement(By.linkText("forgotPassword"));
        WebElement resetPassword = driver.findElement(By.partialLinkText("resetPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("#loginButton"));
        WebElement loginLink = driver.findElement(By.cssSelector(".login-link"));
        WebElement search = driver.findElement(By.cssSelector("[name='search']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='search']"));
        WebElement inputSearchBox = driver.findElement(By.cssSelector("input.search-item[placeholder='search']"));
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        links.get(0).click();
        System.out.println("No of Links: " + links.size());
        WebElement link = driver.findElement(By.xpath("//a[@href='https://www.google.com']"));
        link.click();
        driver.findElement(By.xpath("//input[@name='q'][@placholder='search']")).sendKeys("Shirts");
        driver.findElement(By.xpath("//input[contains(@name,'sea')]")).sendKeys("Shirts");
        driver.findElement(By.xpath("//input[starts-with(@name,'subm')]")).click();
        driver.findElement(By.xpath("//input[@name='submit' or @value ='submit']")).click();
        driver.findElement(By.xpath("//input[@name='submit' and @value ='submit']")).click();
      String  textVal =  driver.findElement(By.xpath("//strong[text()='Featured products']")).getText();
    }
}
