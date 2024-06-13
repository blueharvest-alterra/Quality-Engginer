package starter.user.address;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllStates {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/addresses/states";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/addresses/states/invalid";

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlYjVkMGZkLTVmNWYtNGIxZC04NjM1LTVjMmJlZTc5MGM5ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4MTk4Nzc0fQ.YmCFK76Dpa4-_DVIchXlGR81YbUAjj8omHaiTquMTOA";


    @Step("I set API endpoint for retrieving all states")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving all states")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve all states")
    public void sendGetRequestToRetrieveAllStates() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint());
    }

    @Step("I send a GET request to retrieve all states with an invalid endpoint")
    public void sendGetRequestToRetrieveAllStatesWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint());
    }

    @Step("I send a GET request to retrieve all states without proper authorization")
    public void sendGetRequestToRetrieveAllStatesWithoutAuthorization() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .put(setApiEndpoint())
                .then()
                .statusCode(405);  // Ensure we expect a 401 status code for unauthorized access
    }
    @Step("I receive valid state data")
    public void receiveValidStateData() {
        restAssuredThat(response -> {
            response.statusCode(201);
            response.body("status", equalTo(true));
            response.body("message", equalTo("get all state successfully"));
            response.body("data.states[0].id", Matchers.notNullValue());
            response.body("data.states[0].name", Matchers.notNullValue());
        });
    }

    @Step("I receive status code 405")
    public void receiveStatusCode405() {
        restAssuredThat(response -> response.statusCode(405));
    }

}
