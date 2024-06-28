package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class VoucherPromo extends PageObject {
    private By voucherPage() { return By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[5]");}
    private By title() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");}
    private By addVoucherButton() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/button");}
    private By sampleVoucher() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[1]");}
    private By voucherTitle() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[1]/input");}
    private By voucherCode() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[2]/input");}
    private By discount() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[3]/div/input");}
    private By availableStatus() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[4]/div/label[1]/input");}
    private By saveButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[5]/button[1]");}
    private By saveEditButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[5]/button[1]");}
    private By threeDots() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/button");}
    private By edit() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[2]");}
    private By delete() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[3]/button");}
    private By confirmDelete() {return By.xpath("/html/body/div[2]/div/div[6]/button[1]");}
    private By editVoucherTitle() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[1]/input");}
    private By editVoucherCode() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[2]/input");}
    private By editDiscount() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[3]/div/input");}
    private By viewVoucher() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[1]");}
    private By cancelAddVoucher() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[5]/button[2]");}
    private By cancelEditVoucher() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[5]/button[2]");}
    private By detailPage() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/form/div[1]/label");}
    @Step
    public void clickPromoPageButton() {
        $(voucherPage()).isDisplayed();
        $(voucherPage()).isClickable();
        $(voucherPage()).click();
    }

    @Step
    public boolean validateOnVoucherPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validateVoucherListDisplayed() {
        return $(sampleVoucher()).isDisplayed();
    }

    @Step
    public void clickAddVoucherButton() {
        $(addVoucherButton()).click();
    }

    @Step
    public void inputVoucherTitle(String title) {
        $(voucherTitle()).type(title);
    }

    @Step
    public void inputVoucherCode(String code) {
        $(voucherCode()).type(code);
    }

    @Step
    public void inputDisc(int disc) {
        $(discount()).type(Integer.toString(disc));
    }

    @Step
    public void chooseAvailable() {
        $(availableStatus()).click();
    }

    @Step
    public void clickSaveVoucherButton() {
        $(saveButton()).click();
    }

    @Step
    public void clickThreeButtonsVoucher() {
        $(threeDots()).click();
    }

    @Step
    public void clickEditPromo() {
        $(edit()).click();
    }

    @Step
    public void inputEditVoucherTitle(String title) {
        $(editVoucherTitle()).type(title);
    }

    @Step
    public void inputEditVoucherCode(String code) {
        $(editVoucherCode()).type(code);
    }

    @Step
    public void inputEditVoucherDiscount(int disc) {
        $(editDiscount()).type(Integer.toString(disc));
    }

    @Step
    public void clickSaveEditButton() {
        $(saveEditButton()).click();
    }

    @Step
    public void clearVoucherTitle() {
        $(editVoucherTitle()).clear();
    }

    @Step
    public void clearVoucherCode() {
        $(editVoucherCode()).clear();
    }

    @Step
    public void clearVoucherDiscount() {
        $(editDiscount()).clear();
    }

    @Step
    public void clickDeleteVoucher() {
        $(delete()).click();
    }

    @Step
    public void clickConfirmDelete() {
        $(confirmDelete()).click();
    }

    @Step
    public void clickCancelAddVoucher() {$(cancelAddVoucher()).click();}

    @Step
    public void clickViewPromo() {$(viewVoucher()).click();}

    @Step
    public boolean validateOnDetailPage() {return $(viewVoucher()).isDisplayed();}

    @Step
    public boolean validateTextOnDetailPage() { return $(viewVoucher()).getText().equals("Nama");}

    @Step
    public void clickCancelEditVoucher() {$(cancelEditVoucher()).click();}


}
