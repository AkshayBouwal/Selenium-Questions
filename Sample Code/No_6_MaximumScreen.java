package Questions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_6_MaximumScreen {

    /*
    Write a java program to open browser window in maximum screen.
     */

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com");


    }

    public static void approach2() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

    }

    public static void approach3() {

        WebDriver driver = new ChromeDriver();

        Dimension display = new Dimension(800, 1000);
        driver.manage().window().setSize(display);

        driver.get("https://www.flipkart.com");

    }


    public static void main(String[] args) {

        //visibleScreen();
        //approach2();
        approach3();


    }
}
