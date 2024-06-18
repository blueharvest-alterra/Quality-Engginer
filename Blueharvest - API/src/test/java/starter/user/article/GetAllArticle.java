package starter.user.article;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllArticle {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/articles/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/articles/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";


    @Step("I set API endpoint for retrieving all articles")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving all articles")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving all articles")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve all articles")
    public void sendGetRequestToRetrieveAllArticles() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all articles with invalid endpoint")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all articles with invalid authorization token")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid article list data")
    public void receiveValidArticleListData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }

    @Step("I receive an error message about unauthorized access")
    public void receiveUnauthorizedAccessErrorMessage() {
        restAssuredThat(response -> response.statusCode(403));
        restAssuredThat(response -> response.body("error", equalTo("Unauthorized access")));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveInvalidEndpointErrorMessage() {
        restAssuredThat(response -> response.statusCode(404));
        restAssuredThat(response -> response.body("error", equalTo("Invalid endpoint")));
    }
}
