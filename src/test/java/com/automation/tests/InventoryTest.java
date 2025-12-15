package com.automation.tests;

import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

	// Đây là Functional Test: Kiểm tra chức năng Sắp xếp Z-A (Tên từ Z đến A)
    @Test(priority = 1, description = "Kiểm tra chức năng Sắp xếp sản phẩm theo tên Z-A")
    public void TC_INV_001_SortNameZToA() throws InterruptedException {
        
       
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("standard_user", "secret_sauce");
        
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        
        
        inventoryPage.selectSortOption("za"); 
        
        
        Thread.sleep(1500); 

        
        String firstItemAfterSort = inventoryPage.getFirstProductName();
        
        String expectedProductName = "Sauce Labs T-Shirt (Red)"; // Tên sản phẩm chính xác sau khi sắp xếp Z-A
        
        Assert.assertEquals(firstItemAfterSort, expectedProductName, 
                            "Sắp xếp Z-A thất bại. Sản phẩm đầu tiên không đúng.");
    }
    
    
    @Test(priority = 2, description = "Kiểm tra chức năng Sắp xếp sản phẩm theo giá Low-to-High")
    public void TC_INV_002_SortPriceLowToHigh() throws InterruptedException {
        
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("standard_user", "secret_sauce");
        
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        
        
        inventoryPage.selectSortOption("lohi"); 
        
        Thread.sleep(1500); 

        
        String firstItemAfterSort = inventoryPage.getFirstProductName();
        
        String expectedProductName = "Sauce Labs Onesie"; 
        
        Assert.assertEquals(firstItemAfterSort, expectedProductName, 
                            "Sắp xếp Low-to-High thất bại. Sản phẩm đầu tiên không đúng.");
    }
	
}
