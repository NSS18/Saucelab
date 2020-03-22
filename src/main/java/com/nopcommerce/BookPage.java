package com.nopcommerce;

import org.openqa.selenium.By;

//on the book page
public class BookPage extends Utils {
    //locator to click add to cart
    private By _clickOnAddToCart=By.xpath("//div[@data-productid=\"38\"]/div[2]/div[3]/div[2]/input[1]");
    //Locator to click on shopping cart
    private By _clickOnShoppingCart=By.xpath("//div[@class=\"bar-notification success\"]/p/a");

    //click on add to cart
    public void clickOnAddToCart()
    {
        scrollAndClick(_clickOnAddToCart);
    }

    //click on shopping cart
    public void clickOnShoppingCart()
    {
        timeDelay(2);
        scrollAndClick(_clickOnShoppingCart);
    }
}