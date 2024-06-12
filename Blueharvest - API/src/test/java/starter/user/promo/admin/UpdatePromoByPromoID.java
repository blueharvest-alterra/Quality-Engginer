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
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/promos/73b99be4-b751-4950-8ca9-477e9a3c005a";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/promos/invalid";

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
