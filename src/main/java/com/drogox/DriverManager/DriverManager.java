package com.drogox.DriverManager;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverManager {

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            return DriverFactory.createDriver(CHROME);
        }
    }

}
