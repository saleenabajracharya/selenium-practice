package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleBrowserTest {

    public static void main(String[] args) {

        // Chrome Thread
        Thread chromeThread = new Thread(() -> {
            System.setProperty("webdriver.chrome.driver", "chromedriver"); 
            WebDriver chromeDriver = new ChromeDriver();
            try {
                chromeDriver.get("https://practicetestautomation.com/practice-test-login/");
                WebElement username = chromeDriver.findElement(By.id("username"));
            WebElement password = chromeDriver.findElement(By.id("password"));
            WebElement loginButton = chromeDriver.findElement(By.cssSelector("#submit"));

   
            username.sendKeys("student");
            password.sendKeys("Password123");


            loginButton.click();

       
            Thread.sleep(3000);
            System.out.println("Login test completed.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                chromeDriver.quit();
            }
        });

        // Firefox Thread
        Thread firefoxThread = new Thread(() -> {
            System.setProperty("webdriver.gecko.driver", "geckodriver"); 
            WebDriver firefoxDriver = new FirefoxDriver();
            try {
                firefoxDriver.get("https://practicetestautomation.com/practice-test-login/");
                WebElement username = firefoxDriver.findElement(By.id("username"));
            WebElement password = firefoxDriver.findElement(By.id("password"));
            WebElement loginButton = firefoxDriver.findElement(By.cssSelector("#submit"));

   
            username.sendKeys("student");
            password.sendKeys("Password123");


            loginButton.click();

       
            Thread.sleep(3000);
            System.out.println("Login test completed.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                firefoxDriver.quit();
            }
        });

        chromeThread.start();
        firefoxThread.start();
    }
}

