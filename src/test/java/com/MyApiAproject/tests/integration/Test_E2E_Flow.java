package com.MyApiAproject.tests.integration;

import com.MyApiAproject.base.BaseTest;
import com.MyApiAproject.endpoints.APIConstants;
import com.MyApiAproject.pojos.Booking;
import com.MyApiAproject.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import javax.swing.*;

public class Test_E2E_Flow extends BaseTest {

    @Test(priority = 1)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyCreateBooking(ITestContext iTestContext)
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .post();
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        assertAction.verify_String_Response_Body(bookingResponse.getBooking().getFirstname(),"sanket");
        assertAction.verify_String_Response_Body(bookingResponse.getBooking().getLastname(),"ghadmode");
        assertAction.verify_IntegerKey(bookingResponse.getBooking().getTotalprice());
        assertAction.verify_Boolean_value(bookingResponse.getBooking().getDepositpaid());
        assertAction.verify_String_Response_Body(bookingResponse.getBooking().getBookingdates().getCheckin(),"2024-02-01");
        assertAction.verify_String_Response_Body(bookingResponse.getBooking().getBookingdates().getCheckout(),"2024-02-01");
        assertAction.verify_String_Response_Body(bookingResponse.getBooking().getAdditionalneeds(),"Breakfast");

        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());


    }

    @Test(priority = 2)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyGetBooking(ITestContext iTestContext)
    {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        System.out.println(bookingid);

          response = RestAssured.given(requestSpecification)
                  .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+bookingid)
                  .when().get();

         validatableResponse = response.then().statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertAction.verify_String_Response_Body(booking.getFirstname(),"sanket");

    }


    @Test(priority = 3)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyUpdateBooking(ITestContext iTestContext)
    {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
       String token = getToken();
       iTestContext.setAttribute("token", token);

       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+bookingid);

       response = RestAssured.given(requestSpecification).cookie("token",token)
               .body(payloadManager.FullUpdate()).put();

       validatableResponse = response.then().statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertAction.verify_String_Response_Body(booking.getFirstname(),"Aniket");
    }

    @Test(priority = 4)
    @Description("#001 sample test case run")
    @Owner("sanket")
    public void testVerifyCreateDeleteBooking(ITestContext iTestContext)
    {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token  = (String)iTestContext.getAttribute("token");


        System.out.println(bookingid);
        System.out.println(token);


        String basepathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL+bookingid;

        requestSpecification.basePath(basepathDelete).cookie("token",token);
        validatableResponse = RestAssured.given().spec(requestSpecification).when().delete().then().log().all();
        validatableResponse.statusCode(201);

     }

}
