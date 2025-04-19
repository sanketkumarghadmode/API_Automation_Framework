package com.MyApiAproject.tests.cruds;

import com.MyApiAproject.base.BaseTest;
import com.MyApiAproject.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_HealthCheck extends BaseTest {



    @Test()
    @Description("Verify the HealthCheck")
    @Owner("Sanket")
    public void test_VerifyHealthCheck(){

        requestSpecification.basePath(APIConstants.PING_URL);
        response = RestAssured.given(requestSpecification).when().get();
        validatableResponse = response.then().log().all().statusCode(201);

    }
}
