package com.nopcommerce;

import org.testng.annotations.Test;


public class TestSuite extends BaseTest {
    //To create object of home page
    HomePage homePage=new HomePage();
    //To create object of book page
    BookPage bookPage=new BookPage();
    //To create object of cart page
    CartPage cartPage=new CartPage();
    //To create object of checkout as guest
    CheckoutAsGuest checkoutAsGuest=new CheckoutAsGuest();
    //To create object of fill checkout details
    FillCheckoutDetails fillCheckoutDetails=new FillCheckoutDetails();
    //To create object of checkout result
    CheckoutResult checkoutResult=new CheckoutResult();
    //To create object of news page
    NewsPage newsPage=new NewsPage();
    //To create object of new online store open page
    NewOnlineStoreIsOpenPage newOnlineStoreIsOpenPage=new NewOnlineStoreIsOpenPage();



 //1)Guest user should be able to checkout successfully
   // @Test
    public void verifyGuestUserShouldAbleToCheckoutSuccessfully()
    {
        //Click on book link
        homePage.clickOnBooksLink();
        //Click on add to cart
        bookPage.clickOnAddToCart();
        //Click on shopping cart
        bookPage.clickOnShoppingCart();
        //To accept on terms and condition
        cartPage.checkTermsAndCondition();
        //Click on checkout
        cartPage.clickOnCheckout();
        //Click on checkout as guest
        checkoutAsGuest.clickOnCheckoutAsGuest();
        //To fill checkout details
        fillCheckoutDetails.fillCheckoutDetails();
        //To verify success message
        checkoutResult.verifyCheckoutSuccessMessage();

    }

    //****************************End of Test case 1********************************************************************




    //2)Guest user should able to add new comment on nope commerce website

   // @Test
    public void userShouldAbleToAddNewCommentOnNopCommerceWebsite()
    {
        //To click on view news archive
        homePage.ClickOnViewNewsArchive();
        //To click on details
        newsPage.clickOnDetails();
        //To add new comment
        newOnlineStoreIsOpenPage.addNewComment();
        //To verify New comment added
        newOnlineStoreIsOpenPage.verifySuccessMessageOfComment();

    }

//********************************End of TestCase 2*********************************************************************




//3)User should able to change currancy ----------------
    @Test
    public void userShouldAbleToChangeCurrency()
    {
        //To click on currency euro
        homePage.clickCurrencyEuro();
        //To verify Euro sign
        homePage.VerifyPriceHasEuroSign();
        //To click on currency dollar
        homePage.clickCurrencyDollar();
        //To verify Dollar sign
        homePage.VerifyPriceHasDollarSign();

    }

//************************************End of Testcase 3*******************


//4)Verify add to cart button is present on all featured product

   // @Test
    public void verifyAddToCartButtonIsPresentOnAllFeaturedProducts()
    {
     //To verify add to cart is present in all featured products
     homePage.verifyAddToCartPresentOnHomepageFeaturedItems();

    }


//************************************End of TestCAse 5*******************

}
