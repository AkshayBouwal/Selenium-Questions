package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class No_9_XpathLocator {

    /*
    Write down all the variation of Xpath Locator.
     */

    /*

    There are 8 variation of Xpath:

    1. Absolute Xpath or Parent to Child traverse
    2. Relative Xpath with one attribute
    3. Relative Xpath with more than one attribute
    4. Relative Xpath with AND OR Operator
    5. Relative Xpath with text value
    6. Relative Xpath with partial text value
    7. Relative Xpath with starts-with()
    8. Chained Xpath
    9. Xpath with Mathematical Operators
    10. Xpath with function
    11. Xpath for svg element (Scalable Vector Graphics)


     */

    public static void approach1() {

        /*
        Absolute Xpath
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>
         */

        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText());

        System.out.println(driver.findElement(By.xpath("//html[1]//body[1]//div[1]//header[1]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[1]//div[1]//div[1]//span[1]")).getText());

        System.out.println(driver.findElement(By.xpath("/html[1]//body[1]//div[1]//header[1]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[1]//div[1]//div[1]//span[1]")).getText());

        System.out.println(driver.findElement(By.xpath("//html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText());


        driver.quit();
    }

    public static void approach2() {

        /*
        Relative Xpath
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        //tagName[@attribute = 'value']

        TagName is also optional
         //*[@attribute = 'value'] - * is called Wildcard
         //tahName[@* = 'value']



         */

        System.out.println(driver.findElement(By.xpath("//span[@id = 'nav-search-label-id']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id = 'nav-search-label-id']")).getText());

        driver.quit();
    }

    public static void approach3() {

        /*
        Relative Xpath with more than one attribute
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        Relative Xpath with more than one attribute (more targeted locator)
        //tagName[@attribute1 = 'value1'][@attribute2 = 'value2']
        or
         //*[@attribute1 = 'value1'][@attribute2 = 'value2']




         */

        System.out.println(driver.findElement(By.xpath("//span[@id = 'nav-search-label-id'][@style='width: auto;']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id = 'nav-search-label-id'][@style='width: auto;']")).getText());

        driver.quit();
    }

    public static void approach4() {

        /*
        Relative Xpath with AND OR Operator
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>


        and - Both attribute/value should match.
        or - Anyone attribute/value combination should match.
       ## Case Sensitive Words

        //tagName[@attribute1 = 'value1' and @attribute2 = 'value2']
        //tagName[@attribute1 = 'value1'  or @attribute2 = 'value2']

        //tagName[@attribute1 = 'value1' and @attribute2 = 'value2']
        //tagName[@attribute1 = 'value1' or @attribute2 = 'value2']




         */

        //System.out.println(driver.findElement(By.xpath("//span[@id = 'nav-search-label-id' and @style='width: auto;']")).getText());
        //System.out.println(driver.findElement(By.xpath("//span[@id = 'nav-search-label-id' and @style='safag']")).getText());


        System.out.println(driver.findElement(By.xpath("//span[@id = 'nav-search-label-id' or @style='safag']")).getText());
        System.out.println(driver.findElement(By.xpath("//span[@id = 'gjhjjg' or @style='kjg']")).getText());


        driver.quit();
    }

    public static void approach5() {

        /*
        Relative Xpath with text value
        May be useful when no attribute

        Every linkTag will have inner text.
        but vice versa is not true every element with inner text is not linkTag
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content" xpath="1" style="">Hello, sign in</span>

         Format:
        //tagName[text() = 'text Value']
        //tagName[.= 'text Value'] (short hand representation)

         //tagName[text() = 'text Value'] -> modification -> //tagName[normalize-space() = 'text value']
         -with text() - we have to even include Leading Space and Tailing Space in text value
         -with normalize-space() - we can ignore leading space and tailing space



        //*[text() = 'text Value']
        //tagName[contains(text(),'partial text Value')]
        //tagName[starts-with(text() = 'text Value')]





         */

        System.out.println(driver.findElement(By.xpath("//span[text() = 'Hello, sign in']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text() = 'Hello, sign in']")).getText());

        driver.quit();
    }

    public static void approach6() {

        /*
        Relative Xpath with partial text value
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content" xpath="1" style="">Hello, sign in</span>


        //tagName[contains(@attribute,'partial text value')]

        //*[contains(@attribute,'partial text value')]

         */

        System.out.println(driver.findElement(By.xpath("//span[contains(@id, 'link-accountList')]")).getText());
        System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Hello')]")).getText());

        driver.quit();
    }

    public static void approach7() {

        /*
        Relative Xpath with starts-with()
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content" xpath="1" style="">Hello, sign in</span>


        //tagName[starts-with(@attribute,'partial text value')]

        //*[starts-with(@attribute,'partial text value')]

         */

        System.out.println(driver.findElement(By.xpath("//span[starts-with(@id, 'nav-link-accountList')]")).getText());
        System.out.println(driver.findElement(By.xpath("//span[starts-with(text(),'Hello')]")).getText());

        driver.quit();
    }

    public static void approach8() {

        /*
        Chained Xpath
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");

        /*

        When to use / and //
        / if you are not jumping any nodes (Child)
        // if you are jumping nodes (Child or Sub Child)


         */

        System.out.println(driver.findElement(By.xpath("(//div[@id='nav-tools']/a/div/span)[1]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@id='nav-tools']//span)[6]")).getText());


        driver.quit();
    }

    public static void approach9() {

        /*
        //span[text()>609]
        //span[text()=609]
         //span[text()<609]
         //span[@class='a-price-whole' and text() > 200]

         */
    }

    public static void approach10() {

        /*

        //tagName[last()]  - (last element)
        //tagName[last() - n]  - (nth element from last)
        //tagName[position() = n]
        //tagName[position() > n]
        //tagName[position() < n]


         */
    }

    public static void approach11() {

        /*

        //*[@attribute = 'value'] - (with mentioning svg tag)
        //*[local-name() ='svg'][@attribute = 'value']

         */
    }


    public static void main(String[] args) {

        //approach1();
        //approach2();
        //approach3();
        //approach4();
        //approach5();
        //approach6();
        //approach7();
        approach8();


    }
}
