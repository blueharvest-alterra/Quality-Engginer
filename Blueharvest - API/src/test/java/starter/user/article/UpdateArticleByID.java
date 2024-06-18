package starter.user.article;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateArticleByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String INV_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";
    private static final String ARTICLE_ID = "82971c5c-860d-4542-8b10-d669beeb1757";
    private static final String INVALID_ID = "00000c5c-860d-4542-8b10-d669beeb0000";

    @Step("I set API endpoint for updating an article by ID")
    public String setApiEndpoint() {
        return BASE_URL + ARTICLE_ID;
    }

    @Step("I set API endpoint for updating an article with invalid ID")
    public String setInvalidApiEndpoint() {
        return INV_URL + INVALID_ID;
    }


    @Step("I send a PUT request to update the article with ID")
    public void sendPutRequestToUpdateArticle() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .when()
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a PUT request to update the article with invalid endpoint")
    public void sendPutRequestToUpdateArticleWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "")
                .multiPart("content", "")
                .when()
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(400)
                .log().all();
    }

    @Step("I send a PUT request to update an article with invalid ID")
    public void sendPutRequestToUpdateArticleWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .when()
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("The system should confirm the article update")
    public void systemShouldConfirmArticleUpdate() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("article updated!")));
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Missing required fields")));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveErrorMessageAboutInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Invalid endpoint")));
    }
}
