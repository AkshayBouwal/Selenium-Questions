package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class No_11_XpathAxes {

    /*
    Write down all the variation of Xpath Axes.
     */

    /*

    There are  variation of Xpath Axes:

    1. From a reference Element to Parent
    2. From a reference Element to Child
    3. From a reference Element to Grand Child
    4. From a reference Element to ancestor
    5. From a reference Element to descendant
    6. From a reference Element to Following Element
    7. From a reference Element to Preceding Element
    8. From a reference Element to Following-Sibling Element
    9. From a reference Element to Preceding-Sibling Element


     */

    public static void approach1() {

        /*
        From a reference Element to Parent
         */

        /*
        Format:
        1. //tagName[@attribute ='value']//parent::tagName
        2. //tagName[@attribute ='value']/parent::tagName
        3. //tagName[@attribute ='value']/parent::* (moves one level tag up)
        4. //tagName[@attribute ='value']//parent::* (moves one level tag up)
        5. //tagName[@attribute ='value']/.. (moves one level tag up)
        6. //tagName[@attribute ='value']//.. (moves one level tag up)

        //a[text()='Amazon Science']//parent::li//parent::ul
        //a[text()='Amazon Science']/parent::li/parent::ul/parent::div

        # Xpath of Element/parent::tagName (Parent tag should be only first one level up, it won't jump tags)
        # We can cascade parent locator
        # / or // doesn't make any difference since we are only moving one level up

         */

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in");

        WebElement parentDirectly = driver.findElement(By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[1]"));
        System.out.println(parentDirectly.getText());

        WebElement self = driver.findElement(By.xpath("//a[text()='Amazon Science']"));
        System.out.println(self.getText());


        //a[text()='Amazon Science']//parent::li//parent::ul
        //a[text()='Amazon Science']/parent::li/parent::ul/parent::div


        driver.quit();

    }


    public static void approach2() {

        /*
        From a reference Element to Child
         */

        /*
        Format:
        1. //tagName[@attribute ='value']//child::tagName (match particular child)
        2. //tagName[@attribute ='value']/child::tagName
        3. //tagName[@attribute ='value']//child::* (match all children)
        4. //tagName[@attribute ='value']/child::*
        5. //tagName[@attribute ='value']/tagName (match just below level no tag jumps)
        6. //tagName[@attribute ='value']//tagName (match below with jumps)
        7. //tagName[@attribute ='value']/* (All One Level Children)
        8. //tagName[@attribute ='value']//* (All One Level Children and even children within these children)




        Example:

        Self Element = (//div[@class='navFooterLinkCol navAccessibility'])[1]
        From this self element move to Child
        (//div[@class='navFooterLinkCol navAccessibility'])[1]/child::ul/child::li
        (//div[@class='navFooterLinkCol navAccessibility'])[1]//child::*



         */


        //a[text()='Amazon Science']//parent::li//parent::ul
        //a[text()='Amazon Science']/parent::li/parent::ul/parent::div


    }

    public static void approach3() {

        /*
        From a reference Element to GrandChild
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/* (one level keep on cascade)
        2. //tagName[@attribute ='value']/* /tagName
        3. //tagName[@attribute ='value']/tagName/tagName (Parent to Child traverse

        (//div[@class='navFooterLinkCol navAccessibility'])[1]/*
        (//div[@class='navFooterLinkCol navAccessibility'])[1]/ul/li


         */


    }

    public static void approach4() {

        /*
        From a reference Element to Ancestor
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/ancestor::tagName (tagName element will match may skip in between element)
        2. //tagName[@attribute ='value']//ancestor::* (multi upper tags match)

         */

    }

    public static void approach5() {

        /*
        From a reference Element to descendant
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/descendant::tagName (tagName element will match may skip in between element)
        2. //tagName[@attribute ='value']//tagName

        Both format works in similar manner

        / works as parent or child (with no tag jumps)
        // works as ancestor or descendant with tag jumps

         */

    }

    public static void approach6() {

        /*
        From a reference Element to Following Element
        Means all the element below from self element but at the same hierarchy level
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/following::tagName
        2. //tagName[@attribute ='value']/following::* (all elements even within child)

         */

    }

    public static void approach7() {

        /*
        From a reference Element to Preceding Element
        Means all the element above (in DOM) from self element but at the same hierarchy level
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/preceding::tagName
        2. //tagName[@attribute ='value']/preceding::* (all elements even within child)

         */

    }

    public static void approach8() {

        /*
        From a reference Element to Following Sibling Element
        Means all the element below (in DOM) from self element but with same parent.
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/following-sibling::tagName
        2. //tagName[@attribute ='value']/following-sibling::* (all elements even within child)

         */

    }

    public static void approach9() {

        /*
        From a reference Element to Preceding Sibling Element
        Means all the element above (in DOM) from self element but with same parent.
         */

        /*
        Format:
        1. //tagName[@attribute ='value']/preceding-sibling::tagName
        2. //tagName[@attribute ='value']/preceding-sibling::* (all elements even within child)

         */

    }


    public static void main(String[] args) {

        approach1();


    }
}
