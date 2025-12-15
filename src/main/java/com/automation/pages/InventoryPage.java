package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

	private WebDriver driver;

    
    private By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack"); 
    private By bikeLightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light"); 
    private By shoppingCartLink = By.className("shopping_cart_link"); 
    private By cartBadge = By.className("shopping_cart_badge");
    
    
    private By sortDropdown = By.className("product_sort_container"); 
    private By firstProductName = By.xpath("//div[@class='inventory_list']/div[1]//div[@class='inventory_item_name']");

    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Actions cho E2E Test ---

    public void addBackpackToCart() {
        driver.findElement(backpackAddToCartButton).click();
    }
    
    public void addBikeLightToCart() {
        driver.findElement(bikeLightAddToCartButton).click();
    }

    public CartPage goToCart() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }
    
    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }
    
    // --- Actions cho Functional Test ---
    
    public void selectSortOption(String value) {
        // Các giá trị (value) là: az, za, lohi, hilo
        driver.findElement(sortDropdown).sendKeys(value); 
    }
    
    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }
}
