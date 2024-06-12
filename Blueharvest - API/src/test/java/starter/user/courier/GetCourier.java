package starter.user.courier;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCourier {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/couriers";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/couriers/invalid";

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlYjVkMGZkLTVmNWYtNGIxZC04NjM1LTVjMmJlZTc5MGM5ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4MjI1MzI5fQ.Rwi8wlgSdHZlnQpYNUbG_5227gc_V02nYwiaIZLUEew";

    @Step("I set API endpoint for retrieving courier information")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving courier information")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a POST request to retrieve courier information")
    public void sendPostRequestToRetrieveCourierInformation() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body("{\"origin_city_id\": \"31\", \"destination_city_id\": \"255\", \"weight\": 1000}")
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to retrieve courier information with an invalid endpoint")
    public void sendPostRequestToRetrieveCourierInformationWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body("{\"origin_city_id\": \"31\", \"destination_city_id\": \"255\", \"weight\": 1000}")
                .post(setInvalidApiEndpoint());
    }

    @Step("I send a POST request to retrieve courier information without proper authorization")
    public void sendPostRequestToRetrieveCourierInformationWithoutAuthorization() {
        SerenityRest.given()
                .contentType("application/json")
                .body("{\"origin_city_id\": \"31\", \"destination_city_id\": \"255\", \"weight\": 1000}")
                .post(setApiEndpoint());
    }

    @Step("I receive valid courier information")
    public void receiveValidCourierInformation() {
        restAssuredThat(response -> {
            response.statusCode(200);
            response.body("status", equalTo(true));
            response.body("message", equalTo("get all courier successfully"));
            response.body("data.couriers[0].name", Matchers.notNullValue());
            response.body("data.couriers[0].fee", Matchers.notNullValue());
            response.body("data.couriers[0].type", Matchers.notNullValue());
        });
    }

    @Step("I receive status code 401 for unauthorized access")
    public void receiveStatusCode401ForUnauthorizedAccess() {
        restAssuredThat(response -> response.statusCode(401));
        restAssuredThat(response -> response.body("message", equalTo("Unauthorized access")));
    }

    @Step("I receive status code 403")
    public void receiveStatusCode403() {
        restAssuredThat(response -> response.statusCode(403));
    }

}