package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_2_DifferenceBetween_close_quit {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.flipkart.com");


        driver.findElement(By.xpath("//a[text()='Myntra']")).click();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);


        /*
        close() method is used to close current parent tab or tab in focused.
         */

        driver.close();

        /*
        quit() method is used to close all tabs/windows hence browser will close after that.
         */

        driver.quit();

        /*
        Test Case 1: One Tab in one window.
        Expected Result: both close() and quit() will behave in similar manner. Will close current tab and hence browser will get close.

        Test Case 2: 2 tab in 1 window.
        Expected Result: close() will only close parent tab or focused in tab hence browser still remain open.
        Expected Result: quit() will close all tabs and hence browser will be closed.

        Test Case 2: 2 tab in 2 window.
        Expected Result: close() will only close last focused tab in last focused window hence browser still remain open.
        Expected Result: quit() will close all tabs and hence browser will be closed.

         */

    }


}
