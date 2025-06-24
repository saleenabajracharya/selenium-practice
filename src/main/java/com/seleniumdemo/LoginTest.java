package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "chromedriver"); 

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/"); 

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("#submit"));

   
            username.sendKeys("student");
            password.sendKeys("Password123");


            loginButton.click();

       
            Thread.sleep(3000);
            System.out.println("Login test completed.");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit(); 
        }
    }
}
