package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {

	public static RequestSpecification requestSpecification() throws IOException
	{
		PrintStream print = new PrintStream(new File("./src/test/resources/logging.txt"));
		RequestSpecification reqspec=  new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(getProperty("baseURI")).
		addFilter(RequestLoggingFilter.logRequestTo(print)).addFilter(ResponseLoggingFilter.logResponseTo(print)).build();
		
		return reqspec;
	}
	
	public static ResponseSpecification responseSpecification()
	{
		ResponseSpecification resspec=  new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return resspec;
	}
	
	public static String authorizationServerEndpoint() throws IOException
	{
		
		
		String endpoint = "https://accounts.spotify.com/authorize?client_id="
		+getProperty("client_id")+"&response_type=code&redirect_uri=https://oauth.pstmn.io/v1/callback&"+
				"scope=user-read-private user-read-email playlist-modify-public user-read-playback-state "+
		"user-modify-playback-state user-read-playback-position user-library-read user-follow-read";
		
		return endpoint;
	}
	
	
	public static String getProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("./src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public static String getValueFromJson(String response, String key)
	{
		JsonPath json = new JsonPath(response);
		return json.get(key);
	}
}
