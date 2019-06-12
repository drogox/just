package com.drogox.WebAction;

import com.drogox.DriverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuildWebElement {
    private final String parentLocator;
    private final String locator;
    private final MatchMode matchMode;

    public BuildWebElement(String parentLocator, String locator, MatchMode matchMode) {

        this.parentLocator = parentLocator;
        this.locator = locator;
        this.matchMode = matchMode;
    }

    public WebElement find() {
        return DriverManager.getDriver().findElement(By.className(""));
    }
}
