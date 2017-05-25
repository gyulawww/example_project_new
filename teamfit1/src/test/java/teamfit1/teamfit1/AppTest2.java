package teamfit1.teamfit1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;

import org.json.JSONArray;
import net.minidev.json.parser.JSONParser;

// For rest assured
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// For JSON schema validation import:
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import com.jayway.restassured.path.json.JsonPath;

// using Spring MVC you can use the spring-mock-mvc module 
// import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*;
public class AppTest2 {
	@Test(groups = "method2")
	public void examplesRestAssured4() {
		// Megnézi, hogy a 30000- nél kevesebb lakosságú országok között ott
		// van-e "Anguilla":
		when().
		     get("http://restcountries.eu/rest/v1/all").
		then().
		     body("findAll { it.population < 30000 }.name",hasItem("Anguilla"));

	}

	@Test(groups = "method1")
	public void examplesRestAssured5() {
		// Keressük meg, hogy az összes ország neve összerakva hosszab-e mint
		// 2440 character:
		when().
		      get("http://restcountries.eu/rest/v1/all").
		then().
		      body("name.collect { it.length() }.sum()",greaterThan(2440));

	}

	@Test(groups = { "method1", "method2","method3" })
	public void examplesRestAssured6() {
		// Állapítsuk meg, hogy kevesebb mint 248 ország van-e a listában:
		when().
		      get("http://restcountries.eu/rest/v1/all").
		then().
		      body("name.collect { it }.size()", lessThan(248));

	}
	
	@Test(groups = "method3")
	  public void clientRequest1(){
		// Ellenőrizzük le, hogy visszajön-e a 200 OK válasz és a capital elem Budapest-e.
	   when().
	      get("http://restcountries.eu/rest/name/Hungary").
	   then().
	         statusCode(200).
	   body("capital[0]",equalTo("Budapest")).
	   log().body();


	}

	@Test(groups = "method3")
	  public void clientRequestTft2(){
		// Ellenőrizzük le, hogy visszajön-e a 200 OK válasz és Norvégiában 3 beszélt nyelv hivatalos.
	   when().
	      get("http://restcountries.eu/rest/v1/all").
	   then().
	         statusCode(200).
	         and().root("find { it.name == 'Norway' }" ).
	         body("languages[0]",equalTo("no")).
	         and().body("languages.size()",equalTo(3));
	   
	   // Egy másik ellenőrzési lehetőség.
	   List<ArrayList<String>> dataNorway = get("http://restcountries.eu/rest/v1/name/norway").path("languages");
	   System.out.println("Languages of Norway: "+dataNorway);
	   Assert.assertEquals(dataNorway.get(0).size(), 3);
	        
	}
	@Test(groups = "method4")
	  public void clientRequestTft3(){
		// Ellenőrizzük le, hogy az angolul beszélő országok között van-e United Kingdom. 
	   when().
	      get("http://restcountries.eu/rest/v1/all").
	   then().
	         assertThat().statusCode(200).
	         body("findAll { it.languages.contains('en')}.name",hasItems("United Kingdom") ).
	         body("findAll { it.languages.contains('en')}.name",hasItems("Canada","The Bahamas"))        	         
	         ;
	     String s="w";
	     System.out.println(s.getClass());
	     
	     /* when().
	      get("http://restcountries.eu/rest/v1/all").
	      then().statusCode(200).body
	      ("findAll { it.languages.contains('en')}.name",);  */
	    
	}
	@Test(groups = "method3")
	  public void clientRequestTft4(){
		// Ellenőrizzük le, hogy Norvégia esetén a "translations" között szerepel-e a "de" Key.
		ArrayList<HashMap<String, String>> dataNorway = get("http://restcountries.eu/rest/v1/name/norway").path("translations");
		System.out.println("Translations of Norway has 'de' key? "+dataNorway.get(0).containsKey("de"));
		Assert.assertTrue(dataNorway.get(0).containsKey("de")==true, "Translations of Norway hasn't got 'de' key");
	}
	
//	@Test(groups = "method5")
//	  public void clientRequestTft5(){
//		given().log().everything().
//		expect().
//		    statusCode(200).
//		    body("findAll { it.languages.contains('en')}.name",hasItems("Yemen") ).
//		    log().body().
//	    when().
//	      get("http://restcountries.eu/rest/v1/all");	        	         		
//	}
	
}
