package webautomation.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import webautomation.utils.BasePage;


public class Cancel extends BasePage {
    public static final String URL = "localhost:17338";

    @Given("^I am on the cancel subscription reasons page$")
    public void cancel_subscription_reasons_page() {
        driver.get(URL);
        //waitUntilVisible(byDataId("tooExpensive"));
    }

    @When("^I click the \"([^\"]*)\" icon$")
    public void i_click_the_icon(String args1) {
        driver.findElement(byDataId("tooExpensive")).click();

    }

    @Then("^The page displays \"([^\"]*)\"$")
    public void the_page_displays(String arg1) {
        driver.findElement(By.xpath("//input[@placeholder='Tell us more...we're listening']"));

    }
}