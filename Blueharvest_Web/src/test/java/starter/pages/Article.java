package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Article extends PageObject {
    private By articlePageButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[5]");
    private By addArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div");
    private By articleTitleField = By.xpath("//*[@id=\"title\"]");
    private By articleImageField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[2]/label[2]");
    private By articleDescriptionField = By.xpath("//*[@id=\"desc\"]/div");
    private By saveButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[4]/button");
    private By cancelButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[4]/a/button");
    private By selectAticleEdit = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]");
    private By selectAticleDelate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[4]/button/svg");
    private By selectAticleView = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[4]/button");
    private By viewDetailArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[4]/div/div/a[1]/button");
    private By editArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/div/a[2]");
    private By deleteArticleButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[4]/div/div/button");
    private By deleteButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/button[1]");

    private By articleDetailsPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By articleEditPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");
    private By articleDeletePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/h1");
    private By articlePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");

    public void clickArticlePageButton() {
        $(articlePageButton).click();
    }

    public boolean isOnArticlePage() {
        return $(articlePageTitle).isDisplayed();
    }

    public boolean thenIRedirectedToEditArticlePage() {
        return $(articleEditPageTitle).isDisplayed();
    }

    public void clickAddArticleButton() {
        $(addArticleButton).click();
    }

    public void clickDeleteButton() {
        $(deleteButton).click();
    }

    public void inputArticleTitle(String title) {
        $(articleTitleField).sendKeys(title);
    }

    public void inputArticleImage(String imageUrl) {
        $(articleImageField).sendKeys(imageUrl);
    }

    public void inputArticleDescription(String description) {
        $(articleDescriptionField).type(description);
    }

    public void clickSaveButton() {
        $(saveButton).click();
    }

    public void clickCancelButton() {
        $(cancelButton).click();
    }

    public void clickEditArticleButton() {
        $(editArticleButton).click();
    }

    public void selectArticleEditButton() {
        $(selectAticleEdit).click();
    }

    public void clickDeleteArticleButton() {
        $(deleteArticleButton).click();
    }
    public void selectArticleDeleteButton() {
        $(selectAticleDelate).click();
    }

    public void selectDetailArticleButton() {
        $(selectAticleView).click();
    }

    public void clickViewDetailArticleButton() {
        $(viewDetailArticleButton).click();
    }

    public boolean isArticleDetailsPageDisplayed() {
        return $(articleDetailsPageTitle).isDisplayed();
    }


}
