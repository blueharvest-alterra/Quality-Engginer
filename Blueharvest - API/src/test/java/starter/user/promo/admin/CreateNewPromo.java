package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewPromo {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/promos";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/promos/invalid";

    @Step("I set API endpoint for creating a new promo")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid API endpoint for creating a new promo")
    public String setInvalidApiEndpointForCreatePromo() {
        return wrongUrl;
    }

    @Step("I send a POST request promo with valid data")
    public void sendCreatePromoRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this test name");
        requestBody.put("code", "this test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 35000);

        SerenityRest.given()
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlYjVkMGZkLTVmNWYtNGIxZC04NjM1LTVjMmJlZTc5MGM5ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4MTc3NjYwfQ.Le6i1sMV8hEuCc7DgJOI_k6tZ0G4Y7AV2sL91ex78gE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request promo with missing required fields")
    public void sendCreatePromoRequestWithMissingRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("code", "");
        requestBody.put("status", "");
        requestBody.put("amount", "" );

        SerenityRest.given()
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlYjVkMGZkLTVmNWYtNGIxZC04NjM1LTVjMmJlZTc5MGM5ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4MTc3NjYwfQ.Le6i1sMV8hEuCc7DgJOI_k6tZ0G4Y7AV2sL91ex78gE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request promo with valid data to invalid endpoint")
    public void sendCreatePromoRequestToInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this test name");
        requestBody.put("code", "this test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 35000);

        SerenityRest.given()
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlYjVkMGZkLTVmNWYtNGIxZC04NjM1LTVjMmJlZTc5MGM5ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4MTc3NjYwfQ.Le6i1sMV8hEuCc7DgJOI_k6tZ0G4Y7AV2sL91ex78gE")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setInvalidApiEndpointForCreatePromo());
    }

    @Step("I receive valid promo creation data")
    public void receiveValidPromoCreationData() {
        restAssuredThat(response -> response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", equalTo("Promo created!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.code", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.amount", Matchers.notNullValue()));
    }

    @Step("I receive status code 400 for unauthorized access")
    public void receiveStatusCode401ForUnauthorizedAccess() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive an error promo message about unauthorized access")
    public void receiveErrorPromoMessageUnauthorizedAccess() {
        restAssuredThat(response -> response.body("message", equalTo("Unauthorized")));
    }

    @Step("I receive status code 404 for invalid endpoint")
    public void receiveStatusCode404ForInvalidEndpoint() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive an error promo message about invalid endpoint")
    public void receiveErrorPromoMessageInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", equalTo("Method Not Allowed")));
    }
}
