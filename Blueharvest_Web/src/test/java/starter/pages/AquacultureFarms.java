package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AquacultureFarms extends PageObject {
    private By farmsPageButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[3]/div[2]/h1");
    private By addFarmButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/button");
    private By farmTitleField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[1]/input");
    private By priceEarlyField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[2]/div/input");
    private By countInvestment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[3]/div/input");
    private By farmDescriptionField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[4]/textarea");
    private By farmDescriptionFieldUpdate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[1]/div/textarea");
    private By farmImageField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[5]/label/input[@type='file']");
    private By saveButtonFarm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/form/div[6]/button[1]");
    private By saveEditButtonFarm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div[3]/div/button[1]");
    private By cancelButtonFarm = By.xpath("//button[text()='Batal']");
    private By selectFarmEdit = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/button");
    private By selectFarmDelete = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[4]/td[4]/button");
    private By selectFarmView = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/button");
    private By viewDetailFarmButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[1]");
    private By editFarmButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[4]/div/ul/li[2]");
    private By deleteFarmButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr[4]/td[4]/div/ul/li[3]/button");
    private By deleteButtonFarm = By.xpath("/html/body/div[2]/div/div[6]/button[1]");
    private By cancleDeleteeleteButtonFarm = By.xpath("/html/body/div[2]/div/div[6]/button[3]");

    private By farmDetailsPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By farmEditPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By farmDeletePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/h1");
    private By farmsPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");

    @Step("Click farms page button")
    public void confirmFarmDeletion() {
        $(deleteButtonFarm).click();
    }

    @Step("Click confirm farms delete button")
    public void clickFarmsPageButton() {
        $(farmsPageButton).click();
    }

    @Step("Check if on farms page")
    public boolean isOnFarmsPage() {
        return $(farmsPageTitle).isDisplayed();
    }

    @Step("Check if redirected to edit farm page")
    public boolean thenIRedirectedToEditFarmPage() {
        return $(farmEditPageTitle).isDisplayed();
    }

    @Step("Click add farm button")
    public void clickAddFarmButton() {
        $(addFarmButton).click();
    }

    @Step("Click delete button farm")
    public void clickDeleteButtonFarm() {
        $(deleteButtonFarm).click();
    }

    @Step("Input farm title: {0}")
    public void inputFarmTitle(String title) {
        $(farmTitleField).sendKeys(title);
    }

    @Step("Input farm count early: {0}")
    public void countInvestment(String title) {
        $(countInvestment).sendKeys(title);
    }

    @Step("Input farm price early: {0}")
    public void priceEarlyField(String title) {
        $(priceEarlyField).sendKeys(title);
    }

    @Step("Input farm image")
    public void inputFarmImage(String imagePath) {
        WebElement fileInputElement = $(farmImageField);
        fileInputElement.sendKeys(imagePath);
    }

    @Step("Input farm description: {0}")
    public void inputFarmDescription(String desc) {
        $(farmDescriptionField).sendKeys(desc);
    }
    @Step("Input farm description: {0}")
    public void farmDescriptionFieldUpdate(String desc) {
        $(farmDescriptionFieldUpdate).sendKeys(desc);
    }

    @Step("Click save button farm")
    public void clickSaveButtonFarm() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButtonFarm));
        evaluateJavascript("arguments[0].click();", saveButton);
    }

    @Step("Click save button farm")
    public void saveEditButtonFarm() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveEditButtonFarm));
        evaluateJavascript("arguments[0].click();", saveButton);
    }

    @Step("Click cancel button farm")
    public void clickCancelButtonFarm() {
        $(cancelButtonFarm).click();

    }

    @Step("Click edit farm button")
    public void clickEditFarmButton() {
        $(editFarmButton).click();
    }

    @Step("Select farm edit button")
    public void selectFarmEditButton() {
        $(selectFarmEdit).click();
    }

    @Step("Click delete farm button")
    public void clickDeleteFarmButton() {
        $(deleteFarmButton).click();
    }

    @Step("Select farm delete button")
    public void selectFarmDeleteButton() {
        $(selectFarmDelete).click();
    }

    @Step("Select detail farm button")
    public void selectDetailFarmButton() {
        $(selectFarmView).click();
    }

    @Step("Click view detail farm button")
    public void clickViewDetailFarmButton() {
        $(viewDetailFarmButton).click();
    }

    @Step("Check if farm details page is displayed")
    public boolean isFarmDetailsPageDisplayed() {
        return $(farmDetailsPageTitle).isDisplayed();
    }
}
