package starter.user.farm;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetFarmByFarmID {
    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/farms";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/farms/invalid";

    @Step("I set farm API endpoint for get farm by FarmID")
    public String setFarmApiEndpointForFarmByID() {
        return VALID_URL;
    }

    @Step("I set invalid farm API endpoint for get farm by FarmID")
    public String setInvalidFarmApiEndpointForFarmByID() {
        return INVALID_URL;
    }

    @Step("I send GET request to get farm by FarmID")
    public void sendGetRequestToGetFarmByID() {
        SerenityRest.given().get(setFarmApiEndpointForFarmByID() + "/f1d55285-f1b3-42cd-aa15-5456ba6b9a6f");
    }

    @Step("I send GET request to get farm by missing FarmID")
    public void sendGetRequestToGetFarmByMissingID() {
        SerenityRest.given().get(setFarmApiEndpointForFarmByID() + "/");
    }

    @Step("I send GET request to get farm by invalid FarmID")
    public void sendGetRequestToGetFarmByInvalidID() {
        SerenityRest.given().get(setFarmApiEndpointForFarmByID() + "/eee45954-9662-4d6b-a8cb-8a2a83de4ab00");
    }


    @Step("I receive detail farm with FarmID")
    public void receiveDetailFarmWithID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_FARM_BY_ID);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get farm data!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.title", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.picture", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
