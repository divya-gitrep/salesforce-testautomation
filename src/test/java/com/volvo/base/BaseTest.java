package com.volvo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.cdimascio.dotenv.Dotenv;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Dotenv dotenv;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        // load .env
        dotenv = Dotenv.load();

        // setup driver (Chrome example)
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
