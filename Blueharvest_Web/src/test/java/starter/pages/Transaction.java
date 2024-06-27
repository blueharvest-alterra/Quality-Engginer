package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class Transaction extends PageObject {

    private By transactionButton() {return By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[6]");}
    private By title() {return By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/h1");}
    private By nextButton() {return By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div/div/button[6]");}
    private By sampleTransaction() {return By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/table");}
    private By firstSampleTransaction() {return By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]");}
    @Step
    public void goToTransactionPage() {
        $(transactionButton()).click();
    }

    @Step
    public boolean validateOnTransactionPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validateFirstSample() {
        return $(firstSampleTransaction()).isDisplayed();
    }

    @Step
    public boolean validateFirstSampleName(String name) {
        return $(firstSampleTransaction()).getText().equals(name);
    }

    @Step
    public void clickNextButton() {
        $(nextButton()).click();
    }

    @Step
    public boolean validateSampleTransaction() {
        return $(sampleTransaction()).isDisplayed();
    }

    @Step
    public boolean validateSampleTransactionName(String name) {
        return $(sampleTransaction()).getText().equals(name);
    }



}
