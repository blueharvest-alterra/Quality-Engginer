package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Article extends PageObject {
    private By articlePageButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[4]/div[2]/h1");
    private By addArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/a/button");
    private By articleTitleField = By.xpath("//*[@id=\"title\"]");
    private By articleImageField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[2]/label[2]/input[@type='file']");
    private By articleDescriptionField = By.xpath("//*[@id=\"desc\"]/div/div[1]");
    private By saveButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[4]/button");
    private By cancelButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[4]/a/button");
    private By selectArticleEdit = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/button");
    private By selectArticleDelete = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[4]/button");
    private By selectArticleView = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/button");
    private By viewDetailArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/div/a[1]/button");
    private By editArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/div/a[2]/button");
    private By deleteArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[4]/div/div/button");
    private By deleteButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/button[1]");

    private By articleDetailsPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By articleEditPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By articleDeletePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/h1");
    private By articlePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");

    @Step("Click article page button")
    public void clickArticlePageButton() {
        $(articlePageButton).click();
    }

    @Step("Check if on article page")
    public boolean isOnArticlePage() {
        return $(articlePageTitle).isDisplayed();
    }

    @Step("Check if redirected to edit article page")
    public boolean thenIRedirectedToEditArticlePage() {
        return $(articleEditPageTitle).isDisplayed();
    }

    @Step("Click add article button")
    public void clickAddArticleButton() {
        $(addArticleButton).click();
    }

    @Step("Click delete button")
    public void clickDeleteButton() {
        $(deleteButton).click();
    }

    @Step("Input article title: {0}")
    public void inputArticleTitle(String title) {
        $(articleTitleField).sendKeys(title);
    }

    @Step("Input article image")
    public void inputArticleImage(String imagePath) {
        WebElement fileInputElement = $(articleImageField);
        fileInputElement.sendKeys(imagePath);
    }

    @Step("Input article description: {0}")
    public void inputArticleDescription(String desc) {
        $(articleDescriptionField).sendKeys(desc);
    }

    @Step("Click save button")
    public void clickSaveButton() {
        $(saveButton).click();
    }

    @Step("Click cancel button")
    public void clickCancelButton() {
        $(cancelButton).click();
    }

    @Step("Click edit article button")
    public void clickEditArticleButton() {
        $(editArticleButton).click();
    }

    @Step("Select article edit button")
    public void selectArticleEditButton() {
        $(selectArticleEdit).click();
    }

    @Step("Click delete article button")
    public void clickDeleteArticleButton() {
        $(deleteArticleButton).click();
    }

    @Step("Select article delete button")
    public void selectArticleDeleteButton() {
        $(selectArticleDelete).click();
    }

    @Step("Select detail article button")
    public void selectDetailArticleButton() {
        $(selectArticleView).click();
    }

    @Step("Click view detail article button")
    public void clickViewDetailArticleButton() {
        $(viewDetailArticleButton).click();
    }

    @Step("Check if article details page is displayed")
    public boolean isArticleDetailsPageDisplayed() {
        return $(articleDetailsPageTitle).isDisplayed();
    }
}
