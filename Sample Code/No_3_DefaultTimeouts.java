package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_3_DefaultTimeouts {

    /*
    What is Default Timeout for various Waits (Implicit Wait,PageLoad Time out,Script Time out ) mechanism in Selenium ?
     */

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);

        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds());

        driver.get("https://www.flipkart.com");

        /*
        Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 129.0.6668.71, chrome: {chromedriverVersion: 129.0.6668.89 (951c0b97221f..., userDataDir: C:\Users\aksha\AppData\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:57684}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:57684/devtoo..., se:cdpVersion: 129.0.6668.71, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
         */

        /*

        timeouts: {implicit: 0, pageLoad: 300000, script: 30000}

        Implicit Wait = 0 sec.
        pageLoad = 300sec or 5minutes.
        script = 30 secs.

         */


    }
}
