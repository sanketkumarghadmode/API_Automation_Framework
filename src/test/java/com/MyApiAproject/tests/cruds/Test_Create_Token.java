package com.MyApiAproject.tests.cruds;

import com.MyApiAproject.base.BaseTest;
import com.MyApiAproject.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_Create_Token extends BaseTest {



    @Test()
    @Description("Verify Create Token Test")
    @Owner("Sanket")
    public void test_Verify_CreateToken()
    {

        requestSpecification.basePath(APIConstants.AUTH_URL);

        response = RestAssured.given(requestSpecification).when()
                .body(payloadManager.setAuthPayload()).post();

        validatableResponse = response.then().log().all().statusCode(200);

        String token = payloadManager.getTokenFromJSON(response.asString());

        assertAction.verify_StringKeyNotNull(token);

    }





}