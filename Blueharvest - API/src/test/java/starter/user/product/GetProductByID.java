package starter.user.product;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4Mzg5MzU0fQ.WfWfatVaBRamRXej-SDPuUYrrNQpdLv2AOVavg0Bz_o";
    private static final String VALID_PRODUCT_ID = "ff2e0075-28ee-4538-90e9-ef3270c1727f";
    private static final String INVALID_PRODUCT_ID = "gg3g0075-28ee-4538-90e9-ef3270c1727f";

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
