package com.seleniumdemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        WebDriver driver = new ChromeDriver();
        try{
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText()); 
        Thread.sleep(3000);
        alert.accept(); 

        driver.quit();
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

