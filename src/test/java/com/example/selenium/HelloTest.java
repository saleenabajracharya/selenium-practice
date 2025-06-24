package com.example.selenium;

import java.util.Set;

import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelloTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com");
        System.out.println("Main tab title: " + driver.getTitle());
    }

    // @Test
    // public void testNewWindowTab() {
    //     // Open new tab
    //     WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
    //     WebDriver newTab2 = driver.switchTo().newWindow(WindowType.WINDOW);
    //     newTab.get("https://example.com");
    //     newTab2.get("https://www.automationexercise.com/contact_us");
    //     System.out.println("New tab title: " + newTab.getTitle());
    //     System.out.println("New tab title: " + newTab2.getTitle());

    //     // Pause to observe the opened tab
    //     try {
    //         Thread.sleep(3000); // 3 seconds
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }


     
    @Test
    public void testWorkingInBothWindowTabs(){
        //Automatically open and swtich to new window or tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.automationexercise.com/login");
        driver.manage().window().minimize();
        System.out.println("Title:"+ driver.getTitle());

        //Work in new window or tab
        driver.findElement(By.name("email")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.className("btn-default")).click();

        //Get the window ID handles
        Set<String> allWindowTabss = driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabss.iterator();
        String mainFirstWindow = iterate.next();

        //Switch and work in new window or tab
        driver.switchTo().window(mainFirstWindow);
        driver.manage().window().minimize();
        driver.findElement(By.id("susbscribe_email")).sendKeys("Shirt");
        driver.findElement(By.id("subscribe")).click();
        System.out.println("Title:" +driver.getTitle());
    }


}
