package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import starter.pages.VoucherPromo;

public class VoucherPromoSteps extends PageObject {
    @Steps
    VoucherPromo voucherPromo;

    @Then("I go to promo page")
    public void goToPromoPage() {
        voucherPromo.clickPromoPageButton();
        Assertions.assertTrue(voucherPromo.validateOnVoucherPage());
    }

    @Then("I see the list of vouchers")
    public void viewListVouchers() {
        Assertions.assertTrue(voucherPromo.validateVoucherListDisplayed());
    }

    @When("I click add voucher button")
    public void clickAddVoucherButton() {
        voucherPromo.clickAddVoucherButton();
    }

    @And("I input valid voucher title")
    public void inputValidVoucherTitle() {
        voucherPromo.inputVoucherTitle("Diskon Besar 77K");
    }

    @And("I input valid code")
    public void inputValidCode() {
        voucherPromo.inputVoucherCode("DISKON77K");
    }

    @And("I input valid discount")
    public void inputValidDiscount() {
        voucherPromo.inputDisc(77000);
    }

    @And("I choose available status")
    public void chooseAvailable() {
        voucherPromo.chooseAvailable();
    }

    @And("I click save promo button")
    public void clickSavePromoButton() {
        voucherPromo.clickSaveVoucherButton();
    }

    @Then("I redirected to promo page")
    public void redirectedToPromoPage() {
        voucherPromo.validateOnVoucherPage();
    }

    @When("I click three dots button of a voucher")
    public void clickThreeDotsButtonVoucher() {
        voucherPromo.clickThreeButtonsVoucher();
    }

    @And("I click edit promo button")
    public void clickEditPromoButton() {
        voucherPromo.clickEditPromo();
    }

    @And("I edit voucher title")
    public void editVoucherTitle() {
        voucherPromo.inputEditVoucherTitle("DISKON BESAR 77K");
    }

    @And("I edit voucher code")
    public void editVoucherCode() {
        voucherPromo.inputEditVoucherCode("DISKON77K");
    }

    @And("I edit discount")
    public void editDisc() {
        voucherPromo.inputEditVoucherDiscount(77000);
    }

    @And("I click save edit promo button")
    public void clickSaveEditPromoButton() {
        voucherPromo.clickSaveEditButton();
    }

    @And("I clear voucher title")
    public void clearVoucherTitle() {
        voucherPromo.clearVoucherTitle();
    }

    @And("I clear voucher code")
    public void clearVoucherCode() {
        voucherPromo.clearVoucherCode();
    }

    @And("I clear discount")
    public void clearVoucherDiscount() {
        voucherPromo.clearVoucherDiscount();
    }

    @And("I click delete voucher button")
    public void clickDeleteVoucherButton() {
        voucherPromo.clickDeleteVoucher();
    }

    @And("I click confirm delete voucher button")
    public void clickConfirmDeleteVoucherButton() {
        voucherPromo.clickConfirmDelete();
    }

    @And("I click cancel add promo button")
    public void clickCancelAddPromoButton() {voucherPromo.clickCancelAddVoucher();}

    @And("I click view promo button")
    public void clickViewPromoButton() {voucherPromo.clickViewPromo();}

    @Then("I can see the detail of promo")
    public void seeDetailOfPromo() {voucherPromo.validateOnDetailPage();
    voucherPromo.validateTextOnDetailPage();}

    @And("I click cancel edit promo button")
    public void clickCancelEditPromoButton() {
        voucherPromo.clickCancelEditVoucher();
    }

}
