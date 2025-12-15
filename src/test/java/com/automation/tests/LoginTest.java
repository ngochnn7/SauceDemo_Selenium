package com.automation.tests;

import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

	
    @Test
    public void TC_Login_001_SuccessfulLogin() {
      
        LoginPage loginPage = new LoginPage(driver);
        
        
        loginPage.login("standard_user", "secret_sauce"); 
        
       
        String expectedUrlPart = "inventory.html"; 
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart), 
                          "Đăng nhập thành công nhưng URL không đúng.");
    }
    
    @Test
    public void TC_Login_002_InvalidPassword() {
       
        LoginPage loginPage = new LoginPage(driver);
        
        
        loginPage.login("standard_user", "wrong_password"); 
        
        
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, 
                            "Thông báo lỗi hiển thị không đúng.");
    }
	
}
