
package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class E2ETest extends BaseTest {
    
    //  E2E Test: Kịch bản dài, gọi nhiều Page Object để hoàn thành một luồng nghiệp vụ
    @Test(priority = 1, description = "Kiểm tra toàn bộ luồng mua hàng thành công")
    public void TC_E2E_001_PurchaseFlowSuccessfully() throws InterruptedException {
        
        // 1. Đăng nhập (Page: LoginPage)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1500); // Tạm dừng để quan sát

        // 2. Thêm Sản phẩm (Page: InventoryPage)
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.addBikeLightToCart();
        // Kiểm tra tổng số lượng sản phẩm trong giỏ hàng
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "2", "Lỗi: Số lượng giỏ hàng không đúng.");
        
        // 3. Vào Giỏ hàng (Chuyển Page: InventoryPage -> CartPage)
        CartPage cartPage = inventoryPage.goToCart();
        Thread.sleep(1500);
        
        // 4. Bắt đầu Thanh toán (Chuyển Page: CartPage -> CheckoutPage)
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        Thread.sleep(1500);
        
        // 5. Điền thông tin giao hàng (Page: CheckoutPage)
        checkoutPage.enterShippingInformation("Tester", "Automation", "70000");
        Thread.sleep(1500); 
        
        // 6. Xác nhận đơn hàng (Bước cuối cùng của Checkout)
        checkoutPage.clickFinish();
        Thread.sleep(1500);
        
        // 7. Xác minh Kết quả Cuối cùng
        String completeMessage = checkoutPage.getOrderCompleteMessage();
        String expectedMessage = "Thank you for your order!";
        
        Assert.assertEquals(completeMessage, expectedMessage, 
                            "Lỗi: Thanh toán không thành công, thông báo không khớp.");
        
        System.out.println("Test Case TC_E2E_001 PASSED: Luồng mua hàng thành công.");
    }
}