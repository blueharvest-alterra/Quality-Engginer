package starter.pages.dashboard;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

public class Dashboard extends PageObject {

    private By incomeDetailsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/a");
    private By productTotalDetailsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a");
    private By farmTotalDetailsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/a");
    private By latestArticleDetailsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/a");
    private By latestProductDetailsButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[3]/div[2]/div[1]/a");

    private By incomePageTitle = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/h1");
    private By productTotalPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");
    private By farmTotalPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");
    private By latestArticlePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");
    private By latestProductPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/h1");

    private By blueharvestIcon = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[1]/div[2]/h1");

    // Invalid button locators for negative scenarios
    private By invalidButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[99]/div[1]/div[2]/a");

    public void clickIncomeDetailsButton() {
        $(incomeDetailsButton).click();
    }

    public void clickProductTotalDetailsButton() {
        $(productTotalDetailsButton).click();
    }

    public void clickFarmTotalDetailsButton() {
        $(farmTotalDetailsButton).click();
    }

    public void clickLatestArticleDetailsButton() {
        $(latestArticleDetailsButton).click();
    }

    public void clickLatestProductDetailsButton() {
        $(latestProductDetailsButton).click();
    }

    public boolean isOnIncomePage() {
        return $(incomePageTitle).isDisplayed();
    }

    public boolean isOnProductTotalPage() {
        return $(productTotalPageTitle).isDisplayed();
    }

    public boolean isOnFarmTotalPage() {
        return $(farmTotalPageTitle).isDisplayed();
    }

    public boolean isOnLatestArticlePage() {
        return $(latestArticlePageTitle).isDisplayed();
    }

    public boolean isOnLatestProductPage() {
        return $(latestProductPageTitle).isDisplayed();
    }

    public boolean validateOnDashboardPage() {
        return $(blueharvestIcon).isDisplayed();
    }

    // Methods for negative scenarios
    public void clickInvalidButton() {
        try {
            // Check if the button is present
            if ($(invalidButton).isPresent()) {
                // Wait until the button is clickable
                $(invalidButton).withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable();

                // Click the button if it is enabled
                if ($(invalidButton).isEnabled()) {
                    $(invalidButton).click();
                } else {
                    System.out.println("Button is not enabled.");
                }
            } else {
                System.out.println("Button is not present.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Button not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public boolean isErrorDisplayedForInvalidButton() {
        try {
            $(invalidButton).isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    // Additional negative scenario methods if needed...
}
