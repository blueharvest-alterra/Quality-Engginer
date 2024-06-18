package starter.user.product.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteProductByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";
    private static final String VALID_PRODUCT_ID = "f479748c-c31a-4817-b7c6-ae99b40ea5b6";
    private static final String INVALID_PRODUCT_ID = "0000f000-fb00-00cc-b000-a1a8f6bde333";

    @Step("I set API endpoint for deleting a product")
    public String setApiEndpoint(String productId) {
        return BASE_URL + productId;
    }

    @Step("I send a DELETE request to delete the product")
    public void sendDeleteRequestToDeleteProduct() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(200)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a DELETE request to delete the product with invalid product ID")
    public void sendDeleteRequestToDeleteProductWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setApiEndpoint(INVALID_PRODUCT_ID))
                .then()
                .statusCode(404)  // Expecting 404 Not Found
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a DELETE request to delete the product with invalid authorization token")
    public void sendDeleteRequestToDeleteProductWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer invalid_token_here")
                .delete(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(403)  // Expecting 401 Unauthorized
                .log().all(); // Log all details of the request and response
    }

    @Step("I receive valid product deletion data")
    public void receiveValidProductDeletionData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("product deleted")));
    }


}
