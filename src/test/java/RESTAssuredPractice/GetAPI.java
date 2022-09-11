package RESTAssuredPractice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAPI {

    @Test
    public void getAPITest() {
        baseURI = "http://localhost:3000";



        Response response =
                given()
//                        .header("id", 10)
                        .param("lastName", "Mustafa")
                        .param("lastName", "Jack")
                        .when()
                        .get("/users")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        .contentType(ContentType.JSON)
                        .extract().response();


        String responeContent = response.jsonPath().prettify();

        System.out.println("Response is:\n"+responeContent);


       // String specifcValue = response.jsonPath().get()



        ////////// Another way of sending the request (Not recommended way) //////////
        /*
        // Request Object
      RequestSpecification httpRequest = RestAssured.given();
      // Response Object
       Response response = httpRequest.request(Method.GET, "/persons");
         */


        // Assertion goes here

    }

}
