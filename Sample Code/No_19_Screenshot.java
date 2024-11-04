package Questions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.page.Page;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.Optional;

public class No_19_Screenshot {

    /*
    Write a java program to capture screenshot
     */

    public static void visibleScreen() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.foundit.in/upload");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(source.toPath(), new File("D:\\Data\\Download\\pic1.png").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void screenshotOfElement() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.foundit.in/upload");

        WebElement banner = driver.findElement(By.id("heroSection-container"));

        File source = banner.getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(source.toPath(), new File("D:\\Data\\Download\\pic2.png").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }

    public static void longScreenshot() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.foundit.in/upload");

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Page.enable());

        String screenshotAsString = devTools.send(Page.captureScreenshot(Optional.of(Page.CaptureScreenshotFormat.PNG), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(true), Optional.empty()));

        byte[] decode = Base64.getDecoder().decode(screenshotAsString);

        try {
            Files.write(Paths.get("D:\\Data\\Download\\pic3.png"), decode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }

    public static void main(String[] args) {

        //visibleScreen();
        //screenshotOfElement();
        longScreenshot();

    }
}
