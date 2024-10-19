package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class No_15_Drag$Drop {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

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
}
