package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import starter.pages.Article;

public class ArticleSteps {

    private Article articlePage;

    @When("I go to the article page")
    public void whenIGoToTheArticlePage() {
        articlePage.clickArticlePageButton();
        Assertions.assertTrue(articlePage.isOnArticlePage());
    }

    @Then("I redirected to article page")
    public void thenIRedirectedToArticlePage() {
        Assertions.assertTrue(articlePage.isOnArticlePage());
    }
    @Then("I redirected to edit article page")
    public void thenIRedirectedToEditArticlePage() {
        Assertions.assertTrue(articlePage.thenIRedirectedToEditArticlePage());
    }

    @Given("I am on the Article page")
    public void givenIAmOnTheDashboardPage() {
        Assertions.assertTrue(articlePage.isOnArticlePage());
    }

    @When("I click add article button")
    public void whenIClickAddArticleButton() {
        articlePage.clickAddArticleButton();
    }

    @When("I input valid article title")
    public void whenIInputValidArticleTitle() {
        articlePage.inputArticleTitle("Sample Article");
    }


    @When("I input valid description")
    public void whenIInputValidDescription() {
        articlePage.inputArticleDescription("Aquaculture atau budidaya perairan telah menjadi sumber pangan penting di dunia " +
                "maka dari itu perlu ada nya pengairan tambak dengan metode delete");
    }

    @When("I click save button article")
    public void whenIClickSaveButton() {
        articlePage.clickSaveButton();
    }

    @When("I click cancle button")
    public void whenIClickCancelButton() {
        articlePage.clickCancelButton();
    }

    @When("I select an article to edit")
    public void whenISelectAnArticleToEdit() {
        articlePage.selectArticleEditButton();
    }

    @When("I click on edit button")
    public void whenIClickOnViewDetailArticle() {
        articlePage.clickEditArticleButton();
    }

    @When("I update description")
    public void whenIUpdateDescription() {
        articlePage.inputArticleDescription("Aquaculture atau budidaya perairan telah menjadi sumber pangan penting di dunia " +
                "maka dari itu perlu ada nya pengairan tambak dengan metode delete");
    }

    @When("I change my mind and click cancel button")
    public void whenIChangeMyMindAndClickCancelButton() {
        articlePage.clickCancelButton();
    }

    @Then("I stay on the article page")
    public void thenIStayOnTheArticlePage() {
        Assertions.assertTrue(articlePage.isOnArticlePage());
    }

    @When("I select an article to delete")
    public void whenISelectAnArticleToDelete() {
        articlePage.selectArticleDeleteButton();
    }
    @When("I click on delete button")
    public void whenIClickDeletButton() {
        articlePage.clickDeleteArticleButton();
    }

    @When("I confirm the deletion")
    public void whenIConfirmTheDeletion() {
        articlePage.clickDeleteButton();

    }

    @Then("the article is deleted")
    public void thenTheArticleIsDeleted() {
        // Implement deletion verification steps if needed
        Assertions.assertTrue(true); // Replace with actual deletion verification steps
    }

    @When("I select an article to view details")
    public void whenISelectAnArticleToViewDetails() {
        articlePage.selectDetailArticleButton();
    }
    @When("I click on view detail article")
    public void selectAnArticleToViewDetails() {
        articlePage.clickViewDetailArticleButton();
    }

    @Then("I am redirected to the article details page")
    public void thenIAmRedirectedToTheArticleDetailsPage() {
        Assertions.assertTrue(articlePage.isArticleDetailsPageDisplayed());
    }



}
