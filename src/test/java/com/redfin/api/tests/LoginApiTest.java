package com.redfin.api.tests;

import com.google.gson.JsonObject;
import com.redfin.api.objects.User;
import com.redfin.utils.JsonUtils;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class LoginApiTest {


    @Test
    public void loginWithInvalidCredsTest() {
        User user = new User("test@test.com", "invalidpassword");
        String url = "https://www.redfin.com/stingray/do/api-login";

        String responseBody = given().
                contentType("application/json").
                body(user).when().
                post(url).then().extract().asString();

        String secondJsonObject = JsonUtils.extractSecondJsonObject(responseBody);
        JsonObject jsonObject = JsonUtils.parseJsonObject(secondJsonObject);

        int resultCode = jsonObject.get("resultCode").getAsInt();
        String errorMessage = jsonObject.get("errorMessage").getAsString();
        int version = jsonObject.get("version").getAsInt();

        assertEquals(100, resultCode);
        assertEquals("The argument 'email' is required.", errorMessage);
        assertEquals(491, version);

    }

    @Test
    public void getBlogsTest() {
        String url = "https://www.redfin.com/blog/";
        // HashMap<String, String> queryParams = new HashMap<>();
        given().queryParam("s", "sell home").when().get(url).then().log().body().
                assertThat().statusCode(200);

    }

    @Test
    public void getHomesForSaleByZipTest() {
        String url = "https://www.redfin.com/zipcode/92130";
        given().when().get(url).then().log().body();
    }
}
