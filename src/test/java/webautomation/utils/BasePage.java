package webautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static webautomation.utils.WebDriverFactory.getWebDriver;

// All pages inherit form this class
public abstract class BasePage
{
   protected WebDriver driver;

   protected BasePage()
   {
      driver = getWebDriver();
   }

   protected void waitUntilVisible( By component )
   {
      WebDriverWait wait = new WebDriverWait( getWebDriver(), 10 );
      wait.until( ExpectedConditions.visibilityOfElementLocated( component ) );
   }

   protected void waitUntilHidden( By component )
   {
      WebDriverWait wait = new WebDriverWait( getWebDriver(), 15 );
      wait.until( ExpectedConditions.invisibilityOfElementLocated( component ) );
   }

   private void scroll( int offset, By by )
   {
      JavascriptExecutor javaDriver = (JavascriptExecutor) this.driver;

      driver.switchTo().defaultContent();

      String expression = "scroll(0," + offset + ")";

      if ( by != null )
      {
         WebElement iframe = driver.findElement( by );

         driver.switchTo().frame( iframe );
         javaDriver.executeScript( expression );
      }
      else
      {
         javaDriver.executeScript( expression );
      }
   }

   protected void scrollToTop( By by )
   {
      scroll( 0, by );
   }

   protected void scrollToBottom( By by )
   {
      scroll( 10000, by );
   }

   protected void scrollToTop()
   {
      scroll( 0, null );
   }

   protected void scrollToBottom()
   {
      scroll( 10000, null );
   }

   protected WebElement findElementByDataId( String dataId )
   {
      return getWebDriver().findElement( byDataId( dataId ) );
   }
//TODO update to reflect data-test-id selectors//
   protected By byDataId( String dataId )
   {
      return By.xpath( String.format( "//*[@data-test-id=\"%s\"]", dataId ) );
   }
}
