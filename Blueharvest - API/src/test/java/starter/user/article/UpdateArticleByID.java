package starter.user.article;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateArticleByID {

    private static final String BASE_URL = "https://example.com/api/v1/articles/";
    private static final String TOKEN = "75569766-7c97-421a-95ce-306edd56aebd";
    private static final String ARTICLE_ID = "75569766-7c97-421a-95ce-306edd56aebd";
    private static final String INVALID_ID = "01928374-7c97-421a-95ce-306edd56aebd";

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
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", "")
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a PUT request to update the article with ID without required fields")
    public void sendPutRequestToUpdateArticleWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "")
                .multiPart("content", "")
                .multiPart("picture_file", "")
                .put(setApiEndpoint())
                .then()
                .statusCode(400)
                .log().all();
    }

    @Step("I send a PUT request to update an article with invalid ID")
    public void sendPutRequestToUpdateArticleWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", "")
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
