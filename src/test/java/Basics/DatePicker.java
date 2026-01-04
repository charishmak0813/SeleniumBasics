package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class DatePicker {
    public static WebDriver driver;
    public static void main(String[] args) {
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        selectFutureDate("12", "July", "2025");
    }
        public static void selectFutureDate (String date, String month, String year){
            //Select month and year
            while (true) {
                String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual Month.
                String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//actual year.
                if (currentYear.equals(year) && currentMonth.equals(month)) {
                    break;
                }
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next arrow
                //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous Arrow
            }
            //Select the date
            List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));
            for (WebElement dt : dates) {
                if (dt.getText().equalsIgnoreCase(date)) {
                    dt.click();
                    break;
                }
            }
        }


    }