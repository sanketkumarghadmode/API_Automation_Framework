package com.MyApiAproject.asserts;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.*;


public class Assert_Action {


    public void verify_String_Response_Body(String actual,String expected){
        Assert.assertEquals(actual, expected);
    }

    public void verify_Integer_Response_Body(int actual,int expected){
        Assert.assertEquals(actual, expected);
    }

    public void verify_StatusCode(Response response, Integer expected){
        Assert.assertEquals(response.getStatusCode(),expected);
    }

    public void verify_IntegerKey(Integer KeyActual){
        assertThat(KeyActual).isNotNull();
        assertThat(KeyActual).isNotNegative();
        assertThat(KeyActual).isNotZero();
    }

    public void verify_Boolean_value(boolean Key){
        assertThat(Key).isTrue().isNotNull();
    }

    public void verify_StringKeyNotNull(String KeyExpect){

        assertThat(KeyExpect).isNotNull();
    }

}
