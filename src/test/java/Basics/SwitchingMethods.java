package Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchingMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().alert();
        Alert myAlert = driver.switchTo().alert();
        myAlert.accept();
        myAlert.getText();
        myAlert.dismiss();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Hello");
        prompt.accept();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Alert myAlert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert1.getText());
        myAlert1.accept();
        // Right Click
        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act = new Actions(driver);
        // Right click action
        Action myaction = act.contextClick(button).build();// creating the action.
        myaction.perform();

        // Hover
        WebElement coupons =  driver.findElement(By.xpath("//div[@class='triggerWrap deals only-desktop']"));
        // in this example we have only one category, and we couldn't inspect sub category.
        // if so we can do  actions.moveToElement(coupons).moveToElement(deals).click().perform();
        Actions actions = new Actions(driver);
        actions.moveToElement(coupons).click().build().perform();

        //actions.dragAndDrop(rome, italy).build().perform(); // rome italy are the xpaths
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();



       JavascriptExecutor js = (JavascriptExecutor) driver;
        // whatever element (inputBox) we are passing as 2nd argument, it is stored in an Argument[0] array
        //js.executeScript("arguments[0].setAttribute('value','John');", inputBox);

        // Iframe
        WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frame5);
        wait.until(ExpectedConditions.visibilityOf(frame5));
        //WebElement frame5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//frame[@src='frame_5.html']")));
        driver.switchTo().frame(frame5);
        WebElement input = driver.findElement(By.xpath("//input[@name='mytext5']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        wait.until(ExpectedConditions.visibilityOf(input));

        input.sendKeys("Test");
        driver.switchTo().defaultContent();
    }
}
