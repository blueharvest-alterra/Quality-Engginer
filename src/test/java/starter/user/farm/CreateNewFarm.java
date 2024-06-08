package starter.user.farm;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewFarm {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/farms";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/invalid-farms";

    @Step("I set API endpoint for creating a new farm")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for creating a new farm")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send a POST request with valid data to create a new farm")
    public void sendCreateFarmRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "this test title");
        requestBody.put("description", "this test description");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request with missing required fields to create a new farm")
    public void sendCreateFarmRequestWithMissingRequiredFields() {
        SerenityRest.given()
                .contentType("application/json")
                .post(setApiEndpoint())
                .then()
                .statusCode(400);  // Ensure we expect a 400 status code
    }

    @Step("I send a POST request with valid data to create a new farm on invalid endpoint")
    public void sendCreateFarmRequestWithValidDataOnInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "this test title");
        requestBody.put("description", "this test description");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpoint())
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for invalid endpoint
    }

    @Step("I receive valid farm creation data")
    public void receiveValidFarmCreationData() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Farm created!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));;  // Update with correct matchers as necessary
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", equalTo("Missing required fields")));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveErrorMessageAboutInvalidEndpoint() {
        restAssuredThat(response -> response.statusCode(404));  // Ensure we get a 404 Not Found
    }
}
