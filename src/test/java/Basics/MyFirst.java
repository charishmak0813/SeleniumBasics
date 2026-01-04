package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyFirst {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.opencart.com");
           String title =  driver.getTitle();
            driver.getCurrentUrl();
            assert title != null;
            if(title.equalsIgnoreCase("OpenCart - Open Source Shopping Cart Solution")){
                System.out.println("passed");
            }else {
                System.out.println("failed");
            }

driver.close();
        }


}
