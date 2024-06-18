package starter.user.farm;

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

public class EditFarmByFarmID {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/farms/f1d55285-f1b3-42cd-aa15-5456ba6b9a6f";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/invalid-farms";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";

    @Step("I set farm API endpoint for editing farm by FarmID")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid farm API endpoint for editing farm by FarmID")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send PUT request to edit farm by FarmID with valid authorization and data")
    public void sendEditFarmRequestWithValidData() {
        // Create JSON part
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "this is update test title");
        requestBody.put("description", "this is update test description");

        // Load sample file
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        // Send PUT request with multipart form data
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN).multiPart("title", "this is update test title")
                .multiPart("description", "this is update test description")
                .multiPart("picture_file", sampleFile)
                .put(setApiEndpoint());
    }

    @Step("I send PUT request to edit farm without providing FarmID")
    public void sendEditFarmRequestWithMissingFarmID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .put(setWrongApiEndpoint())
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing FarmID
    }

    @Step("I send PUT request to edit farm with valid authorization and data to invalid endpoint")
    public void sendEditFarmRequestWithValidDataOnInvalidEndpoint() {
        // Create JSON part
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "this is update test title");
        requestBody.put("description", "this is update test description");

        // Load sample file
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        // Send PUT request with multipart form data to invalid endpoint
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "this is update test title")
                .multiPart("description", "this is update test description")
                .multiPart("picture_file", sampleFile)
                .put(setWrongApiEndpoint())
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for invalid endpoint
    }

    @Step("the system should confirm successful farm edit")
    public void confirmSuccessfulFarmEdit() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.EDIT_FARM_BY_FARM_ID);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Farm updated!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.title", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.picture", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
