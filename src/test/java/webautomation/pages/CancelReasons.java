package webautomation.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import webautomation.utils.BasePage;



public class CancelReasons extends BasePage {
    public static final String URL = "https://localhost:2124";

    @Given("^I am on the cancel subscription reasons page$")
    public void cancel_subscription_reasons_page(){
        driver.get(URL);
    }



//    @When("^I click the Too Expensive icon$")
//    public void i_click_too_expensive() {
//        driver.get(URL);
//        driver.findElement(By.id("tooExpensive")).click();
//    }
}
