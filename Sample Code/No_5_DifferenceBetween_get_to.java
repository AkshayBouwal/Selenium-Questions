package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_5_DifferenceBetween_get_to {

    /*
    What is difference between driver.get() and driver.navigate().to();
     */

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        /*
        # The only difference is hierarchy.
        # get() method is coming from WebDriver whereas to() method is coming from Navigation Interface.
        # get() only accept String as argument whereas to() method accepts String and URL as argument.
        # Internal both call same method so page loading wait, Cookies, timeouts etc works in similar manner.
         */

        driver.get("https://www.flipkart.com");

        driver.navigate().to("https://www.flipkart.com");




    }
}
