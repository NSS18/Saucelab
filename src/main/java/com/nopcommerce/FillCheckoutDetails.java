package com.nopcommerce;

import org.openqa.selenium.By;

public class FillCheckoutDetails extends Utils {
    //object of loadprop class
    LoadProp loadProp=new LoadProp();
    //Locator for first name
    private By _firstName=By.id("BillingNewAddress_FirstName");
    //Locator for last name
    private By _lastName=By.id("BillingNewAddress_LastName");
    //Locator for email
    private By _email=By.id("BillingNewAddress_Email");
    //Locator for selecting country
    private By _selectCountry=By.id("BillingNewAddress_CountryId");
    //Locator for city
    private By _city=By.id("BillingNewAddress_City");
    //Locator for address
    private By _address=By.id("BillingNewAddress_Address1");
    //Locator for zip code
    private By _zip=By.id("BillingNewAddress_ZipPostalCode");
    //Locator for phone number
    private By _phoneNo=By.id("BillingNewAddress_PhoneNumber");
    //Locator for billing address
    private By _continueBA=By.xpath("//div[@id=\"billing-buttons-container\"]/input");
    //Locator for shipping address
    private By _continueSA=By.xpath("//div[@id=\"shipping-method-buttons-container\"]/input");
    //Locator for payment method card
    private By _paymentMethodCard=By.xpath("//*[@id=\"payment-method-block\"]/li[2]/div/div[2]/input");
    //Locator for continue - payment method
    private By _continuePM=By.xpath("//div[@id=\"payment-method-buttons-container\"]/input");
    //Locator for selecting credit card
    private By _selectCreditCard=By.xpath("//*[@class=\"info\"]/table/tbody/tr/td[2]/select/option[2]");
    //Locator for card holder's name
    private By _cardHoldersName=By.id("CardholderName");
    //Locator for card number
    private By _cardNo=By.id("CardNumber");
    //Locator for expire year
    private By _expireYear=By.id("ExpireYear");
    //Locator for card code
    private By _cardCode=By.id("CardCode");
    //Locator for continue- payment info
    private By _paymentInfoContinue=By.xpath(("//*[@id=\"payment-info-buttons-container\"]/input"));
    //Locator for confirm
    private By _confirm=By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");


    //To fill checkout details
    public void fillCheckoutDetails()
    {

            //Reading first name from testconfig file
            String firstName = loadProp.getProperty("firstname");
            //To enter first name
            enterText(_firstName, firstName);
            //Reading last name from testconfig file
            String lastName = loadProp.getProperty("lastname");
            //To enter last name
            enterText(_lastName, lastName);
            //Reading email from testconfig file
            String emailAddress = loadProp.getProperty("email");
            //To scroll down
            scrollAndClick(_email);
            //To enter email
            enterText(_email, emailAddress);
            //To select value of country
            selectFromDropdownByValue(_selectCountry, "212");
            //Reading city from testconfig file
            String city = loadProp.getProperty("city");
            //To scroll
            scrollAndClick(_city);
            //To enter city
            enterText(_city, city);
            //Reading address from testconfig file
            String address = loadProp.getProperty("address");
            //To enter address
            enterText(_address, address);
            //Reading zip code from testconfig file
            String zip = loadProp.getProperty("zip");
            //To enter zip
            enterText(_zip, zip);
            //Reading phone number from testconfig file
            String phoneNo = loadProp.getProperty("phoneno");
            //To enter phone number
            enterText(_phoneNo, phoneNo);
            //To click on continue for billing address
            clickOnElement(_continueBA);
            //To click on continue for shipping address
            timeDelay(2);
            clickOnElement(_continueSA);
            //To click on payment card
            clickOnElement(_paymentMethodCard);
            //To click on continue for payment method
            clickOnElement(_continuePM);
            //To select credit cart
            clickOnElement(_selectCreditCard);
            //Reading card holder's name from testconfig file
            String cardHoldersName = loadProp.getProperty("cardholdersName");
            //To enter card holder's name
            enterText(_cardHoldersName, cardHoldersName);
            //Reading card number from testconfig file
            String cardNo = loadProp.getProperty("cardNo");
            //To enter card number
            enterText(_cardNo, cardNo);
            //To select expire year
            selectFromDropdownByValue(_expireYear, "2023");
            //Reading card code from testconfig file
            String cardCode = loadProp.getProperty("cardCode");
            //To enter card code
            enterText(_cardCode, cardCode);
            //To click on continue for payment info
            clickOnElement(_paymentInfoContinue);
            //To click on confirm
            timeDelay(2);
            clickOnElement(_confirm);
        }






    }

