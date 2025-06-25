package com.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownTest {
    public static void main(String[] args) {
        // Set the ChromeDriver path (update if needed)
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        // Launch the browser
        WebDriver driver = new ChromeDriver();

        try {
            // Open a test page with a dropdown
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // Locate the dropdown element
            WebElement dropdownElement = driver.findElement(By.name("my-select"));

            // Wrap the element using Select class
            Select dropdown = new Select(dropdownElement);

            // Print all dropdown options
            List<WebElement> options = dropdown.getOptions();
            System.out.println("Available options:");
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

            // Select by visible text
            dropdown.selectByVisibleText("Two");

            // Select by index (starting from 0)
            dropdown.selectByIndex(1);

            // Select by value attribute
            dropdown.selectByValue("3");

            Thread.sleep(3000); // Just to observe in real time

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
