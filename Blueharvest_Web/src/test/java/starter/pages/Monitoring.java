package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class Monitoring extends PageObject {
    private By title() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/h1");}
    private By update() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div/div[1]/div[1]/div[1]/h1");}
    private By editButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[3]/div/div[2]/button");}
    private By temperature() {return By.xpath("//*[@id=\"suhu-air\"]");}
    private By ph() {return By.xpath("//*[@id=\"ph-air\"]");}
    private By oxygen() {return By.xpath("//*[@id=\"oksigen-air\"]");}
    private By saveButton() {return By.xpath("//*[@id=\"authentication-modal\"]/div/div/div[3]/button[1]");}
    private By cancelButton() {return By.xpath("//*[@id=\"authentication-modal\"]/div/div/div[3]/button[2]");}
    private By error() {return By.xpath("///");}
    @Step
    public boolean validateMonitoringIsDisplayed() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validateUpdateFarms() {
        return $(update()).isDisplayed();
    }

    @Step
    public void clickEditFarmConditionButton() {
        $(editButton()).click();
    }

    @Step
    public void inputTemperature(String temp) {
        $(temperature()).type(temp);
    }

    @Step
    public void inputPh(String ph) {
        $(ph()).type(ph);
    }

    @Step
    public void inputOxygen(String ox) {
        $(oxygen()).type(ox);
    }

    @Step
    public void clickSaveUpdateFarmButton() {
        $(saveButton()).click();
    }

    @Step
    public void clearTemp(){
        $(temperature()).clear();
    }

    @Step
    public void clearPh() {
        $(ph()).clear();
    }

    @Step
    public void clearOxygen() {
        $(oxygen()).clear();
    }

    @Step
    public void clickCancelUpdateFarms() {
        $(cancelButton()).click();
    }

    @Step
    public void errorMonitoringFarms() {
        $(error()).isDisplayed();
    }

}
