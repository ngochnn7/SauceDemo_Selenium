package com.automation.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Collections; // BẮT BUỘC để dùng Collections.singletonMap

public class BaseTest {
    
   
    protected WebDriver driver;

    
    @BeforeMethod
    public void setup() {
        
        WebDriverManager.chromedriver().setup(); 
        
        // 1. KHỞI TẠO CHROME OPTIONS ĐỂ TẮT POP-UP LƯU MẬT KHẨU
        ChromeOptions options = new ChromeOptions();
        
        // Tắt Pop-up "Save Password"
        options.addArguments("--disable-save-password-bubble"); 
        
        // Ẩn thông báo "Chrome is being controlled by automated test software" (Không bắt buộc, nhưng tốt hơn)
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
        
        // FIX LỖI CẤU TRÚC COLLECTIONS: Tắt tính năng quản lý mật khẩu của Chrome
        options.setExperimentalOption("prefs", 
            Collections.singletonMap("credentials_enable_service", false));
        options.setExperimentalOption("prefs", 
            Collections.singletonMap("profile.password_manager_enabled", false));
        
        // 2. KHỞI TẠO DRIVER VỚI CÁC THAM SỐ ĐÃ CẤU HÌNH
        driver = new ChromeDriver(options); 
        
      
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        
      
        driver.get("https://www.saucedemo.com/");
    }

   
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}