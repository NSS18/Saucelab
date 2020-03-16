package com.nopcommerce;

import org.openqa.selenium.By;

// to verify success message
public class CheckoutResult extends Utils {
    //locator for success message
    private By _checkoutSuccessMessege=By.xpath("//div[@class=\"section order-completed\"]/div[1]/strong");
    //accepted value of message
    String accepted ="Your order has been successfully processed!";

    //To verify success message
    public void verifyCheckoutSuccessMessage()
    {
        timeDelay(3);
        //To check we are on right url
        assertURL("checkout/completed/");
        //To verify message
        assertTextMessage("Checkout is not successful",accepted,_checkoutSuccessMessege);
    }



}
