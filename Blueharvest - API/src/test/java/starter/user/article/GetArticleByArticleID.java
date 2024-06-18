package starter.user.article;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetArticleByArticleID {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";
    private static final String VALID_PRODUCT_ID = "503c5bdd-2ee6-4749-ab83-47ab27b745fc";
    private static final String INVALID_PRODUCT_ID = "000c0bdd-2ee6-0000-ab83-00ab00b745fc";

    @Step("I set API endpoint for retrieving an article by ID")
    public String setApiEndpoint(String productId) {
        return BASE_URL + productId;
    }

    @Step("I send a GET request to retrieve the article with valid article ID")
    public void sendGetRequestToRetrieveArticle() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a GET request to retrieve the article with invalid article ID")
    public void sendGetRequestToRetrieveArticleWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(INVALID_PRODUCT_ID))
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("I send a GET request to retrieve the article with invalid authorization token")
    public void sendGetRequestToRetrieveArticleWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer invalid_token_here")
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(403)
                .log().all();
    }

    @Step("I receive valid article retrieval data")
    public void receiveValidArticleRetrievalData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
    }
}
