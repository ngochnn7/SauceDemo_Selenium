

package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {

    // Functional Test: Kiểm tra chức năng Xóa sản phẩm khỏi giỏ hàng
    @Test(description = "Kiểm tra chức năng Remove (Xóa) sản phẩm trong trang Giỏ hàng")
    public void TC_CART_001_RemoveItemFromCart() throws InterruptedException {
        
       
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart(); 
        Thread.sleep(1000); 
        
        
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "Lỗi: Giỏ hàng ban đầu không có 1 sản phẩm.");
        
        
        CartPage cartPage = inventoryPage.goToCart();
        Thread.sleep(1500); 
        
        cartPage.removeBackpack();
        Thread.sleep(1500); 
        
        
        int itemsRemaining = cartPage.getCartItemCount();
        
        
        Assert.assertEquals(itemsRemaining, 0, 
                            "Lỗi: Sản phẩm không được xóa hoàn toàn khỏi giỏ hàng. Còn lại: " + itemsRemaining);
        
        System.out.println("Test Case TC_CART_001 PASSED: Xóa sản phẩm khỏi giỏ hàng thành công.");
    }
}