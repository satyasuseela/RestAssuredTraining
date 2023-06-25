package newproject;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class Validation {

@Test
public void jsonschema()
{
  RestAssured  
	.given()
	.baseUri("https://reqres.in/")
	.when()
	.get("api/users/2")
	.then()
	
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
  
}
}
