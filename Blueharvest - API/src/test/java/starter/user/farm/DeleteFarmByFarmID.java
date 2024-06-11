package starter.user.farm;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteFarmByFarmID {
    private static String apiUrl = "https://blueharvest.irvansn.com/v1/farms/85d022e5-75db-4e70-a401-0d2177e392c0";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/invalid-farms";

    @Step("I set farm API endpoint for deleting farm by FarmID")
    public String setApiEndpoint() {
        return apiUrl;
    }

    @Step("I set an invalid farm API endpoint for deleting farm by FarmID")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send DELETE request to delete farm by FarmID")
    public void sendDeleteFarmRequest() {
        SerenityRest.delete(setApiEndpoint());
    }

    @Step("I send DELETE request to delete farm by invalid endpoint")
    public void sendDeleteFarmRequestWithInvalidEndpoint() {
        SerenityRest.delete(setWrongApiEndpoint());
    }

    @Step("I send DELETE request to delete farm without providing FarmID")
    public void sendDeleteFarmRequestWithMissingFarmID() {
        SerenityRest.delete(setWrongApiEndpoint())
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing FarmID
    }

    @Step("I receive confirmation of successful farm deletion")
    public void receiveConfirmationOfSuccessfulFarmDeletion() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo(" Success delete farm data!")));
    }
}
