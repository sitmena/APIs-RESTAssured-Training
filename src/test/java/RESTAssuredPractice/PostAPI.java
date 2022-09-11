package RESTAssuredPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostAPI {

    @Test
    public void postAPITest() {


        baseURI = "http://localhost:3000";

        String body;

        /* First way:
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();

        String jsonString = new JSONObject()
                .put("firstName", "Leen")
                .put("lastName", "Omar")
                .put("subjectId", 4)
                .toString();

        body = jsonString;*/

        //  Second way:
        Map<String, Object> hmPostBody = new HashMap<>();
        hmPostBody.put("firstName", "Ruba");
        hmPostBody.put("lastName", "Mustafa");
        hmPostBody.put("subjectId", 4);

        JSONObject rq = new JSONObject(hmPostBody);

        body = rq.toString();

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(body)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)  ///////////// PAY ATTENTION RIGHT HERE IT'S POST THEN 201
                        .log().all()  // This is to log all the response on the consol
                        .extract().response();

        String responeContent = response.jsonPath().prettify();

        System.out.println("Response is:\n"+responeContent);

    }
}
