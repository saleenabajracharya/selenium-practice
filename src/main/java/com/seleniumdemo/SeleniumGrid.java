package com.seleniumdemo;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {
    public static void main(String[] args) throws Exception {
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities chromeCaps = new DesiredCapabilities();
        chromeCaps.setBrowserName("chrome");
        chromeCaps.setPlatform(Platform.LINUX);

        WebDriver driver = new RemoteWebDriver(gridUrl, chromeCaps);

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();
            System.out.println("Title after login: " + driver.getTitle());
            Thread.sleep(3000);
        } finally {
            driver.quit();
        }
    }
}
