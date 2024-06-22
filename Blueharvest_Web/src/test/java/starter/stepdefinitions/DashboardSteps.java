package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import starter.pages.Dashboard;

public class DashboardSteps {

    @Steps
    Dashboard dashboardPage;

    @Given("I am on the Dashboard page")
    public void givenIAmOnTheDashboardPage() {
        Assert.assertTrue(dashboardPage.validateOnDashboardPage());
    }

    @When("I click on Income Details button")
    public void whenIClickOnIncomeDetailsButton() {
        dashboardPage.clickIncomeDetailsButton();
    }

    @Then("I should be redirected to the Income Details page")
    public void thenIShouldBeRedirectedToTheIncomeDetailsPage() {
        Assert.assertTrue(dashboardPage.isOnIncomePage());
    }

    @When("I click on Product Total Details button")
    public void whenIClickOnProductTotalDetailsButton() {
        dashboardPage.clickProductTotalDetailsButton();
    }

    @Then("I should be redirected to the Product Total Details page")
    public void thenIShouldBeRedirectedToTheProductTotalDetailsPage() {
        Assert.assertTrue(dashboardPage.isOnProductTotalPage());
    }

    @When("I click on Farm Total Details button")
    public void whenIClickOnFarmTotalDetailsButton() {
        dashboardPage.clickFarmTotalDetailsButton();
    }

    @Then("I should be redirected to the Farm Total Details page")
    public void thenIShouldBeRedirectedToTheFarmTotalDetailsPage() {
        Assert.assertTrue(dashboardPage.isOnFarmTotalPage());
    }

    @When("I click on Latest Article Details button")
    public void whenIClickOnLatestArticleDetailsButton() {
        dashboardPage.clickLatestArticleDetailsButton();
    }

    @Then("I should be redirected to the Latest Article Details page")
    public void thenIShouldBeRedirectedToTheLatestArticleDetailsPage() {
        Assert.assertTrue(dashboardPage.isOnLatestArticlePage());
    }

    @When("I click on Latest Product Details button")
    public void whenIClickOnLatestProductDetailsButton() {
        dashboardPage.clickLatestProductDetailsButton();
    }

    @Then("I should be redirected to the Latest Product Details page")
    public void thenIShouldBeRedirectedToTheLatestProductDetailsPage() {
        Assert.assertTrue(dashboardPage.isOnLatestProductPage());
    }

    @Then("I should see the Blueharvest icon on the Dashboard page")
    public void thenIShouldSeeTheBlueharvestIconOnTheDashboardPage() {
        Assert.assertTrue(dashboardPage.validateOnDashboardPage());
    }


    @When("I search for product")
    public void whenISearchFor(String productName) {
        dashboardPage.searchProduct("Gurame");
    }

    @Then("I should see the product displayed in the search results")
    public void thenIShouldSeeTheProductDisplayedInTheSearchResults() {
        Assert.assertTrue(dashboardPage.isProductDisplayedInSearchResults());
    }

    @When("I click on Chat button")
    public void whenIClickOnChatButton() {
        dashboardPage.clickChatButton();
    }

    @Then("I should be redirected to the Chat page")
    public void thenIShouldBeRedirectedToTheChatPage() {
        Assert.assertTrue(dashboardPage.isOnChatPage());
    }

    @When("I click on Notification button")
    public void whenIClickOnNotificationButton() {
        dashboardPage.clickNotificationButton();
    }

    @Then("I should be redirected to the Notification page")
    public void thenIShouldBeRedirectedToTheNotificationPage() {
        Assert.assertTrue(dashboardPage.isOnNotificationPage());
    }

    @When("I click on Profile button")
    public void whenIClickOnProfileButton() {
        dashboardPage.clickProfileButton();
    }

    @Then("I should be redirected to the Profile page")
    public void thenIShouldBeRedirectedToTheProfilePage() {
        Assert.assertTrue(dashboardPage.isOnProfilePage());
    }

    // Negative scenario step definitions
    @When("I click on a non-existent Income Details button")
    public void whenIClickOnANonExistentIncomeDetailsButton() {
        dashboardPage.clickInvalidButton();
    }

    @Then("I should see an error message {string}")
    public void thenIShouldSeeAnErrorMessage(String expectedErrorMessage) {
        Assert.assertTrue(dashboardPage.isErrorDisplayedForInvalidButton());
    }

    // Additional negative scenario steps if needed...
}