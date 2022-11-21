package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(name = "login-button")
    public WebElement loginBtn;


    public void login(String username,String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }
}
