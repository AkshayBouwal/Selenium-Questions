package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_21_SSL_Certificate {

    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        System.out.println(chromeOptions.getBrowserName());

        //System.out.println(chromeOptions.getPlatformName().toString());

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());

        driver.close();

    }
}
