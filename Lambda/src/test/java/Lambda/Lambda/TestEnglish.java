package Lambda.Lambda;

import static com.jayway.restassured.RestAssured.get;

//For TestNG
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//For rest assured
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.stream.Collectors;

import org.hamcrest.Matchers;

//For JsonPath
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

public class TestEnglish {
	
	
@Test
public void testEnglishSpeakingCountries() {
	System.out.println("Collect the countries that name's starts A ");
	Response resp = get("http://restcountries.eu/rest/v1/all"); 
	
	// The reponse is 200 OK ?
	Assert.assertTrue(resp.getStatusCode()==200, "The response status code is wrong: "+resp.getStatusCode()+",");
	
	JsonPath jsonPath = new JsonPath(resp.asString());
	jsonPath.getList("name").stream().filter(s-> ((String) s).startsWith("A")).forEach(System.out::println);
	System.out.println();
	System.out.println("Collect the countries that name's contains 'un' ");
	jsonPath.getList("name").stream().filter(s-> ((String) s).contains("un")).forEach(System.out::println);    
}
}