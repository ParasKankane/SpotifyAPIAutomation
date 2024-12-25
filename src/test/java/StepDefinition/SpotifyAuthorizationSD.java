package StepDefinition;

import static io.restassured.RestAssured.given;
import StepDefinition.Hooks;

import java.io.IOException;

import org.hamcrest.Matchers;

import Utility.BaseClass;
import Utility.ResourceManagement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Payload.SpotifyPayload;


public class SpotifyAuthorizationSD extends BaseClass{

	RequestSpecification reqspec;
	Response response;
	
	@Given("create Playlist Payload with {string} and {string}")
	public void create_playlist_payload_with_and(String name, String description) throws IOException {
	   
		reqspec= given().log().all().spec(requestSpecification()).pathParam("user_id", "er5hpl5oppjvo9mhpqs3vmn6y")
				.body(SpotifyPayload.createPlaylist(name, description)).header("Authorization","Bearer "+Hooks.access_token);
		
	}

	@When("user call the {string} api")
	public void user_call_the_api(String apiName) {
		response = reqspec.when().post(ResourceManagement.valueOf(apiName).getResource());
		
	}
	
	@Then("api call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer statusCode) {
		System.out.println("Status Code: "+statusCode);
		response.then().log().all().spec(responseSpecification()).assertThat().statusCode(statusCode);
		
	}
	
	@And("name is equals to {string}")
	public void name_is_equals_to(String name) {
	    
		response.then().assertThat().body("name", Matchers.equalTo(name));
		
	}

	@And("description is equals to {string}")
	public void description_is_equals_to(String description) {
	  response.then().assertThat().body("description", Matchers.equalTo(description));
		
	}

}
