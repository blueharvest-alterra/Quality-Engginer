package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import starter.pages.SignIn;

public class SignInSteps {
    private final SignIn signIn = new SignIn();

    @Given("I am on the sign in page")
    public void onTheSignInPage() {
        signIn.openUrl("https://sign-in-deploy.vercel.app/");
        Assertions.assertTrue(signIn.validateOnSignInPage());
    }

    @When("I input valid email")
    public void inputValidEmail() {
        signIn.inputEmail("irvan-surya-admin-2@blueharvest.com");
    }

    @And("I input valid password")
    public void inputValidPassword() {
        signIn.inputPassword("123hore");
    }

    @And("I click sign in button")
    public void clicksSignInButton() {
        signIn.clickSignInButton();
    }

    @Then("I get success sign in message {string}")
    public void getSuccessSignInMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @When("I input unregistered email")
    public void inputUnregisteredEmail() {
        signIn.inputEmail("irvan@blueharvest.com");
    }

    @Then("I get error sign in message {string}")
    public void getErrorSignInMessage(String message) {
        Assertions.assertTrue(signIn.validateMessageIsShown());
        Assertions.assertTrue(signIn.validateEqualMessage(message));
    }

    @And("I input invalid password")
    public void inputInvalidPassword(){
        signIn.inputPassword("123hor");
    }

    @When("I input invalid email form")
    public void inputInvalidEmail(){
        signIn.inputEmail("irvan-surya-admin-2blueharvest.com");
    }

    @Then("I get email error message {string}")
    public void getErrorMessageEmail(String message) {
        signIn.validateErrorMessage();
        signIn.validateEqualErrorMessage(message);
    }

    @Then("I get empty error message {string}")
    public void getErrorMessageEmpty(String message) {
        signIn.validateErrorMessage();
        signIn.validateEqualErrorMessage(message);
    }
}
