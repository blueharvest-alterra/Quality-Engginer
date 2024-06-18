package starter.user.product;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllProduct {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products";
    private static final String BASE_InvalidURL = "https://blueharvest.irvansn.com/v1/products/invalid";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";
    private static final String INVALID_TOKEN = "invalid_token_here";

    @Step("I set API endpoint for retrieving all products")
    public String setApiEndpoint() {
        return BASE_URL;
    }
    @Step("I set invalid API endpoint for retrieving all products")
    public String setInvalidApiEndpoint() {
        return BASE_InvalidURL;
    }

    @Step("I send a GET request to retrieve all products")
    public void sendGetRequestToRetrieveAllProducts() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }
    @Step("I send a GET request to retrieve all products with invalid endpoint")
    public void sendGetRequestToRetrieveAllProductsWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all products with invalid authorization token")
    public void sendGetRequestToRetrieveAllProductsWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + INVALID_TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I receive valid product list data")
    public void receiveValidProductListData() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }


    @Step("I receive an empty product list")
    public void receiveEmptyProductList() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", hasSize(0)));
    }
}
