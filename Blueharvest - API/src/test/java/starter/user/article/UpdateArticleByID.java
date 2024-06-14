package starter.user.article;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateArticleByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjoxNzE4Mzg5MzU0fQ.WfWfatVaBRamRXej-SDPuUYrrNQpdLv2AOVavg0Bz_o";
    private static final String ARTICLE_ID = "22049aee-34c0-4044-964f-a7aaac3cc5c1";
    private static final String INVALID_ID = "1c035a92-3c51-40e3-9463-4ba4e76a3b1b";

    @Step("I set API endpoint for updating an article by ID")
    public String setApiEndpoint() {
        return BASE_URL + ARTICLE_ID;
    }

    @Step("I set API endpoint for updating an article with invalid ID")
    public String setInvalidApiEndpoint() {
        return BASE_URL + INVALID_ID;
    }

    @Step("I send a PUT request to update the article with ID")
    public void sendPutRequestToUpdateArticle() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", "")
                .when()
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a PUT request to update the article with ID without required fields")
    public void sendPutRequestToUpdateArticleWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "")
                .multiPart("content", "")
                .multiPart("picture_file", "")
                .when()
                .put(setApiEndpoint())
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
                .multiPart("picture_file", "")
                .when()
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("The system should confirm the article update")
    public void systemShouldConfirmArticleUpdate() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Article updated successfully")));
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
