package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    
    private By checkoutButton = By.id("checkout");
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack"); // Dùng cho Functional Test
    private By firstItemName = By.xpath("//div[@class='cart_list']/div[3]//div[@class='inventory_item_name']");
    private By cartItemCount = By.xpath("//div[@class='cart_list']//div[@class='cart_item']"); // Dùng để đếm

    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

  
    
    public String getFirstItemNameInCart() {
        return driver.findElement(firstItemName).getText();
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
    
    // Functional Test Action: Xóa sản phẩm đầu tiên
    public void removeBackpack() {
        driver.findElement(removeBackpackButton).click();
    }
    
    // Functional Test Assertion: Đếm số lượng sản phẩm còn lại
    public int getCartItemCount() {
        return driver.findElements(cartItemCount).size();
    }
}