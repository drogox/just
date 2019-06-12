package com.drogox.WebAction;

import org.openqa.selenium.WebElement;

import static com.drogox.WebAction.HTMLTag.INPUT;
import static com.drogox.WebAction.HTMLTag.TEXTAREA;

public class Populate implements Build {
    private static HTMLTag htmlTag;
    private final String locator;
    private final String value;
    private final MatchMode matchMode;
    private final String parentLocator;

    private Populate(HTMLTag htmlTag, String locator, String value, MatchMode matchMode, String parentLocator) {
        Populate.htmlTag = htmlTag;
        this.locator = locator;
        this.value = value;
        this.matchMode = matchMode;
        this.parentLocator = parentLocator;
    }

    @Override
    public void build() {
        WebElement webElement = new BuildWebElement(parentLocator, locator, matchMode).find();
        webElement.clear();
        webElement.sendKeys(value);
    }

    public static PopulateBuilder toTextField(String locator) {
        htmlTag = INPUT;
        return new PopulateBuilder(htmlTag, locator);
    }

    public static PopulateBuilder toTextArea(String locator) {
        htmlTag = TEXTAREA;
        return new PopulateBuilder(htmlTag, locator);
    }

    public static class PopulateBuilder {

        private String locator;
        private MatchMode matchMode;
        private String parentLocator;
        private HTMLTag htmlTag;

        public PopulateBuilder(HTMLTag htmlTag, String locator) {
            this.htmlTag = htmlTag;
            this.locator = locator;
        }

        public PopulateBuilder matchMode(MatchMode matchMode) {
            this.matchMode = matchMode;
            return this;
        }

        public PopulateBuilder underParent(String parentLocator) {
            this.parentLocator = parentLocator;
            return this;
        }

        public void withValue(String value) {
            new Populate(htmlTag, locator, value, matchMode, parentLocator).build();
        }
    }
}
