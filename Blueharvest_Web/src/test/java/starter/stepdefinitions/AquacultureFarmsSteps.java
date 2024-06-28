package starter.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import starter.pages.AquacultureFarms;

public class AquacultureFarmsSteps {

    private AquacultureFarms aquacultureFarms;


    @When("I go to the farms page")
    public void iGoToTheFarmsPage() {
        aquacultureFarms.clickFarmsPageButton();
    }

    @Then("I am redirected to the farms page")
    public void iAmRedirectedToTheFarmsPage() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @Given("I am on the farms page")
    public void iAmOnTheFarmsPage() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I click add farm button")
    public void iClickAddFarmButton() {
        aquacultureFarms.clickAddFarmButton();
    }

    @When("I input valid farm title")
    public void iInputValidFarmTitle() {
        aquacultureFarms.inputFarmTitle("Farm Title");
    }

    @When("I input valid farm starting price")
    public void priceEarlyField() {
        aquacultureFarms.priceEarlyField("15.000");
    }

    @When("I input valid farm count investment")
    public void countInvestment() {
        aquacultureFarms.countInvestment("13.000");
    }

    @When("I input valid image for the farm")
    public void iInputValidImageForTheFarm() {
        aquacultureFarms.inputFarmImage("F:\\Alterra\\Capstone\\API\\Blueharvest-API\\Blueharvest_Web\\src\\test\\resources\\image\\ikanGurame.jpg");
    }

    @When("I input valid farm description")
    public void iInputValidFarmDescription() {
        aquacultureFarms.inputFarmDescription("This is a valid farm description.");
    }

    @When("I click save button farm")
    public void iClickSaveButtonFarm() {
        aquacultureFarms.clickSaveButtonFarm();
    }
    @When("I click save button edit farm")
    public void saveEditButtonFarm() {
        aquacultureFarms.saveEditButtonFarm();
    }

    @Then("I am redirected to the farms page after adding a farm")
    public void iAmRedirectedToTheFarmsPageAfterAddingAFarm() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I click cancel button farm")
    public void iClickCancelButtonFarm() {
        aquacultureFarms.clickCancelButtonFarm();
    }

    @Then("I am redirected to the farms page after canceling")
    public void iAmRedirectedToTheFarmsPageAfterCanceling() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I select a farm to edit")
    public void iSelectAFarmToEdit() {
        aquacultureFarms.selectFarmEditButton();
    }

    @When("I click on edit button farm")
    public void iClickOnEditButtonFarm() {
        aquacultureFarms.clickEditFarmButton();
    }

    @When("I update the farm description")
    public void farmDescriptionFieldUpdate() {
        aquacultureFarms.farmDescriptionFieldUpdate("Updated farm description.");
    }

    @Then("I am redirected to the farms page after editing a farm")
    public void iAmRedirectedToTheFarmsPageAfterEditingAFarm() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I change my mind and click cancel button farm")
    public void iChangeMyMindAndClickCancelButtonFarm() {
        aquacultureFarms.clickCancelButtonFarm();
    }

    @Then("I am redirected to the farms page after canceling edit")
    public void iAmRedirectedToTheFarmsPageAfterCancelingEdit() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I select a farm to delete")
    public void iSelectAFarmToDelete() {
        aquacultureFarms.selectFarmDeleteButton();
    }

    @When("I click on delete button farm")
    public void iClickOnDeleteButtonFarm() {
        aquacultureFarms.clickDeleteFarmButton();
    }

    @When("I confirm the farm deletion")
    public void iConfirmTheFarmDeletion() {
        aquacultureFarms.confirmFarmDeletion();
    }

    @Then("the farm is deleted")
    public void theFarmIsDeleted() {
        // Implementasi verifikasi bahwa farm telah dihapus
        Assertions.assertTrue(true); // Ganti dengan langkah verifikasi yang sebenarnya
    }

    @Then("I am redirected to the farms page after deleting a farm")
    public void iAmRedirectedToTheFarmsPageAfterDeletingAFarm() {
        Assertions.assertTrue(aquacultureFarms.isOnFarmsPage());
    }

    @When("I select a farm to view")
    public void iSelectAFarmToView() {
        aquacultureFarms.selectDetailFarmButton();
    }

    @When("I click on view details farm button")
    public void iClickOnViewDetailsFarmButton() {
        aquacultureFarms.clickViewDetailFarmButton();
    }

    @Then("I am redirected to the farm details page")
    public void iAmRedirectedToTheFarmDetailsPage() {
        Assertions.assertTrue(aquacultureFarms.isFarmDetailsPageDisplayed());
    }
}
