
package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    // Functional Test: Kiểm tra xử lý lỗi khi bỏ trống trường Postal Code
    @Test(description = "Kiểm tra lỗi khi thiếu Postal Code ở bước Checkout Information")
    public void TC_CHK_001_MissingPostalCodeError() throws InterruptedException {
        
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart(); 
        
        
        CartPage cartPage = inventoryPage.goToCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        Thread.sleep(1000); 

        
        checkoutPage.enterShippingInformation("Test", "User", ""); 
        Thread.sleep(1000); 
        
       
        String actualErrorMessage = checkoutPage.getCheckoutErrorMessage();
        
        
        String expectedErrorMessage = "Error: Postal Code is required";
        
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, 
                            "Lỗi: Thông báo lỗi không chính xác hoặc không xuất hiện.");
        
        System.out.println("Test Case TC_CHK_001 PASSED: Thông báo lỗi thiếu Postal Code hiển thị đúng.");
    }
}