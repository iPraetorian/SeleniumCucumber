package webautomation.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webautomation.pages.Login;

import java.net.URI;
import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static webautomation.utils.WebDriverFactory.*;

// This class contains common cucumber steps that not tied to a specific page
public class Common {
//   @Then("^I am sent to the ([^\"]*) page$")
//   public void i_am_sent_to_page(String url) throws Throwable {
//      assertTrue(getWebDriver().getCurrentUrl().endsWith(url));
//   }
//
////   @And("^I navigate to url \"([^\"]*)\"$")
////   public void iNavigateToAnAssemblyPage(String pageURL) throws Throwable {
////      getWebDriver().get(new URI(getWebDriver().getCurrentUrl()).resolve(pageURL).toString());
////   }
//
//
//   @Given("^I am logged in as the default user on the home page$")
//   public void login_as_default_user() {
//      Login loginPage = new Login();
//      loginPage.goto_login();
//      loginPage.enter_default_credentials();
//   }
//
//   @Given("^I am logged in as the default user on the \"([^\"]*)\" page$")
//   public void login_as_default_user_and_on_a_specific_page(String page) {
//      Login loginPage = new Login();
//      loginPage.goto_login();
//      loginPage.enter_default_credentials();
//
//      getWebDriver().get(page);
//   }
//
//   @And("^I scroll up to the top of the page$")
//   public void iScrollUpToTheTopOfThePage() throws Throwable {
//
//      Actions actions = new Actions(getWebDriver());
//      actions.sendKeys(Keys.PAGE_UP).build().perform();
//
//   }
//
//   @And("^I scroll down to the bottom of the page$")
//   public void iScrollDownToTheBottomOfThePage() throws Throwable {
//
//      Actions actions = new Actions(getWebDriver());
//      actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//
//   }

   private void waitUntilVisible(By component) {
      WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
      wait.until(ExpectedConditions.visibilityOfElementLocated(component));
   }

   @After
   public void shutdownHook() {
      ensureNewSession();
   }

   @Before
   public void setup(Scenario scenario) {
      Iterator<String> iterator = scenario.getSourceTagNames().iterator();
      StringBuilder sb = new StringBuilder();
      if (iterator.hasNext())
         sb.append(iterator.next()).append(" > ");

      sb.append(scenario.getName());

      setSauceLabsTestName(sb.toString());
   }

//   @And("^I scroll up to the top$")
//   public void iScrollUpToTheTop() throws Throwable {
//      Thread.sleep(1500);
//      iScrollUpToTheTopOfThePage();
//   }



}

