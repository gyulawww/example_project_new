package exercise.exercise;

import static com.jayway.restassured.RestAssured.get;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import net.minidev.json.parser.JSONParser;

//For rest assured
import static com.jayway.restassured.RestAssured.*;
//import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

public class AppTest 
{
  
	@Test
	public void testOne() {
		//make get request to fetch capital of norway 
				Response resp = get("http://restcountries.eu/rest/v1/name/norway"); 
				resp.prettyPrint();
				
				// Fetching response in JSON 
				JSONArray jsonResponse = new JSONArray(resp.asString());
				// JSONArray jsonResponse = new JSONArray(resp.asString()); 
				// JsonPath.with(resp.toString());				
				// String capital = JsonPath.with(resp.toString()).getString("name");
				
				//Fetching value of capital parameter
				String capital = jsonResponse.getJSONObject(0).getString("capital"); 
				
				//Asserting that capital of Norway is Oslo 
				System.out.println(capital);
				Assert.assertEquals(capital, "Oslo"); 
	}
	@Test
	public void testTwo() {
		
		// Fetching response in JSON with the most simple way get() and path()
		ArrayList<ArrayList<String>> dataNorway = get("http://restcountries.eu/rest/v1/name/norway").path("languages");
		System.out.println("Languages of Norway: "+dataNorway);
		
		
		//make get request to fetch capital of norway using JsonPath
		Response resp = get("http://restcountries.eu/rest/v1/name/norway"); 
		resp.prettyPrint();
		
		JsonPath jsonPath = new JsonPath(resp.asString());
		List<ArrayList<String>> paramNorway = jsonPath.getList("languages");
		System.out.println("Languages of Norway: "+paramNorway);
		
		
	}
}
