package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_16_DynamicTable {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);

        driver.get("https://practice.expandtesting.com/dynamic-table");


        System.out.println(driver.findElement(By.xpath("//td[contains(., 'Chrome')]/following-sibling::td[contains(.,'%')]")).getText());


    }
}
