package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class No_24_CustomLocator {


    public static By placeholder(String placeholder) {

        return new ByPlaceholder(placeholder);
    }

    public static class ByPlaceholder extends By {

        private final String placeholder;

        public ByPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        public List<WebElement> findElements(SearchContext context) {
            return context.findElements(By.xpath("//input[@placeholder = '" + placeholder + "']"));
        }


    }


}

class Main {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.facebook.com");

        WebElement email = driver.findElement(No_24_CustomLocator.placeholder("Email address or phone number"));
        email.sendKeys("Test@gmail.com");

        WebElement password = driver.findElement(No_24_CustomLocator.placeholder("Password"));
        password.sendKeys("Test@123");
    }
}
