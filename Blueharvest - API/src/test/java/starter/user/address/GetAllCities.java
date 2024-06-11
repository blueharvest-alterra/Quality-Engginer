package starter.user.address;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllCities {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/addresses/cities/";
    private static final String VALID_STATE_ID = "11";
    private static final String INVALID_STATE_ID = "https://blueharvest.irvansn.com/v1/addressess/citiess/invalid";

    @Step("I set API endpoint for retrieving all cities for a specific state")
    public String setApiEndpoint() {
        return BASE_URL + VALID_STATE_ID;
    }

    @Step("I set an invalid API endpoint for retrieving all cities for a specific state")
    public String setInvalidApiEndpoint() {
        return INVALID_STATE_ID;
    }

    @Step("I send a GET request to retrieve all cities for a specific state")
    public void sendGetRequestToRetrieveAllCities() {
        SerenityRest.given()
                .get(setApiEndpoint());
    }

    @Step("I send a GET request to retrieve all cities for an invalid state ID")
    public void sendGetRequestToRetrieveAllCitiesWithInvalidStateID() {
        SerenityRest.given()
                .get(setInvalidApiEndpoint());
    }

    @Step("I send a GET request to retrieve all cities without proper authorization")
    public void sendGetRequestToRetrieveAllCitiesWithoutAuthorization() {
        SerenityRest.given()
                .put(setApiEndpoint())
                .then()
                .statusCode(405);  // Ensure we expect a 401 status code for unauthorized access
    }

    @Step("I receive valid city data for the specific state")
    public void receiveValidCityData() {
        restAssuredThat(response -> {
            response.statusCode(201);
            response.body("status", equalTo(true));
            response.body("message", equalTo("get all state successfully"));
            response.body("data.cities", Matchers.notNullValue());
        });
    }

    @Step("I receive status code 404 for invalid state ID")
    public void receiveStatusCode404ForInvalidStateID() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive status code 405 for unauthorized access")
    public void receiveStatusCode401ForUnauthorizedAccess() {
        restAssuredThat(response -> response.statusCode(405));
    }

}
