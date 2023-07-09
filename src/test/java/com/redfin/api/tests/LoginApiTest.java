package com.redfin.api.tests;

import com.google.gson.Gson;
import com.redfin.api.objects.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest {
    @Test
    public void loginWithInvalidCredsTest() {
        User user = new User();
        user.email = "test@test.com";
        user.password = "invalidpassword";
        String jsonBody = new Gson().toJson(user);
        String url = "https://www.redfin.com/stingray/do/api-login";

        given().when().body(jsonBody).post(url).then().log().body();

    }
}
