package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	public static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String createUser_url = getURL().getString("createUser_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(createUser_url);
		return response;		
	}
	
	public static Response getUser(String userName) {
		
		String getUser_url = getURL().getString("getUser_url");
		Response response = given()
				.pathParam("username", userName)
			.when()
				.get(getUser_url);
		return response;		
	}
	
	public static Response updateUser(String userName, User payload) {
		
		String updateUser_url = getURL().getString("updateUser_url");
		Response response = given()
				.contentType(ContentType.JSON)
			 	.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
				.put(updateUser_url);
		return response;		
	}
	
	public static Response deleteUser(String userName) {
		
		String deleteUser_url = getURL().getString("deleteUser_url");
		Response response = given()
				.pathParam("username", userName)
			.when()
				.delete(deleteUser_url);
		return response;		
	}
}
