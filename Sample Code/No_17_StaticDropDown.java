package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class No_17_StaticDropDown {

    /*
    Write a program to verify if dropDown elements are sorted or not ?
     */

    public static void testCase1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dd = driver.findElement(By.xpath("//select[@id='colors']"));

        Select selections = new Select(dd);

        List<WebElement> allOptions = selections.getOptions();

        List<String> originalList = allOptions.stream().map(s -> s.getText()).toList();

        System.out.println(originalList);

        List<String> sortedList = originalList.stream().sorted().toList();

        System.out.println(sortedList);

        try {
            Assert.assertEquals(originalList, sortedList);
            System.out.println("Drop Down Options are sorted");

        } catch (AssertionError e) {
            System.out.println("Drop Down Options are not sorted");
        }


    }

    public static void testCase2() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dd = driver.findElement(By.xpath("//select[@id='animals']"));

        Select selections = new Select(dd);

        List<WebElement> allOptions = selections.getOptions();

        List<String> originalList = allOptions.stream().map(s -> s.getText()).toList();

        System.out.println(originalList);

        List<String> sortedList = originalList.stream().sorted().toList();

        System.out.println(sortedList);

        try {
            Assert.assertEquals(originalList, sortedList);
            System.out.println("Drop Down Options are sorted");

        } catch (AssertionError e) {
            System.out.println("Drop Down Options are not sorted");
        }


    }

    public static void duplicateValueInDropDown() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dd = driver.findElement(By.xpath("//select[@id='colors']"));

        Select selections = new Select(dd);

        List<WebElement> allOptions = selections.getOptions();
        List<String> originalList = allOptions.stream().map(WebElement::getText).toList();
        Set<String> duplicateValue = originalList.stream().filter(element -> Collections.frequency(originalList, element) > 1).collect(Collectors.toSet());

        System.out.println(duplicateValue);


    }


    public static void main(String[] args) {

        //testCase1();
        //testCase2();

        duplicateValueInDropDown();


    }
}
