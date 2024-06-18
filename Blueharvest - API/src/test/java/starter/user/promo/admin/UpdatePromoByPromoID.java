package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePromoByPromoID {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/promos/ebf588aa-6e35-472f-a982-ddcdb014fc1f";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/promos/invalid";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";

    @Step("I set API endpoint for editing a promo by PromoID")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid API endpoint for editing a promo by PromoID")
    public String setInvalidApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send a PUT request to edit the promo with valid data")
    public void sendPutRequestWithValidData() {
        // Create JSON part
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this is test name");
        requestBody.put("code", "this is test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 150000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .put(setApiEndpoint());
    }

    @Step("I send a PUT request to edit the promo with missing promo id")
    public void sendPutRequestWithMissingPromoID() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this is test name");
        requestBody.put("code", "this is test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 150000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .put("https://blueharvest.irvansn.com/v1/promos/");
    }

    @Step("I send a PUT request to edit the promo with valid data but invalid PromoID")
    public void sendPutRequestWithInvalidPromoID() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this is test name");
        requestBody.put("code", "this is test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 150000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .put(setInvalidApiEndpoint());
    }


    @Step("the promo is successfully updated")
    public void receivePromoIsSuccessfullyUpdated() {
        //JsonSchemaHelper helper = new JsonSchemaHelper();
        //String schema = helper.getResponseSchema(JsonSchema.EDIT_PROMO_BY_PROMO_ID);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Promo updated!")));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.code", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.amount", Matchers.notNullValue()));

       // restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
