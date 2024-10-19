package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_10_CSS_Selector {

        /*
    Write down all the variation of CSS Selector Locator.
     */

    /*
    There are 4 variation of CSS Selector
    1. tag and id - tagName#ID
    2. tag and class
    3. tag and attribute
    4. tag,class and attribute
    5. CSS Selector start with
    6. CSS Selector ends with
    7. CSS Selector with partial text
    8. Direct Child
    9. Child or Sub Child
    10. Following or next Sibling
    11. Chaining of Attributes
    12. Indexing in CSS Selector
    13. CSS Selector with child function
    14. CSS Selector with type function
     */

    public static void approach1() {
        /*tag and id
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        tag#ID
        span#nav-search-label-id

        Also tagName is optional
        #id
        #nav-search-label-id

         */

        System.out.println(driver.findElement(By.cssSelector("span#nav-search-label-id")).getText());
        System.out.println(driver.findElement(By.cssSelector("#nav-search-label-id")).getText());
        driver.quit();


    }


    public static void approach2() {
        /*tag and class
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        tag.className
        span.nav-search-label"

        Also, tagName is optional
        .className
        .nav-search-label

        Note: If you have more than 1 value of class then select only one value out of them.

         */

        System.out.println(driver.findElement(By.cssSelector("span.nav-search-label")).getText());
        System.out.println(driver.findElement(By.cssSelector("span.nav-progressive-content")).getText());
        //System.out.println(driver.findElement(By.cssSelector("span.nav-search-label nav-progressive-content")).getText());
        System.out.println(driver.findElement(By.cssSelector(".nav-search-label")).getText());
        driver.quit();


    }

    public static void approach3() {

        /*tag and attribute
        Any other attribute except className and ID
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        tag[attribute = 'value']
        span[style = 'width: auto;']

        Also, tagName is optional
        [attribute = 'value']
        [style = 'width: auto;'

         */

        System.out.println(driver.findElement(By.cssSelector("span[style = 'width: auto;']")).getText());
        System.out.println(driver.findElement(By.cssSelector("[style = 'width: auto;']")).getText());
        driver.quit();


    }

    public static void approach4() {

        /*tag,class and attribute
         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        /*
        <span id="nav-search-label-id" class="nav-search-label nav-progressive-content" style="width: auto;" xpath="1">All</span>

        tagName.className[attribute = 'value']
        span.nav-search-label[style = 'width: auto;']

        Also, tagName is optional
        .className[attribute = 'value']
        .nav-search-label[style = 'width: auto;']

         */

        //System.out.println(driver.findElement(By.cssSelector("span.nav-search-label[style = 'width: auto;']")).getText());
        System.out.println(driver.findElement(By.cssSelector("span.nav-progressive-content[style = 'width: auto;']")).getText());
        System.out.println(driver.findElement(By.cssSelector(".nav-progressive-content[style = 'width: auto;']")).getText());
        driver.quit();


    }

    public static void approach5() {

        /*
        Format:
         tagName[attribute^='locator value start with']

         a[class^='Navbar_logo_']

         */
    }

    public static void approach6() {

        /*
        Format:
         tagName[attribute$='locator value ends with']

         a[class$='26S5Y']

         */
    }

    public static void approach7() {

        /*
        Format:
         tagName[attribute*='partial locator text']

         a[class*='logo_']

         */
    }


    public static void approach8() {

        /*
        Format:
        XPath: //div/a
        CSS: div > a

        div[class='navFooterLinkCol navAccessibility']:first-child > ul > li


         */
    }

    public static void approach9() {

        /*
        Format:
            XPath: //div//a
            CSS: div a

            div[class='navFooterLinkCol navAccessibility']:first-child li

         */
    }

    public static void approach10() {

        /*
        Format:
        XPATH: //input[@id='username']/following-sibling:input[1]
        CSS: #username + input

        div[class='navFooterLinkCol navAccessibility']:first-child + div
        # Only one match not multiple matches.

         */
    }

    public static void approach11() {

        /*
        Format:

        XPATH: //input[@name='login'and @type='submit']
        CSS: input[name='login'][type='submit']

         */
    }

    public static void approach12() {

        /*
        Format:
        li::nth-of-type(4) (type can be anything of 4th element)
        li::nth-child(4) (4th element has to be li element)
         */
    }

    public static void approach13() {

        /*
        Format:
        li::first-child
        li::last-child
        li::nth-child(n)
        li::nth-last-child(n)
         */
    }

    public static void approach14() {

        /*
        Format:
        li::first-of-type
        li::last-of-type
        li::nth-of-type(n)
        li::nth-last-type(n)
         */
    }

    public static void main(String[] args) {

        //approach1();
        //approach2();
        //approach3();
        approach4();

    }
}
