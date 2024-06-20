package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Dashboard extends PageObject{

    private By blueharvestIcon() { return By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[1]/div[2]/h1");}

    @Step
    public boolean validateOnDashboardPage() { return $(blueharvestIcon()).isDisplayed(); }


}
