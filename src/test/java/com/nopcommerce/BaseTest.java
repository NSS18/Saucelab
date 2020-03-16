package com.nopcommerce;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Utils {
    BrowserSelector browserSelector=new BrowserSelector();


    @BeforeTest
    //open browser
    public void openBrowser()
    {
        browserSelector.SetUpBrowser();
    }

    @AfterTest
    //close browser
    public void closeBrowser()
    {
        browserSelector.closeBrowser();
    }

}
