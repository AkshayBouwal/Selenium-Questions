package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class No_4_AutoComplete {

    /*
    Write a short program to handle autocomplete functionality like Google and Flipkart
     */

    public static void main(String[] args) {

        String searchValue = "selenium";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(searchValue);


//        List<WebElement> spanList = driver.findElements(By.xpath("//div[@jsname='erkvQe']//span[contains(text(),'" + searchValue + "')]"));

//        List<WebElement> spanList = driver.findElements(By.xpath("(//ul)[1]//span[contains(text(),'" + searchValue + "')]"));

        List<WebElement> spanList = driver.findElements(By.xpath("(//ul)[1]//li"));

        System.out.println(spanList.size());

        int count = 1;

        for (WebElement element : spanList) {

//            try {
//                //System.out.println(element.getText() + " " + element.findElement(By.tagName("b")).getText());
//                System.out.println(element.getText());
//            } catch (NoSuchElementException e) {
//                System.out.println(element.getText());
//            }

            System.out.println(count + ". " + element.getText());
            count++;

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //driver.quit();


    }
}
