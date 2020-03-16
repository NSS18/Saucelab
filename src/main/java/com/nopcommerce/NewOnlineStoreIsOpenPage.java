package com.nopcommerce;

import org.openqa.selenium.By;

//new online store is open page
public class NewOnlineStoreIsOpenPage extends Utils {

    //locator for Title
    private By _title=By.xpath("//input[@class=\"enter-comment-title\"]");
    //Object of load prop class
    LoadProp loadProp=new LoadProp();
    //Locator for comment
    private By _comment=By.xpath("//*[@id=\"AddNewComment_CommentText\"]");
    //Locater for New comment
    private By _newComment=By.xpath("//*[@id=\"comments\"]/form/div[2]/input");
    //locator for success message
    private By _successmessege=By.xpath("//div[@class=\"notifications\"]/div");


    //To add new comment
    public void addNewComment()
    {
        //To scroll and click title
        scrollAndClick(_title);
        //Reading title from test config file
        String title=loadProp.getProperty("title");
        //To enter title
        enterText(_title,title);
        //Reading comment from test config file
        String comment=loadProp.getProperty("comment");
        //To enter comment
        enterText(_comment,comment);
        //To click on new comment
        clickOnElement(_newComment);
    }

    public void verifySuccessMessageOfComment()
    {
        //expected messege
        String expected="News comment is successfully added.";
        //To compare accepted message with actual
        timeDelay(2);
        assertTextMessage("New Comment is not added successfully",expected,_successmessege);

    }
}
