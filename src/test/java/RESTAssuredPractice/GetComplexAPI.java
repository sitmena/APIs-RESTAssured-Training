package RESTAssuredPractice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetComplexAPI {
    @Test
    public void getComplexAPITest(){

        baseURI = "http://localhost:3000";



        String body = null;

        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();


        item.put("addressType", "Office");
        item.put("country", "Jordan");
        item.put("city", "Amman");
        item.put("zipCode", "1234");
        array.put(item);



        String jsonString = new JSONObject()
                .put("address", array)
                .toString();


        System.out.println("/////////////////"+jsonString);

        body = jsonString;

        // 1- Get Method
        Response response =
                given()
//                        .header("id", 10)
                        .when()
                        .body(body)
                        .patch("/persons/1")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .log().all()  // This is to log all the response on the consol
                        .contentType(ContentType.JSON)
                        .extract().response();


        String responeContent = response.jsonPath().prettify();

        System.out.println("Response is:\n"+responeContent);
        System.out.println("/////////////////"+jsonString);


        // Verifications and extracting needed values go here

        // Assertion using TestNG assertion library
        Assert.assertEquals(response.getStatusCode(), 200, "header status code is not 200");

/*
        // Showing specific fields' values
        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("address is:    "+jsonPathEvaluator.get("address"));

        System.out.println("List of all cities is:    "+jsonPathEvaluator.get("address.city"));
        System.out.println("List of all cities is:    "+jsonPathEvaluator.getList("address[0].city"));




        System.out.println("First city is:    "+jsonPathEvaluator.get("address[0].city[0]"));
        System.out.println("Second city is:    "+jsonPathEvaluator.get("address[0].city[1]"));

        // Another way of getting a specific field key's value from Json
        System.out.println("cities : "+ JsonPath.from(response.getBody().asString()).get("address[0].city[1]"));

*/

        /////////////////////////////////////////////////////////////////////////////////

        ///////////////////// Assertion using Hamcrest  //////////////////////////////////////

/*
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> cities = new ArrayList<>();

        // Not filtered
        cities=   jsonPathEvaluator.getList("address[0].city");

        // filtered cities
        List<String> filteredCities = cities.stream()
                .filter(name -> name.equals("New York"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("cities are:  "+cities);
        System.out.println("filteredCities are:  "+filteredCities);



        // Assert that the List has Item
        assertThat(filteredCities, hasItem("New York"));

        // assert that the List has Items
        assertThat(cities, hasItems("New York", "Chicago"));

        // assert that the List contains Items [it's not recommended] play with it and observe why
        assertThat(cities, contains("Chicago", "New York"));




        // forEach using Lambda expression to traverse over cities list and print each one
        cities.stream()
                .forEach(city ->
                        {
                            if (city.equals("Chicago"))
                                System.out.println("It's Chicago!");

                        }
                );


        // Assertion by TestNG
        boolean cityFound = false;
        for(int i = 0; i<cities.size() ; i++){

            if(cities.contains("Chicago")){
                cityFound = true;
            }
        }
        Assert.assertTrue(cityFound, "city is not found!");






        List<String> citis = new ArrayList<String>();
        citis = JsonPath.from(response.getBody().asString()).get("address[0].city");  // Try change it to .get("address.city");
        System.out.println("last cities ArrayList"+ citis);

*/

        /////////////////////////////////////////////////////////////////////////////////


/*

        List<String> map = response.jsonPath().get("Map");
        System.out.println("map"+map);


        // This one works
        List<Map<String, String>> types = response.jsonPath().getList("Map");
        System.out.println(types.get(0).get("Key1"));  // Value1

        assertThat(types.get(0), hasKey("Key1"));
        assertThat(types.get(0).get("Key1"), equalTo("Value1"));






        // Checking for key
        // This will pass
        assertThat(JsonPath.from(response.getBody().asString()).get("address[0].city[2]"), nullValue());

        // This will fail
        //assertThat(JsonPath.from(response.getBody().asString()).get("address[0].city[2]"), notNullValue());
*/
    }
}
