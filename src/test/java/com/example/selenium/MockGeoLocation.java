package com.example.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockGeoLocation {
    ChromeDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mock(){
        Map coordinates = new HashMap(){{
            put("latitude",32.746940);
            put("longitude",-97.092400);
            put("accuracy", 1);
        }};
        driver.executeCdpCommand(
            "Emulation.setGeolocationOverride", coordinates);
            driver.get("https://where-am-i.org/");
    }
    
}
