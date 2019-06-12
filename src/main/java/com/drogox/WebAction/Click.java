package com.drogox.WebAction;

import org.openqa.selenium.WebElement;

import static com.drogox.WebAction.HTMLTag.BUTTON;

public class Click implements Build {
    private final String locator;
    private static HTMLTag htmlTag;
    private final MatchMode matchMode;
    private final String parentLocator;

    private Click(HTMLTag htmlTag, String locator, MatchMode matchMode, String parentLocator) {
        Click.htmlTag = htmlTag;
        this.locator = locator;
        this.matchMode = matchMode;
        this.parentLocator = parentLocator;
    }

    public static ClickBuilder button(String locator) {
        htmlTag = BUTTON;
        return new ClickBuilder(htmlTag, locator);
    }

    @Override
    public void build(){
        WebElement webElement = new BuildWebElement(parentLocator, locator, matchMode).find();
        webElement.click();
    }

    public static class ClickBuilder {
        private final HTMLTag htmlTag;
        private final String locator;
        private MatchMode matchMode;
        private String parentLocator;

        public ClickBuilder(HTMLTag htmlTag, String locator) {

            this.htmlTag = htmlTag;
            this.locator = locator;
        }

        public ClickBuilder matchMode(MatchMode matchMode) {
            this.matchMode = matchMode;
            return this;
        }

        public ClickBuilder underParent(String parentLocator) {
            this.parentLocator = parentLocator;
            return this;
        }

        public void fire() {
            new Click(htmlTag, locator, matchMode, parentLocator).build();
        }
    }
}
