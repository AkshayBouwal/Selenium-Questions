package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.Network;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class No_5_BrokenLinks {

    /*
    Write a java program to find out broken links.

     */

    public static void approach1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.flipkart.com");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='_1ZMrY_']//a"));

        System.out.println(list.size());


        for (int i = 0; i < list.size(); i++) {

            String url = list.get(i).getAttribute("href");

            if (!url.isEmpty()) {

                try {
                    URL linkURL = new URL(url);

                    HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

                    connection.connect();
                    int status = connection.getResponseCode();

                    if (status >= 400) {
                        System.out.println("Broken Link ------> " + url);
                    }

                    if (status >= 200 && status < 300) {
                        System.out.println("Link OK ------> " + url);
                    }

                } catch (Exception e) {
                    System.out.println("Something is Wrong");
                }

            }


        }

    }

    public static void approach2() {


        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Event for what request we are sending to Server

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
            //System.out.println("Sending Information : " + requestWillBeSent.getRequest().getUrl());
        });


        //Event for Receiving information from Server

        devTools.addListener(Network.responseReceived(), responseReceived -> {

//            System.out.println("Receiving Information 1. : " + responseReceived.getResponse().getUrl());
//            System.out.println("Receiving Information 2. : " + responseReceived.getResponse().getStatus());

            if (responseReceived.getResponse().getStatus() >= 400) {

                System.out.println(responseReceived.getResponse().getUrl());
                System.out.println("Broken Link");
            }


        });

        driver.get("https://www.flipkart.com");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='_1ZMrY_']//a"));

        for (WebElement element : list) {
//            Set<String> tabs = driver.getWindowHandles();
//            List<String> tabList = new ArrayList<>(tabs);
            element.click();
            //driver.switchTo().window(tabList.get(0));
            driver.navigate().back();
        }

    }

    public static void main(String[] args) {

        approach2();


    }
}
