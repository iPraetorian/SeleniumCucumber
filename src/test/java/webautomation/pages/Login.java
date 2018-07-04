package webautomation.pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import webautomation.utils.BasePage;

public class Login extends BasePage
{

   public static final String URL = "https://github.com";

   @Given("^I am on the login page$")
   public void goto_login()
   {
      driver.get( URL );

      // wait until login screen is loaded
      waitUntilVisible( By.id("password") );
   }

   @When("^I enter default credentials$")
   public void enter_default_credentials()
   {
      driver.findElement( By.id( "username" ) ).sendKeys( "user" );
      driver.findElement( By.id( "password" ) ).sendKeys( "password" );
      driver.findElement( By.id( "submit" ) ).click();

      // Wait until home page
      waitUntilVisible( By.id( "home" ) );
   }
}
