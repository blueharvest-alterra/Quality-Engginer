package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SignIn extends PageObject {
    private By signInButton() { return By.xpath("//*[@id=\"root\"]/div/div/div[3]/section/div/div/div/form/button");}
    private By email() {return By.id("email");}
    private By password() {return By.id("password");}
    private By message() {return By.xpath("//*[@id=\"root\"]/div/div/div[3]/section/div/div/div/form/p");}

    @Step
    public boolean validateOnSignInPage() {
        return $(signInButton()).isDisplayed();
    }

    @Step
    public void inputEmail(String email) {
        $(email()).click();
        $(email()).type(email);
    }

    @Step
    public void inputPassword(String password){
        $(password()).click();
        $(password()).type(password);
    }

    @Step
    public void clickSignInButton(){
        $(signInButton()).click();
    }

    @Step
    public boolean validateMessageIsShown() {
       return $(message()).isDisplayed();
    }

    @Step
    public boolean validateEqualMessage(String message) {
         return $(message()).getText().equals(message);
    }

    public boolean validateErrorMessage() {
        Alert alert = getAlert();
        if (alert != null) {
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            return true;
        } else {
            return false;
        }
    }

    public boolean validateEqualErrorMessage(String expectedErrorMessage) {
        Alert alert = getAlert();
        if (alert != null) {
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            assertThat(alertText).isEqualTo(expectedErrorMessage);
            alert.accept();
            return true;
        } else {
            return false;
        }
    }

    public Alert getAlert() {
        try {
            return getDriver().switchTo().alert();
        } catch (Exception e) {
            return null;
        }
    }
}
