package com.seleniumdemo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
    public static void main(String[] args) throws IOException {
        Thread frontPage = new Thread(() ->
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver");
        WebDriver firefoxDriver = new FirefoxDriver(); 
        try{
            firefoxDriver.get("https://www.salinab.com.np/");
        WebElement page = firefoxDriver.findElement(By.cssSelector("section#home"));
        File screenshot = ((TakesScreenshot) page).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(screenshot, new File("screenshot.png"));
        }catch (Exception e) {
                e.printStackTrace();
            } finally {
                firefoxDriver.quit();
            }
        
        });
        
Thread fullPage = new Thread(() -> {
            System.setProperty("webdriver.gecko.driver", "geckodriver"); 

            WebDriver firefoxDriver = new FirefoxDriver();

            try {
                firefoxDriver.get("https://www.salinab.com.np/");
                File screenshot = ((FirefoxDriver) firefoxDriver).getFullPageScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot, new File("fullscreenshot.png"));
                System.out.println("Screenshot saved successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                firefoxDriver.quit();
            }
        });
frontPage.start();
fullPage.start();

    }
}
