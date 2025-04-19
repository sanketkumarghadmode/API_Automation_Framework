package com.MyApiAproject.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationSamples {



    @Test(priority = 1)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyCreateBooking( )
    {


        Assert.assertTrue(true);
    }

    @Test(priority = 1)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyGetBooking()
    {
        Assert.assertTrue(true);
    }


    @Test(priority = 1)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyUpdateBooking()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 1)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyCreateDeleteBooking()
    {
        Assert.assertTrue(true);
    }


}
