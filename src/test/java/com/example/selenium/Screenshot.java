package com.example.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");

    }

    @Test
    public void takeWebElementScreenShot() throws IOException{
        WebElement nextGeneration = driver.findElement(
            By.cssSelector("#post-8>div.pt-default.pb-default")
        );
        File source =  nextGeneration.getScreenshotAs(OutputType.FILE);
        File destination = new File("Next Generation Screenshot2.png");
        FileHandler.copy(source, destination);
    }
    @Test
    public void takeWebElementScreenShotSection() throws IOException{
        WebElement apptoolNextGeneration = driver.findElement(
            By.cssSelector("#post-8>div.pt-default.pb-default")
        );
        File source =  apptoolNextGeneration.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("Apptools.png"));

    }

    @Test
    public void takeFullPageScreenshot() throws IOException{
        File source =  ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("Applitool FullPage Screenshot.png"));
    }
}
