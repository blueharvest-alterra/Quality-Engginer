package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeletePromoByPromoID {
    private static String apiUrl = "https://blueharvest.irvansn.com/v1/promos/ac2125c1-dd84-4c02-85fa-df0212f578a9";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/ebf588aa-6e35-472f-a982-ddcdb014fc1g";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";

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

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setApiEndpoint());
    }

    @Step("I send DELETE request to delete promo by invalid endpoint")
    public void sendDeletePromoRequestWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setWrongApiEndpoint());
    }

    @Step("I send DELETE request to delete promo without providing PromoID")
    public void sendDeletePromoRequestWithMissingPromoID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete("https://blueharvest.irvansn.com/v1/promos/")
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing PromoID
    }

    @Step("I receive confirmation of successful promo deletion")
    public void receiveConfirmationOfSuccessfulPromoDeletion() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success delete promo data!")));
    }
}
