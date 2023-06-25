package newproject;


	




import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;

 class Pathandparam	{
@Test
void testquery()
{
Response res=given()
.when()
.get("http://restapi.adequateshop.com/api/traveler?page=1");
XmlPath xmlobj=new XmlPath(res.asString());
List<String>travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
Assert.assertEquals(travellers.size(),10);

List<String>   traveller_names         =xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

boolean status=false;
for(String names: traveller_names)
{
	if(names.equals("satya"))
	{
		status=true;
		break;
		
	}
}


Assert.assertEquals(status,true);

}}
