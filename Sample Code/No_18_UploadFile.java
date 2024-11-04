package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class No_18_UploadFile {

    /*
    Write a java program to upload file
     */

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.foundit.in/upload");
        driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-container pr animated upload-resume-modal']")));

        driver.findElement(By.id("file-upload")).sendKeys("D:\\Data\\Download\\VSCode-shortcuts.pdf");

        //System.out.println(driver.findElement(By.xpath("//p[@class='mb30 file-return']")).getText());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-container pr animated upload-resume-modal']//p[1])[2]")));

        System.out.println(driver.findElement(By.xpath("(//div[@class='modal-container pr animated upload-resume-modal']//p[1])[2]")).getText());

        driver.quit();


    }

    public static void approach2() throws AWTException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.foundit.in/upload");
        driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn secondaryBtn']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-container pr animated upload-resume-modal']")));


        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", driver.findElement(By.id("file-upload")));

        StringSelection filePath = new StringSelection("D:\\Data\\Download\\VSCode-shortcuts.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);


        Robot rb = new Robot();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-container pr animated upload-resume-modal']//p[1])[2]")));

        System.out.println(driver.findElement(By.xpath("//p[@class='mb30 file-return']")).getText());

        driver.quit();


    }

    public static void main(String[] args) throws AWTException {

        //visibleScreen();
        approach2();


    }
}
