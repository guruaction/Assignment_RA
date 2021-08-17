import org.testng.annotations.Test;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import org.json.simple.JSONObject;
import groovy.util.logging.Log;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import java.net.URI;
import java.net.http.HttpResponse.BodyHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.List.*;
import static java.util.regex.Matcher.*;
import static java.util.regex.Pattern.*;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.regex.Pattern; 

@Test

public class Assignment_RA  {
	
	 public static boolean isValid(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
	                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
	 
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
	    } 
	 		
	public static void assignment ()
	
	{
			//GET Request - Status code
		
			Response response = given().when().get("https://jsonplaceholder.typicode.com/users");
			Assert.assertEquals(response.getStatusCode(), 200);
			
			//Search User / name	
			
			Assert.assertEquals(response.jsonPath().getString("[8].username"),"Delphine");
			Assert.assertEquals(response.jsonPath().getString("[8].name"),"Glenna Reichert");
			Assert.assertEquals(response.jsonPath().getString("[8].email"),"Chaim_McDermott@dana.io");
			
			
			//POST Request - Comment 
			
			JSONObject request = new JSONObject();
			request.put("comment-Email1", "Chaim_McDermott@dana.io");
			request.put("comment-Email2", "Chaim_McDermott.dana.comm");
			request.put("comment-Email3", "Chaim_McDermott...dana.io");
			request.put("comment-Email4", "Chaim_McDermottdana.io@");
			
			System.out.println(request.toJSONString());
			
			baseURI="https://jsonplaceholder.typicode.com/";
			
			given().
			body(request.toJSONString()).
			when().
			post("/users").
			then().
			statusCode(201).log().all();
			
			
			//For each post, fetching the comments and Email Validating
			Assert.assertTrue(isValid(response.jsonPath().getString("[8].email")));
		 
			    { 
			        String email1 = "Chaim_McDermott@dana.io"; 
			        String email2 = "Chaim_McDermott.dana.comm";
			        String email3 = "Chaim_McDermott...dana.io";
			        String email4 = "Chaim_McDermottdana.io@";
			        
			        String[] emails= {email1,email2,email3,email4};
			 
			        for (int i = 0; i < emails.length; i++) {
			            String email=emails[i];
			            if (isValid(email)) 
			                System.out.print(email+" is valid email"); 
			            else
			                System.out.print(email+" is invalid email"); 
			 
			            System.out.println();
			                  
			        }    
			        }

		
	}}
