package com.mycompany.app;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void testGoogleTitle() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // adjust path if needed

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // run without GUI
        options.addArguments("--no-sandbox"); // required for CI
        options.addArguments("--disable-dev-shm-usage"); // avoid shared memory issues
        options.addArguments("--disable-gpu"); // optional, improves stability
        options.addArguments("--remote-allow-origins=*"); // required for ChromeDriver 111+

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        assert title.contains("Google");

        driver.quit();
    }
}
