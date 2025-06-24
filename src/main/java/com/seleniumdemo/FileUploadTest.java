package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");

            WebElement uploadInput = driver.findElement(By.xpath("//input[@id='myFile']"));


            String filePath = "/home/salina/Downloads/salina.jpeg";  

            uploadInput.sendKeys(filePath); 

            System.out.println("File uploaded.");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
