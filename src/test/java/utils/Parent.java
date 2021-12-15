package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class Parent {

    static WebDriverWait wait;

    public Parent()
    {
        wait =new WebDriverWait(BaseDriver.getDriver(), 10);
    }

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        element.click();
    }

    public static void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waiting(int second)
    {
        try {
            Thread.sleep(1000 *second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void randomClick (List<WebElement> element)
    {
        Random rnd = new Random();
        int index = rnd.nextInt(element.size());
        element.get(index).click();
    }

    public void moveTheMouse(WebElement element, int xOffset, int yOffset) {
        try {
            if (element.isDisplayed()) {
                Actions action = new Actions(BaseDriver.getDriver());
                action.clickAndHold(element).moveByOffset(xOffset, yOffset).build().perform();
            } else {
                System.out.println("Element was not displayed to drag");
            }
        } catch (StaleElementReferenceException n) {
            System.out.println("Element with " + element + "is not attached to the page document "	+ n.getStackTrace());
        } catch (NoSuchElementException n) {
            System.out.println("Element " + element + " was not found " + n.getStackTrace());
        } catch (Exception n) {
            System.out.println("Zooming in" + element + " - "	+ n.getStackTrace());
        }
    }
}
