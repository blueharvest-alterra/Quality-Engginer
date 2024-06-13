package starter.user.product.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteProductByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4Mzg5MzU0fQ.WfWfatVaBRamRXej-SDPuUYrrNQpdLv2AOVavg0Bz_o";
    private static final String VALID_PRODUCT_ID = "d86eebc3-b5ce-4aa6-9637-98bc4854d213";
    private static final String INVALID_PRODUCT_ID = "df83js00-b5ce-4aa6-9537-98bc4854d211";

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
