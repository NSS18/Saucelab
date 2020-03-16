package com.nopcommerce;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

//class for all reusable methods
public class Utils extends BasePage {

    //Timestamp method for unique text
    public static String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        return(dateFormat.format(date));
    }

    //To click
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //To enter text
    public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //To get text
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }


    //To get text from list


    //To wait until element is clickable
    public static void waitForClickable(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(elementToBeClickable(by));
    }

    // To wait until element is visible
    public static void  waitForVisible(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(visibilityOfElementLocated(by));
    }

    // To wait until element found on web page
    public static void waitForElementPresent(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(presenceOfElementLocated(By.id("FirstName")));

    }

    // To select from drop down box by index
    public static void selectFromDropdownByIndex(By by,int index)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    //To select from drop down box by value
    public static void selectFromDropdownByValue(By by,String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    //To select from drop down box by text
    public static void selectFromDropdownByText(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }


    //To match actual and expected text message
    public static void assertTextMessage(String message,String expected,By by)
    {
        String actual=getTextFromElement(by);
        Assert.assertEquals(message,expected,actual);
    }

    //To check current url
    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //To compare array
    public void compareArray(String accepted[],String actual[]) {
        Assert.assertArrayEquals("price is Not high to low", accepted, actual);
    }

    //For explicit wait
    public void explicitWait(int time)
    {
        WebDriverWait wait=new WebDriverWait(driver,time);
    }

    //for Time dealy
    public static void timeDelay(int time){
        try {
            Thread.sleep(time *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //To verify element displayed
    public static void verifyElementIsDisplayed(By by)
    {
        Assert.assertTrue("add to cart is not there",driver.findElement(by).isDisplayed());
    }

    //to scroll and click
    public static void scrollAndClick(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }

    //To get text and verify from list
    public void getTextFromListAndVerify(By by,String c) {
        //creating obj of soft assert class->for multiple values check
        SoftAssert softAssert = new SoftAssert();
        //creating list and finding value
        List<WebElement> allProduct = driver.findElements(by);
        //for each loop for product comparision
        for (WebElement product : allProduct) {
            //to print price
            System.out.println(product.getText());
            //to verify sign
            softAssert.assertTrue(product.getText().contains(c),"price does not contain "+ c);
        }
        softAssert.assertAll();
    }












    }
