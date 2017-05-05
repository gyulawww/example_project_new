package teamfit1.teamfit1;

// import junit.framework.Test;
// import junit.framework.TestCase;
// import junit.framework.TestSuite;
import static com.jayway.restassured.RestAssured.get;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
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

public class AppTest{
	
	@Test(groups="method1")
	public void testTeamfit1() {
		        // Make get request to fetch population
				Response resp = get("http://restcountries.eu/rest/v1/all"); 
				resp.prettyPrint();
				System.out.println("Summarize the population of all countries: ");
				
				// Fetching response in JSON 
				JSONArray jsonResponse = new JSONArray(resp.asString());				
				
				// Fetching values of population
				// Load the population data to a LinkedList. LinkedList is faster in addition than ArrayList.
				System.out.println("There are " +jsonResponse.length()+" countries in the data base");				
				LinkedList<Integer> populations = new LinkedList<Integer>();
				for (int i=0; i<jsonResponse.length();i++){
				populations.add(jsonResponse.getJSONObject(i).getInt("population")); 
				}
				System.out.println("The poplations are :" +populations);
				
				// Summarize the population of all countries
				long summa=0;
				Iterator<Integer> populationsIterator = populations.iterator();
				while(populationsIterator.hasNext()){
					summa=summa + populationsIterator.next();
				}
				System.out.println("The sum of the population of all countries: "+ summa);
				System.out.println();
				
	}
	
	@Test(groups="method1")
	public void testTeamfit2() {
				//Make get request to fetch English spoken countries
		        System.out.println("Collect the English speaking countries: ");
				Response resp = get("http://restcountries.eu/rest/v1/all"); 
				// resp.prettyPrint();
				
				// Fetching response in JSON 
				JSONArray jsonResponse = new JSONArray(resp.asString());				
				
				// Collect the countries where language node contains "en"
				LinkedList<String> englishCountries = new LinkedList<String>();
				for (int i=0; i<jsonResponse.length();i++){
				   JSONArray subresp =jsonResponse.getJSONObject(i).getJSONArray("languages");
				   // System.out.println("Subresponse: "+subresp);
				   boolean englishSpoken =false;
				      for(int j=0;j<subresp.length();j++){
					      if(subresp.get(j).toString().equals("en")){
						   englishSpoken=true;
					      }					    
				      }
				   if (englishSpoken==true){
					  englishCountries.add(jsonResponse.getJSONObject(i).getString("name")); 
				   }
				}
				
				// Printout the list of the countries where English is spoken.
				System.out.println("English is spoken: " +englishCountries);
	}
	
	
	@Test (groups="method2")
	public void examplesRestAssured1() { 
		
		    Response resp = get("http://restcountries.eu/rest/v1/name/norway"); 
		    resp.prettyPrint();
		
		    ArrayList<String> capitals = new ArrayList<String>();
		    capitals.add("Oslo");
		    get("http://restcountries.eu/rest/v1/name/norway").then().body("capital", equalTo(capitals));
		    get("http://restcountries.eu/rest/v1/name/norway").then().body("capital", hasItem("Oslo"));
		    get("http://restcountries.eu/rest/v1/all").then().body("capital", hasItems("Oslo"));
	}	    
		    // schema validation, if I had schema
		    // get("http://restcountries.eu/rest/v1/all").then().assertThat().body(matchesJsonSchemaInClasspath("xxxxx-schema.json"));
	@Test (groups="method2")
	public void examplesRestAssured2() {	    
		    // Fetching response toString and into JSONArray 
		    String response = get("http://restcountries.eu/rest/v1/all").asString();
			JSONArray jsonResponse = new JSONArray(response);
			
			// Print all the country names
			LinkedList<String> countries = new LinkedList<String>();
			for (int i=0; i<jsonResponse.length();i++){
				countries.add(jsonResponse.getJSONObject(i).getString("name")); 
			}
		    System.out.println("The names of the countries: "+countries);
	 }	  
	
	@Test (groups="method2")
	public void examplesRestAssured3() {
		   // Megnézi, hogy a 30000- nél kevesebb lakosságú országok között ott van-e Aland Islands:
		    when().
		        get("http://restcountries.eu/rest/v1/all").
		    then().
		        body("findAll { it.population < 30000 }.name",hasItem("Åland Islands")).
		        body("findAll { it.population < 80000 }.name",hasItem("Andorra"));
	     } 

    @Test (groups="method4")
    public void neighboursOfHungary()
    //Kiirjuk Magyarorszag szomszédait.
    {  
    	Response resp= get ("http://restcountries.eu/rest/v1/name/hungary");
    	resp.prettyPrint();
    	JSONArray jsonResp= new JSONArray(resp.asString());
    	JSONArray neighbours = jsonResp.getJSONObject(0).getJSONArray("borders");
    	System.out.println("Magyarorszag szomszedai: "+neighbours);
    }
    
    @Test(groups="method4")
    @Parameters("countryName")
    // Irjuk ki az összes olyan országot, aminek a beadott ország a szomszédja.
    // Erőltetetten keressünk, hogy ő melyikben szerepel.
    // TestNG parameter átadás az xml-ből.
    public void whatAreTheNeighbours(String countryName)
    { 
    	System.out.println("Parameterized value is : " + countryName);
    	Response resp= get("http://restcountries.eu/rest/v1/all");
    	JSONArray respJson= new JSONArray(resp.asString());
    	ArrayList<String> neighbours= new ArrayList<String>();
    	for(int i=0;i<respJson.length();i++)
    	{
    		JSONArray sub=respJson.getJSONObject(i).getJSONArray("borders");
    		boolean neighbour=false;
    		for(int j=0;j<sub.length();j++)
    		{
    			if(sub.get(j).toString().equals(countryName))
    			  {
   				  neighbour=true;   				
    			  }   			
    		}
    		if(neighbour==true){
				neighbours.add(respJson.getJSONObject(i).getString("name"));
			}
    	}
    	
        System.out.println("A szomszédok: "+neighbours);
    }
      
    @Test(groups="method4")
    public void callingCodes()
    {
    	// Gyűjtsük ki azon országok hívószámait, amelyek kisebbek 10-nél.
    	Response resp= get("http://restcountries.eu/rest/v1/all");
    	JSONArray respJson= new JSONArray(resp.asString());
    	for (int i=0;i<respJson.length();i++){
    		Integer tmp=12;
    		if (!respJson.getJSONObject(i).getJSONArray("callingCodes").get(0).toString().equals("")){
    			tmp =Integer.parseInt(respJson.getJSONObject(i).getJSONArray("callingCodes").get(0).toString());	
    		}
    		if (tmp <10){
    		   System.out.print("Ország: "+respJson.getJSONObject(i).getString("name")+", ");
    		   System.out.print("Hívószám: "+respJson.getJSONObject(i).getJSONArray("callingCodes").get(0).toString());
    		   System.out.println();
    	       }
    	}
    }
    
    @Test(groups="method4")
    public void arrayCollect()
    {
    	// Hogy irjak Magyarországot németül?
    	Response resp= get("http://restcountries.eu/rest/v1/name/hungary");
    	JSONArray respJson= new JSONArray(resp.asString());
    	System.out.println("translations: "+respJson.getJSONObject(0).getJSONObject("translations").get("de").toString());
    }
    
}
