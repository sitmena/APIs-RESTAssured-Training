package RESTAssuredPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetMethod {


    @Test
    public void getMethod(){
        baseURI = "http://localhost:3000";




        // First way
//        Map<String, Object[]> josonBody = new HashMap<>();
//        josonBody.put("firstName", new String[]{"Tom", "jkh"});
//        josonBody.put("lastName", new String[]{"Tom","jkh"});
//        josonBody.put("subjectId", new Object[]{3,4});
//
//        JSONObject requestBody = new JSONObject(josonBody);
//
//        String body = requestBody.toString();

        // Second way

//        JSONObject requestBody = new JSONObject();
//        requestBody.put("firstName", "Katty");
//        requestBody.put("lastName", "Perry");
//        requestBody.put("subjectId", 4);
//
//        String body = requestBody.toString();

        // Direct String
        String requestBodystring = new JSONObject()
                .put("firstName", "Basic")
                .put("lastName", "Assertion")
                .put("subjectId", 3)
                .toString();


        //String request_body = new JSONObject()






        Response response =
                given()
                        .header("Content-Type", "application/json")  // This one is mandatory for Post method
//                        .accept(ContentType.JSON)
                        .when()
                        .body(requestBodystring)
                        .post("/users")
                        .then()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .extract().response();

        String responseContenct = response.jsonPath().prettify();
        System.out.println("response is:\n"+responseContenct);


        // Assertion TestNG
        int statusCode = response.statusCode();

        Assert.assertTrue(statusCode == 201, "Status code is not 201");
        String lastName = response.jsonPath().get("lastName").toString();
        System.out.println("lastName value is:"+ lastName);
        //Assert.assertTrue(lastName.equals("Basic"), "Last name does not match expected!");

        Assert.assertEquals(lastName, "hjkhjk", "Last name is not assertion!");

    }
}
