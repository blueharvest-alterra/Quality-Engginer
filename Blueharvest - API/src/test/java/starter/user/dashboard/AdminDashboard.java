package starter.user.dashboard;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AdminDashboard {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/dashboards/admin";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/dashboards/admin/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/dashboards/admin/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";


    @Step("I set API endpoint for retrieving admin dashboard")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving admin dashboard")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving admin dashboard")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve admin dashboard")
    public void sendGetRequestToRetrieveAdminDashboard() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve admin dashboard with invalid endpoint")
    public void sendGetRequestToRetrieveAdminDashboardWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve admin dashboard with invalid authorization token")
    public void sendGetRequestToRetrieveAdminDashboardWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid admin dashboard list data")
    public void receiveValidAdminDashboardListData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
    }



}
