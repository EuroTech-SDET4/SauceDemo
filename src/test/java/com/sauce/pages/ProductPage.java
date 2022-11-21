package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productHeader;

    @FindBy(css = ".product_sort_container")
    public WebElement dropdownSort;

    @FindBy(css = ".shopping_cart_link")
    public WebElement basket;




    public void sortProduct(String sortType){
        Select select = new Select(dropdownSort);
        select.selectByVisibleText(sortType);
    }

    public void addProduct(String price){
        Driver.get().findElement(By.xpath("//*[text()='"+price+"']/../button")).click();


    }
}
