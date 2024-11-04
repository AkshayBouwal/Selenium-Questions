package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class No_12_GetAllLinks {

    public static void approach1() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com");

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='_1ZMrY_']//a"));

        int count = 1;
        for (WebElement element : links) {
            System.out.println(count + ". " + element.getAttribute("href"));
            count++;
        }

        driver.quit();
    }

    public static void approach2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com");


        ////div[@class='_1ZMrY_']//a/@href


        driver.quit();
    }


    public static void main(String[] args) {
        //visibleScreen();
        approach2();

    }
}
