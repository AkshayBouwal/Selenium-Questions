package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class No_8_Calendar {

    /*
    Write a java program to handle Calendar in Selenium Webdriver
     */

    public static void currentDate() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        /*
        Select Current Date
         */

        driver.findElement(By.id("datepicker")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

//        //driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();
//        //driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        //driver.findElement(By.xpath("//*[contains(@class,'highlight')]")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();


        driver.quit();


    }

    public static void customizedDate(String dateUser, String monthUser, String yearUser) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

        String month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[1]")).getText();
        String year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[2]")).getText();

//        System.out.println(month);
//        System.out.println(year);

        if (Integer.parseInt(yearUser) > Integer.parseInt(year)) {

            while (!(month.equals(monthUser) && year.equals(yearUser))) {

                driver.findElement(By.xpath("//span[text()='Next']")).click();

                month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[1]")).getText();
                year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[2]")).getText();
                //System.out.println(month + " " + year);

            }

        }

        if (Integer.parseInt(yearUser) < Integer.parseInt(year)) {

            while (!(month.equals(monthUser) && year.equals(yearUser))) {

                driver.findElement(By.xpath("//span[text()='Prev']")).click();

                month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[1]")).getText();
                year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[2]")).getText();
                //System.out.println(month + " " + year);

            }

        }

        driver.findElement(By.xpath("//a[text()='" + dateUser + "']")).click();

        //driver.quit();


    }

    public static void main(String[] args) {

        //currentDate();
        //customizedDate("20", "April", "2026");
        //customizedDate("20", "April", "1985");
        //customizedDate("20", "December", "2024");


    }
}
