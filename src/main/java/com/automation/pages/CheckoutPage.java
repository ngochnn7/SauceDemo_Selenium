package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By checkoutError = By.xpath("//h3[@data-test='error']"); // Dùng cho Functional Test
    
    
    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header"); 

   
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

  

    public void enterShippingInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }
    
    public String getCheckoutErrorMessage() {
        return driver.findElement(checkoutError).getText();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }
    
    public String getOrderCompleteMessage() {
        return driver.findElement(completeHeader).getText();
    }
}