package starter.pages;

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

    private By searchButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/div[2]/div/input"); // Adjust this locator
    private By chatButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/div[2]/a[1]"); // Adjust this locator
    private By notificationButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/div[2]/a[2]"); // Adjust this locator
    private By profileButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/div[2]/a[3]"); // Adjust this locator

    private By productSearchPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/input"); // Adjust this locator
    private By chatPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/h1"); // Adjust this locator
    private By notificationPageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/a[2]"); // Adjust this locator
    private By profilePageTitle = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/a[3]"); // Adjust this locator
    private By incomeSummary = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[2]/h1"); // Adjust this locator
    private By incomeSummaryBaseOnDate = By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]"); // Adjust this locator


    // Invalid button locators for negative scenarios
    private By invalidButton = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div[2]/div[1]/div[99]/div[1]/div[2]/a");

    public void clickIncomeDetailsButton() {
        $(incomeDetailsButton).click();
    }

    public boolean isOnIncomeSummaryPage(){
        return $(incomeSummary).isDisplayed();
    }


    public void incomeSummaryBaseOnDate() {
        $(incomeSummaryBaseOnDate).click();
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

    public boolean isOnChatPage() {
        return $(chatPageTitle).isDisplayed();
    }

    public boolean isProductDisplayedInSearchResults() {
        return $(productSearchPageTitle).isDisplayed();
    }

    public boolean isOnNotificationPage() {
        return $(notificationPageTitle).isDisplayed();

    }

    public boolean isOnProfilePage() {
        return $(profilePageTitle).isDisplayed();

    }

    public void searchProduct(String productName) {
        $(searchButton).sendKeys(productName);
        $(searchButton).submit(); // Adjust this if there is a separate search button to click
    }

    public void clickChatButton() {
        $(chatButton).click();
    }

    public void clickNotificationButton() {
        $(notificationButton).click();
    }

    public void clickProfileButton() {
        $(profileButton).click();
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
}