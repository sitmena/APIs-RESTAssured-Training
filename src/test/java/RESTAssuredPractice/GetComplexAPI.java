package RESTAssuredPractice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetComplexAPI {
    @Test
    public void getComplexAPITest(){

        baseURI = "http://localhost:3000";


        // 1- Get Method
        Response response =
                given()
//                        .header("id", 10)
                        .when()
                        .get("/persons")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        .contentType(ContentType.JSON)
                        .extract().response();


        String responeContent = response.jsonPath().prettify();

        System.out.println("Response is:\n"+responeContent);



        // Verifications and extracting needed values go here

        // Assertion using TestNG assertion library
        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");







        // Assertion using Hamcrest assertion library




        // Showing specific fields' values
        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("List of all cities is:    "+jsonPathEvaluator.get("address.city"));
        System.out.println("List of all cities is:    "+jsonPathEvaluator.getList("address[0].city"));

        System.out.println("First city is:    "+jsonPathEvaluator.get("address[0].city[0]"));
        System.out.println("Second city is:    "+jsonPathEvaluator.get("address[0].city[1]"));

        // Another way of getting a specific field key's value from Json
        System.out.println("cities : "+ JsonPath.from(response.getBody().asString()).get("address[0].city[1]"));



        ///////////////////////////////////////////////////////////

/*
        List<String> cities = new ArrayList<>();
        cities=   jsonPathEvaluator.getList("address[0].city");

        List<String> filteredCities = cities.stream()
                .filter(name -> name.equals("New York"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("filteredCities are:  "+filteredCities);

        // Assert that the List has Item
        assertThat(filteredCities, hasItem("New York"));

        // assert that the List has Items
        assertThat(cities, hasItems("New York", "Chicago"));


        cities.stream()
                .forEach(city ->  System.out.println("city: "+city));


        List<String> citis = new ArrayList<String>();
        citis = JsonPath.from(response.getBody().asString()).get("address[0].city");
        //assertThat((new Object[]{citis.get(0), citis.get(1)}), is(new Object[]{"Chicago", " New York"}));




//        Map<String, String> map = response.jsonPath().getMap("Map");
//        System.out.println(map.get("Key1"));
//        assertThat(map, hasKey("Key2"));

        List<String> map = response.jsonPath().get("Map");
        System.out.println("map"+map);

        // This one works
        List<Map<String, String>> types = response.jsonPath().getList("Map");
        System.out.println(types.get(0).get("Key1"));

        assertThat(types.get(0), hasKey("Key1"));
        assertThat(types.get(0).get("Key1"), equalTo("Value1"));

        // This will pass
        assertThat(JsonPath.from(response.getBody().asString()).get("address[0].city[2]"), nullValue());

        // This will fail
        //assertThat(JsonPath.from(response.getBody().asString()).get("address[0].city[2]"), notNullValue());
*/
    }
}
