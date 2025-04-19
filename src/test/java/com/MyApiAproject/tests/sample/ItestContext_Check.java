package com.MyApiAproject.tests.sample;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ItestContext_Check {

    @Test(priority = 1)
    public void testSetData(ITestContext context) {
        // Set data into the context
        context.setAttribute("username", "sanket123");

        System.out.println("Username is set in context.");
    }

    @Test(priority = 2)
    public void testGetData(ITestContext context) {
        // Get data from the context
        String username = (String) context.getAttribute("username");

        System.out.println("Username from context: " + username);
    }
}
