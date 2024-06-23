package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import starter.pages.Transaction;

public class TransactionSteps extends PageObject {
    @Steps
    Transaction transaction;

    @Then("I go to transaction page")
    public void goToTransactionPage() {
        transaction.goToTransactionPage();
        Assertions.assertTrue(transaction.validateOnTransactionPage());
    }

    @Then("I can see the list of all transactions")
    public void seeAllTransactions() {
        Assertions.assertTrue(transaction.validateSampleTransaction());
        Assertions.assertTrue(transaction.validateFirstSampleName("William Hernandez"));
    }

    @When("I click next button")
    public void clickNextButton() {
        transaction.clickNextButton();
    }

    @Then("I see the next page of list transactions")
    public void seeTheNextPageListTransactions() {
        Assertions.assertTrue(transaction.validateSampleTransaction());
        Assertions.assertTrue(transaction.validateSampleTransactionName("Daniel Martinez"));
    }
}
