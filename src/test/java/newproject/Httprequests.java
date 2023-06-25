package newproject;


import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Httprequests {
     
//@Test(priority=0)
void getuserDetails()
{
	
	when()
	.get("https://reqres.in/api/users?page=2")
     .then()
     .statusCode(200)
     .body("page",equalTo(2))
	.log().all();



RestAssured

	JSONObject data=new JSONObject();
	data.put("name","satya");
	data.put("job","student");
 	
    .given()
	.contentType("application/json")
	.body(data.toString())
     .when()
     .post("https://reqres.in/api/users")
    .then()
    .log().body();
     
}
}