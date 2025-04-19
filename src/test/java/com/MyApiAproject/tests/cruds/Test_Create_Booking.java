package com.MyApiAproject.tests.cruds;

import com.MyApiAproject.base.BaseTest;
import com.MyApiAproject.endpoints.APIConstants;
import com.MyApiAproject.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_Create_Booking extends BaseTest {


    @Test(priority = 1)
    @Description("Verify the create the booking")
    @Owner("Sanket")
    public void verify_CreateBooking_Post(){

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);


        response = RestAssured.given(requestSpecification)
                .when()
                .body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then()
                .statusCode(200)
                .log().all();


        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());



    }

}
