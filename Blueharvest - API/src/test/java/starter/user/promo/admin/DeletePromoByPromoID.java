package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeletePromoByPromoID {
    private static String apiUrl = "https://blueharvest.irvansn.com/v1/promos/ac2125c1-dd84-4c02-85fa-df0212f578a9";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/invalid-promos";

    @Step("I set promo API endpoint for deleting promo by PromoID")
    public String setApiEndpoint() {
        return apiUrl;
    }

    @Step("I set an invalid promo API endpoint for deleting promo by PromoID")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send DELETE request to delete promo by PromoID")
    public void sendDeletePromoRequest() {
        SerenityRest.delete(setApiEndpoint());
    }

    @Step("I send DELETE request to delete promo by invalid endpoint")
    public void sendDeletePromoRequestWithInvalidEndpoint() {
        SerenityRest.delete(setWrongApiEndpoint());
    }

    @Step("I send DELETE request to delete promo without providing PromoID")
    public void sendDeletePromoRequestWithMissingPromoID() {
        SerenityRest.delete("https://blueharvest.irvansn.com/v1/promos/")
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing PromoID
    }

    @Step("I receive confirmation of successful promo deletion")
    public void receiveConfirmationOfSuccessfulPromoDeletion() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success delete promo data!")));
    }
}
