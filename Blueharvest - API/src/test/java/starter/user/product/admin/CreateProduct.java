package starter.user.product.admin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProduct {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ2NzM1MDk2fQ.izQFa8-entjBY18hQeRnS0Y4pYttxRddBhdlax4Z1M0";

    @Step("I set API endpoint for creating a new product")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send a POST request to create a new product")
    public void sendPostRequestToCreateProduct() {
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("name", "Ikan Patin Segar (bukan frozen) 500 gr/1 kg Free Dibersihkan")
                .multiPart("description", "PREMIUM LOKAL PRODUCT Harap !!! OPEN 06:00 WIB S/D 16.00 WIB [SILAHKAN PILIH UKURAN IKAN SESUAI VARIANT, JIKA INGIN UKURAN TERTENTU SILAHKAN CHAT SELLER TERLEBIH DAHULU UNTUK KETERSEDIAANNYA]")
                .multiPart("price", 40000)
                .multiPart("status", "available")
                .multiPart("thumbnail", sampleFile)
                .post(setApiEndpoint())
                .then()
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a POST request to create a new product without required fields")
    public void sendPostRequestToCreateProductWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("name", "")
                .multiPart("description", "")
                .multiPart("price", "")
                .multiPart("status", "")
                .multiPart("thumbnail", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .post(setApiEndpoint())
                .then()
                .statusCode(400)  // Expecting 400 Bad Request
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a POST request to create a new product with invalid authorization token")
    public void sendPostRequestToCreateProductWithInvalidToken() {
        // Load sample file (adjust path as needed)
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + "invalid_token_here")
                .multiPart("name", "Ikan Patin Segar (bukan frozen) 500 gr/1 kg Free Dibersihkan")
                .multiPart("description", "PREMIUM LOKAL PRODUCT Harap !!! OPEN 06:00 WIB S/D 16.00 WIB [SILAHKAN PILIH UKURAN IKAN SESUAI VARIANT, JIKA INGIN UKURAN TERTENTU SILAHKAN CHAT SELLER TERLEBIH DAHULU UNTUK KETERSEDIAANNYA]")
                .multiPart("price", 40000)
                .multiPart("status", "available")
                .multiPart("thumbnail", sampleFile)
                .post(setApiEndpoint())
                .then()
                .statusCode(403);
    }

    @Step("I receive valid product creation data")
    public void receiveValidProductCreationData() {
        restAssuredThat(response -> response.statusCode(201));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("product created")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
    }

    @Step("I receive status code 403")
    public void receiveStatusCode403() {
        restAssuredThat(response -> response.statusCode(403));
    }

    @Step("I receive an error message about unauthorized access")
    public void receiveErrorMessageAboutUnauthorizedAccess() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }
}
