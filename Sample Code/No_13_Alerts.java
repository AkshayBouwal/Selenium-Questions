package Questions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class No_13_Alerts {

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.id("alertBtn")).click();
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.quit();


    }

    public static void approach2() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.get("https://testautomationpractice.blogspot.com/");

        driver.findElement(By.id("alertBtn")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());

        alert.accept();

        driver.quit();


    }


    public static void main(String[] args) {

        //visibleScreen();
        //approach2();


    }
}
