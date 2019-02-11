package com.aqacources.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class OpenGoogleTest {

    // Instance of WebDriver
    private WebDriver driver;

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/alla/Documents/chromedriver-2");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();


    }

    /**
     * Open Google page, search and quit
     */
    @Test
    public void testOpenGoogleTest() {

        // Open Google
        driver.get("https://google.com.ua");

        // Send phrase in search input
        driver.findElement(By.name("q")).sendKeys("Automation testing");

        //Click "Search" button
        driver.findElement(By.name("btnK")).click();

        //Find needed link in search results
        driver.findElement(By.xpath("//h3[contains(text(),'Test Automation vs. Automated Testing: The Differe')]")).click();

    }

    /**
     * After method, quit driver
     */
    @After
    public void tearDown() {

        // Quit from Driver. close() just close window,
        // quit() - close all window an driver
        driver.quit();
    }

}
