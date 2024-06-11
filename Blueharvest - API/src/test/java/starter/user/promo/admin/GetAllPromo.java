package starter.user.promo.admin;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllPromo {
    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/promos";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/invalid_promos";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/unauthorized";

    @Step("I set API endpoint for retrieving all promos")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving all promos")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve all promos with valid data")
    public void sendGetRequestToRetrieveAllPromosWithValidData() {
        SerenityRest.given()
                .get(setApiEndpoint());
    }

    @Step("I send a GET request to retrieve all promos to an invalid endpoint")
    public void sendGetRequestToInvalidEndpoint() {
        SerenityRest.given()
                .get(setInvalidApiEndpoint());
    }

    @Step("I send a GET request to retrieve all promos during a server error")
    public void sendGetRequestDuringServerError() {
        SerenityRest.given().get(UNAUTHORIZED_URL);

    }

    @Step("I receive a list of all promos")
    public void receiveListOfAllPromos() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }


    @Step("I receive an error message about the endpoint not being found")
    public void receiveErrorMessageEndpointNotFound() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
    }

    @Step("I receive status code 500")
    public void receiveStatusCode500() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive an error message about a server issue")
    public void receiveErrorMessageServerIssue() {
        restAssuredThat(response -> response.body("message", equalTo("Internal Server Error")));
    }
}
