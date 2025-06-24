package com.example.selenium;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v135.network.Network;
import org.openqa.selenium.devtools.v135.network.model.ConnectionType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkCOnditions {
    ChromeDriver driver;
    DevTools devTools;
    
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        devTools = driver.getDevTools();
    }

    @Test
    public void enableSlowRexJonesII(){
        devTools.createSession();
        devTools.send(Network.enable(
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
        ));
        devTools.send(Network.emulateNetworkConditions(
    false,                      
    150,                           
    2500,                           
    2000,                           
    Optional.of(ConnectionType.CELLULAR3G), 
    Optional.empty(),             
    Optional.empty(),              
    Optional.empty()              
));

        driver.get("https://example.com");
        System.out.println("Enable slow network:" +driver.getTitle());
    }

    @Test
    public void doNotEnableRexJonesII(){
        driver.get("https://example.com");
        System.out.println("Donot enable Network:" +driver.getTitle());
    }
}
