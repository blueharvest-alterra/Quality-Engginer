package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import starter.pages.Monitoring;

public class MonitoringSteps extends PageObject {
    @Steps
    Monitoring monitoring;

    @When("I redirected to edit farm page")
    public void redirectedToEditFarmPage() {
        monitoring.validateMonitoringIsDisplayed();
    }

    @Then("I see update farms condition")
    public void seeUpdateFarms() {
        monitoring.validateUpdateFarms();
    }

    @And("I click edit condition farm")
    public void clickEditConditionFarm() {
        monitoring.clickEditFarmConditionButton();
    }

    @And("I input valid temperature")
    public void inputValidTemp() {
        monitoring.inputTemperature("29.00");
    }

    @And("I input valid PH")
    public void inputValidPH() {
        monitoring.inputPh("7.00");
    }

    @And("I input valid water oxygen")
    public void inputValidWaterOxygen() {
        monitoring.inputOxygen("50.00");
    }

    @And("I click save update button")
    public void clickSaveUpdateFarmButton() {
        monitoring.clickSaveUpdateFarmButton();
    }

    @And("I input invalid temperature")
    public void inputInvalidTemp() {
        monitoring.inputTemperature("aa");
    }

    @And("I input invalid PH")
    public void inputInvalidPH() {
        monitoring.inputPh("aa");
    }

    @And("I input invalid water oxygen")
    public void inputInvalidWaterOxygen() {
        monitoring.inputOxygen("aa");
    }

    @Then("I see error message {string}")
    public void errorMonitoringFarms() {
        monitoring.errorMonitoringFarms();
    }

    @And("I clear temperature")
    public void clearTemp() {
        monitoring.clearTemp();
    }

    @And("I clear PH")
    public void clearPH() {
        monitoring.clearPh();
    }

    @And("I clear water oxygen")
    public void clearWaterOxygen() {
        monitoring.clearOxygen();
    }

    @And("I click cancel update condition farm")
    public void clickCancelUpdateConditionFarm() {
        monitoring.clickCancelUpdateFarms();
    }
}
