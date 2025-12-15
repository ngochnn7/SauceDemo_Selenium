package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	protected WebDriver driver;

    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    private final By usernameField = By.id("user-name"); 
    private final By passwordField = By.id("password"); 
    private final By loginButton = By.id("login-button"); 
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    // Hành động Đăng nhập tổng hợp
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
	
	
}
