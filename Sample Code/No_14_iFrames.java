package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class No_14_iFrames {

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //driver.switchTo().frame(0);
        //driver.switchTo().frame(name and id attribute)

        String msg = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']")).getText();
        System.out.println(msg);

        Actions interactions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        interactions.dragAndDrop(source, target).perform();

        driver.switchTo().defaultContent();


    }

    public static void approach2() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://jqueryui.com/droppable/");

        /*
        Similarly 3 overloaded method, ID, int, WebElement
         */

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        String msg = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']")).getText();
        System.out.println(msg);

        Actions interactions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        interactions.dragAndDrop(source, target).perform();

        System.out.println(driver.findElement(By.xpath("//div[@id = 'droppable']/p")).getText());

        driver.switchTo().defaultContent();

        driver.quit();


    }

    public static void frameNo(WebDriver driver) {

        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println(list.size());
    }

    public static void main(String[] args) {

        //visibleScreen();
        approach2();


    }
}
