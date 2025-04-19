package com.MyApiAproject.base;

import com.MyApiAproject.asserts.Assert_Action;
import com.MyApiAproject.endpoints.APIConstants;
import com.MyApiAproject.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;


public class BaseTest {
      //Common to all
      // baseurl , content type - json - common

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;

    public PayloadManager payloadManager;
    public Assert_Action assertAction;
    public JsonPath jsonPath;


    @BeforeTest()
    public void SetUp()
    {
        payloadManager = new PayloadManager();
        assertAction = new Assert_Action();


       requestSpecification = new RequestSpecBuilder()
               .setBaseUri(APIConstants.BASE_URL)
               .addHeader("Content-Type","application/json")
               .build().log().all();
    }


    public String getToken(){

     requestSpecification = RestAssured.given();
     requestSpecification.baseUri(APIConstants.BASE_URL);
     requestSpecification.basePath(APIConstants.AUTH_URL);

     String payload  = payloadManager.setAuthPayload();
     response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();

     String token = payloadManager.getTokenFromJSON(response.asString());

     return token;

    }


}
