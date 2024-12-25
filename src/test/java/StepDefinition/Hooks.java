package StepDefinition;

import static Utility.BaseClass.authorizationServerEndpoint;
import static Utility.BaseClass.getProperty;
import static Utility.BaseClass.getValueFromJson;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

import org.junit.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Hooks {
	
	
	static String authorization_code;
	static String client_credentials;
	static String access_token;

	@Before
	public void access_token() throws IOException
	{
		
		System.out.println("Please hit this URL in your browser: " +authorizationServerEndpoint());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the authorization_code: ");
		authorization_code=  sc.nextLine();
		
		client_credentials = getProperty("client_id")+":"+getProperty("client_secret");
		
		Response response = given().baseUri("https://accounts.spotify.com/").log().all().
									formParam("grant_type", "authorization_code").formParam("code", authorization_code).
									formParam("redirect_uri", getProperty("redirect_uri")).
									contentType(ContentType.URLENC).
									header("Authorization","Basic "+Base64.getEncoder().encodeToString(client_credentials.getBytes())).
							when().post("api/token").
							then().log().all().extract().response();
		
		Assert.assertEquals(200, response.getStatusCode());
		
		access_token = getValueFromJson(response.asString(), "access_token");
	}
	
}
