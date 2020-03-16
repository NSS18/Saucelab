package com.nopcommerce;

import org.openqa.selenium.By;

//News page
public class NewsPage extends Utils {
    //locator for details
    private By _details=By.xpath("//div[@class=\"page news-list-page\"]/div[2]/div[1]/div[1]/div[3]/a");
    //To click on details
    public void clickOnDetails()
    {
        //To scroll and click details
        scrollAndClick(_details);
        timeDelay(3);
    }
}
