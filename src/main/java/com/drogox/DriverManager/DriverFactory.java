package com.drogox.DriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String driverType) {

        return new ChromeDriver();
    }
}
