package com.drogox.WebAction;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PopulateTest {

    @BeforeClass
    public static void before() {

    }

    @AfterClass
    public static void after() {

    }

    @Test
    public void when_populate_to_text_field() {
        Populate.toTextField("").matchMode(MatchMode.EXACT).underParent("").withValue("");
        Click.button("").matchMode(MatchMode.EXACT).underParent("").fire();

    }
}
