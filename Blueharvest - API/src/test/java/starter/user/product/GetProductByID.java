package starter.user.product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";
    private static final String VALID_PRODUCT_ID = "60dc3770-478c-4e49-aa5e-b9c0ff2c001f";
    private static final String INVALID_PRODUCT_ID = "aa0af000-40e9-4ed2-b00d-054180b00000";

    @Step("I set API endpoint for retrieving a product")
    public String setApiEndpoint(String productId) {
        return BASE_URL + productId;
    }

    @Step("I send a GET request to retrieve the product")
    public void sendGetRequestToRetrieveProduct() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(201)
                .log().all();
    }

    @Step("I send a GET request to retrieve the product with invalid product ID")
    public void sendGetRequestToRetrieveProductWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(INVALID_PRODUCT_ID))
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("I send a GET request to retrieve the product with invalid authorization token")
    public void sendGetRequestToRetrieveProductWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer invalid_token_here")
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(403)
                .log().all();
    }

    @Step("I receive valid product retrieval data")
    public void receiveValidProductRetrievalData() {
        restAssuredThat(response -> response.statusCode(201));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
    }
}
