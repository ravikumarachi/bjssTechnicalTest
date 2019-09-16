package com.restAssured;

import com.jayway.restassured.response.Response;
import org.json.simple.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class services {
    private String host = "http://dummy.restapiexample.com/api/v1/";
    private Response response;


    public Response post(String service, JSONObject postBody) {

        return response = (Response) given().log().all().
                when().
                body(postBody).
                post(host + service).
                then().
                extract().
                response();
    }


}
