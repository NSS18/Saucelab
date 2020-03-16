package com.nopcommerce;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


//for homepage links
public class HomePage extends Utils {
    //Locator for Book link
    private By _bookLink=By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a");
    //Locator for view news archive
    private By _viewNewsArchive=By.xpath("//div[@class=\"view-all\"]/a");
    //Locator for change currency
    private By _changeCurrency=By.id("customerCurrency");
    //Locator for feature product list price in Dollar
    private By _featureProductListDollar=By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div/div/div[2]/div[3]/div[1]/span");
    //Locator for feature product list price in Euro
    private By _featureProductListEuro=By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div/div/div[2]/div[3]/div[1]/span");
    //Locator for featured grid
    private By _listOfItems=By.xpath("//div[@class=\"product-item\"]");
    //Locator for item box
    private By _addToCart = By.cssSelector(".item-box>div input[value='Add to cart']");



    //To click on books link
    public  void clickOnBooksLink()
    {
     waitForClickable(_bookLink,30);
     clickOnElement(_bookLink);
     timeDelay(2);
    }

    //To click on news archive
    public void ClickOnViewNewsArchive()
    {
        scrollAndClick(_viewNewsArchive);
        timeDelay(3);
    }

    //To click currency Euro
    public void clickCurrencyEuro()
    {
        scrollAndClick(_changeCurrency);
        selectFromDropdownByText(_changeCurrency,"Euro");
    }


    //To click currency Dollar
    public void clickCurrencyDollar()
    {
        scrollAndClick(_changeCurrency);
        selectFromDropdownByText(_changeCurrency,"US Dollar");
    }


  //To verify price has Euro sign
   public void VerifyPriceHasEuroSign()
   {
       getTextFromListAndVerify(_featureProductListEuro,"Ђ");
   }


    //To verify price has dollar sign
    public void VerifyPriceHasDollarSign()
    {
        getTextFromListAndVerify(_featureProductListDollar,"$");
    }

    //To verify add to cart present
    public void verifyAddToCartPresentOnHomepageFeaturedItems()
    {   //List
        List<WebElement> listOfItems=driver.findElements(_listOfItems);
        //To count add to cart count
        int actualAddToCartCount = driver.findElements(_addToCart).size();
        //To print add to cart count
        System.out.println("Add to cart count is -------->>> "+actualAddToCartCount);
        int expectedAddToCartCount=4;
        //For each loop for all items
        for(WebElement item:listOfItems)
        {
            //To check if add to cart text is present or not
            if(item.getAttribute("innerHTML").contains("Add to cart"))
            {
                System.out.println(item.getText()+" : has Add to cart button");
            }
            else
                System.out.println(item.getText()+" : does not have Add to cart button");
                System.out.println("--------------------------------------------------------------------------");


        }
        //Comparing expected and actual number of add to cart button
        Assert.assertEquals("All product does not have Add to cart button: ",expectedAddToCartCount,actualAddToCartCount);
    }




    }








