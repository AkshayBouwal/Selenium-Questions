package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class No_7_LoginPop {

    /*
    Write a java program to login into any site if it is showing any authentication popup for username and password.
     */

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
    }

    public static void approach2() {

        /*
        Not Working
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().sendKeys("admin");

//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.sendKeys("admin");

    }

    public static void main(String[] args) {

        //visibleScreen();
        approach2();


    }
}
