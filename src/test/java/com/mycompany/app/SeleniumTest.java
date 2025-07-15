package com.mycompany.app;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;

public class SeleniumTest {

    @Test
    public void testGoogleTitle() throws Exception {
        // Set path to ChromeDriver if needed
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Create a temporary user data directory
        Path tempProfile = Files.createTempDirectory("chrome-profile");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath());

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        assert title.contains("Google");

        driver.quit();
    }
}
