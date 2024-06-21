package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Product extends PageObject {

    private By productPageButton() { return By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/a[2]");}
    private By title() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");}
    private By addProductButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div");}
    private By sampleProduct() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/a");}
    private By titleProduct() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[1]/input");}
    private By stock() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[2]/input");}
    private By price() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[3]/div/input");}
    private By desc() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[4]/textarea");}
    private By image() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[6]/label[2]");}
    private By saveButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/div/form/div[7]/button[1]");}
    private By editPage() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/h1");}
    private By editTitle() {return By.xpath("//*[@id=\"name\"]");}
    private By editPrice() {return By.xpath("//*[@id=\"harga\"]");}
    private By editStock() {return By.xpath("//*[@id=\"stok\"]");}
    private By editDesc() {return By.xpath("//*[@id=\"desc\"]");}
    private By editSaveButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[3]/button[1]");}
    private By threeDotsIcon() { return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[7]/button");}
    private By confirmDelete() {return By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/button[1]");}


    @Step
    public void clickProductPageButton() {
        $(productPageButton()).isDisplayed();
        $(productPageButton()).isClickable();
        $(productPageButton()).click();
    }
    @Step
    public boolean validateOnProductPage() {
        return $(title()).isDisplayed();
    }

    @Step
    public boolean validateListProductDisplayed() {
        return $(sampleProduct()).isDisplayed();
    }

    @Step
    public void clickAddProductButton() {
        $(addProductButton()).click();
    }

    @Step
    public void inputProductTitle(String title) {
        $(titleProduct()).type(title);
    }

    @Step
    public void inputProductStock(int stock) {
        $(stock()).type(Integer.toString(stock));
    }

    @Step
    public void inputProductPrice(int price) {
        $(price()).type(Integer.toString(price));
    }

    @Step
    public void inputProductDescription(String desc) {
        $(desc()).type(desc);
    }

    @Step
    public void inputProductImage(String imagePath) {
        $(image()).click();
        WebElement fileInputElement = $(image());
        fileInputElement.sendKeys(imagePath);
    }

    @Step
    public void clickSaveButton(){
        $(saveButton()).click();
    }

    @Step
    public void inputInvalidPrice(int price) {
        $(price()).type(Integer.toString(000));
    }

    @Step
    public void inputInvalidStock(int stock) {
        $(price()).type(Integer.toString(000));
    }

    @Step
    public void clickSampleProduct() {
        $(sampleProduct()).click();
        $(editPage()).isDisplayed();
    }

    @Step
    public void editProductTitle(String title) {
        $(editTitle()).type(title);
    }

    @Step
    public void editProductPrice(int price) {
        $(editPrice()).type(Integer.toString(price));
    }

    @Step
    public void editProductStock(int stock) {
        $(editStock()).type(Integer.toString(stock));
    }

    @Step
    public void editProductDesc(String desc){
        $(editDesc()).type(desc);
    }
    @Step
    public void clickSaveEditButton() {
        $(editSaveButton()).click();
    }

    @Step
    public void clickThreeDotsIcon() {
        $(threeDotsIcon()).click();
    }
    @Step
    public void clickConfirmDeleteButton() {
        $(confirmDelete()).click();
    }

}
