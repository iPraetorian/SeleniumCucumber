# Cucumber Webdriver

## Run locally

#### 1. Install Chome webdriver

```
curl -o https://chromedriver.storage.googleapis.com/2.40/chromedriver_mac64.zip
unzip chromedriver_mac64.zip
sudo cp chromedriver /usr/local/bin
```

#### 2. Run tests

```
./run_local.sh
```

## Run on Saucelabs

```
./run_saucelabs.sh
```

## How does it work?

Test cases are written in natural language in Cucumber.

```cucumber
Feature: User log in

  Scenario: As a user I should be able to log in to application

    Given I am on the login page
    When I enter default credentials
    Then I am sent to the /start page

```

To support these test cases we need to write some java code that translates the natural language into DOM interactions.
It's critical that this java code is reusable and parameterized. 

```java
// This method would probably be referenced from a lot of tests!

@Given("^I am on the login page$")
public void goto_login()
{
  driver.get( "https://some-url.com" );

  // wait until login screen is loaded
  waitUntilVisible( By.id("submit") );
}
```


```java
@When("^I enter default credentials$")
public void enter_default_credentials()
{
  driver.findElement( By.id( "username" ) ).sendKeys( "sadmin@somesystem.com");
  driver.findElement( By.id( "password" ) ).sendKeys( "password");
  driver.findElement( By.id( "submit" ) ).click();

  // Wait until home page is loaded
  waitUntilVisible(By.id( "browse" ));
}
```

Notice how the last step is a generic step that can verify any URL
```java
@Then("^I am sent to the ([^\"]*) page$")
public void i_am_sent_to_page( String url ) throws Throwable
{
  assertTrue( getWebDriver().getCurrentUrl().endsWith( url ) );
}
```   

## Using tags

Each test has a bunch of tags associated with it. This gives us a lot of flexibility. We can for example run all tests with a @smoktetest tag from our build server.

We would just kick off the test with a specific tag
```
./run_local.sh @smoketest
```

## Intellij IDEA Integration

Intellij has great cucumber support. Not only will it validate the cucumber text on the fly, but you can also jump from a line 
in your cucumber test into the supporting Java code (Hold Ctrl and click on the line).

![](cucumber-idea.png)

# SeleniumCucumber
