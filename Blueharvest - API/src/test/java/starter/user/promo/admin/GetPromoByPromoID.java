package starter.user.promo.admin;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPromoByPromoID {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/promos";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/promos/invalid";

    @Step("I set API endpoint for retrieving a promo by PromoID")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving a promo by PromoID")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve the promo with a valid PromoID")
    public void sendGetRequestWithValidPromoID() {
        SerenityRest.given()
                .get(setApiEndpoint() + "/73b99be4-b751-4950-8ca9-477e9a3c005a");
    }

    @Step("I send a GET request to retrieve the promo with a wrong PromoID")
    public void sendGetRequestWithWrongPromoID() {
        SerenityRest.given()
                .get(setApiEndpoint() + "/b4dgbsu-79e0-4144-ac49-073744a48b42");
    }

    @Step("I send a GET request to retrieve the promo with a valid PromoID to an invalid endpoint")
    public void sendGetRequestToInvalidEndpoint() {
        SerenityRest.given()
                .get(setInvalidApiEndpoint());
    }


    @Step("I receive valid promo data")
    public void receiveValidPromoData() {
        // JsonSchemaHelper helper = new JsonSchemaHelper();
        //String schema = helper.getResponseSchema(JsonSchema.GET_PROMO_BY_ID);

        restAssuredThat(response -> response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", equalTo("Success get promo data!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.code", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.amount", Matchers.notNullValue()));

        // restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive an error message about promo not found")
    public void receiveErrorMessagePromoNotFound() {
        restAssuredThat(response -> response.body("message", equalTo("Promo not found")));
    }

}
