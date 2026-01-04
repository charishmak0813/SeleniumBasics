package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select dCountry = new Select(dropdown);
        dCountry.selectByVisibleText("United States");
//        dCountry.selectByIndex(1);
//        dCountry.selectByValue("United States");
        // capture the option from the DD
        List<WebElement> options = dCountry.getOptions();
        System.out.println("Number of options:" + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        // Checkbox
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));

        for(int i = 0 ; i < checkboxes.size() ; i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }
    }
}
