package RESTAssuredPractice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteAPI {

    @Test
    public void deleteAPITest(){
        baseURI = "http://localhost:3000";
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .delete("/users/12")
                        .then()
                        .statusCode(200)  ///////////// PAY ATTENTION RIGHT HERE IT'S DELETE THEN 200
                        .log().all()  // This is to log all the response on the consol
                        .extract().response();

        String responeContent = response.jsonPath().prettify();

        System.out.println("Response is:\n"+responeContent);
    }
}
