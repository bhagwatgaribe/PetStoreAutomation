package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class DDTests {
	
	@Test(priority = 1, dataProvider = "AllUserData", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName,String fName,String lName,
			String useremail,String pwd,String phone) {
			
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
			
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
		
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response response = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}