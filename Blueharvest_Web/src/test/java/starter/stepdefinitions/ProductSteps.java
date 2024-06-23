package starter.stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import starter.pages.Product;
import starter.pages.SignIn;

public class ProductSteps extends PageObject {
    @Steps
    Product product;
    SignIn signIn;

    @Then("I go to the product page")
    public void goToProductPage() {
        product.clickProductPageButton();
        Assertions.assertTrue(product.validateOnProductPage());
        Assertions.assertTrue(product.validateTitleOnProductPage());
    }

    @Then("I see the list of products")
    public void seeListOfProducts() {
        Assertions.assertTrue(product.validateListProductDisplayed());
    }

    @When("I click add product button")
    public void clickAddProductButton() {
        product.clickAddProductButton();
    }

    @And("I input valid product title")
    public void inputValidTitleProduct() {
        product.inputProductTitle("Ikan Gurame");
    }

    @And("I input valid stock")
    public void inputValidStock() {
        product.inputProductStock(10);
    }

    @And("I input valid price")
    public void inputValidPrice() {
        product.inputProductPrice(40000);
    }

    @And("I input valid description")
    public void inputValidDescription() {
        product.inputProductDescription("Gurame segar yang dipelihara dengan baik, tersedia dalam berbagai ukuran dan siap untuk dikirim langsung ke rumah Anda. Ikan ini memiliki daging putih lembut dan kaya akan nutrisi, cocok untuk diolah menjadi berbagai hidangan lezat seperti bakar, goreng, atau soup.");
    }


    @And("I input valid image")
    public void inputValidImage() {
        product.inputProductImage("/Users/kayiin/Documents/A. Studi Independen/Quality-Engginer/Blueharvest_Web/src/test/resources/image/ikanGurame.jpg");
    }

    @And("I click save button")
    public void clickSaveButton() {
        product.clickSaveButton();
    }

    @Then("I redirected to product page")
    public void redirectedToProductPage() {
        Assertions.assertTrue(product.validateOnProductPage());
        Assertions.assertTrue(product.validateTitleOnProductPage());
    }

    @Then("I get error add product message {string}")
    public void getErrorAddProductMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @And("I input invalid price")
    public void inputInvalidPrice() {
        product.inputInvalidPrice(000);
    }

    @Then("I get error product price message {string}")
    public void getErrorProductPriceMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @And("I input invalid stock")
    public void inputInvalidStock() {
        product.inputInvalidStock(000);
    }

    @Then("I get error product stock message {string}")
    public void getErrorProductStockMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @And("I click edit product page button")
    public void clickEditProductPage() {
        product.clickEditProductButton();
    }
    @And("I edit product title")
    public void editProductTitle() {
        product.editProductTitle("Ikan Gurame");
    }

    @And("I edit product price")
    public void editProductPrice() {
        product.editProductPrice(40000);
    }

    @And("I edit product stock")
    public void editProductStock() {
        product.editProductStock(100);
    }

    @And("I edit product description")
    public void editProductDesc() {
        product.editProductDesc("Gurame segar yang dipelihara dengan baik, tersedia dalam berbagai ukuran dan siap untuk dikirim langsung ke rumah Anda.");
    }

    @And("I click save edit button")
    public void clickSaveEditButton() {
        product.clickSaveEditButton();
    }

    @And("I edit product with invalid price")
    public void editInvalidPrice() {
        product.editProductPrice(000);
    }

    @Then("I get error edit product price message {string}")
    public void getErrorEditProductPriceMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @And("I edit product with invalid stock")
    public void editInvalidStock() {
        product.editProductStock(000);
    }

    @Then("I get error edit product stock message {string}")
    public void getErrorEditProductStockMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @When("I click three dots button of a product")
    public void clickThreeDotsButtonOfProduct() {
        product.clickThreeDotsIcon();
    }

    @And("I click delete product button")
    public void clickDeleteProductButton() {
        product.clickDeleteProductButton();
    }

    @And("I click confirm delete button")
    public void clickConfirmDeleteButton() {
        product.clickConfirmDeleteButton();
    }

    @And("I click cancel add product button")
    public void clickCancelAddProductButton() { product.clickCancelButton(); }

    @And("I click view product button")
    public void clickViewProductButton() { product.clickViewButton(); }

    @Then("I redirected to detail product page")
    public void redirectedToDetailProductPage() {
        Assertions.assertTrue(product.validateOnEditProductPage());
        Assertions.assertTrue(product.validateTextInEditProductPage());
    }

    @And("I click cancel edit button")
    public void clickCancelEditButton() {product.clickCancelEditButton();}
}
