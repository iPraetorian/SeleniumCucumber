package webautomation.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Developers should maintain this class
public class WebDriverFactory
{
   private static final String USERNAME = "USER";
   private static final String ACCESS_KEY = "SAUCE_LABS_ACCESS_KEY";

   private static WebDriver instance;

   private static String sauceLabsTestName;


   public static WebDriver getWebDriver()
   {
      if ( instance != null )
      {
         return instance;
      }

      String env = System.getProperty( "environment" );

      if ( env.toLowerCase().startsWith( "local" ) )
      {
         instance = new ChromeDriver();


          org.openqa.selenium.Dimension D = new Dimension(1366,1024);
          getWebDriver().manage().window().setSize(D);

          //getWebDriver().manage().window().maximize();
         getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      }
      else
      {

         DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability( CapabilityType.BROWSER_NAME, "internet explorer" );
         capabilities.setCapability( CapabilityType.VERSION, "10");
         capabilities.setCapability( CapabilityType.PLATFORM, "WIN8");
         capabilities.setCapability( "screenResolution", "1280x1024");
         capabilities.setCapability( "name", sauceLabsTestName );

         String sauceLabsUrl = String.format( "http://%s:%s@ondemand.saucelabs.com:80/wd/hub", USERNAME, ACCESS_KEY );
         try
         {
            instance = new RemoteWebDriver( new URL( sauceLabsUrl ), capabilities );
         }
         catch ( MalformedURLException e )
         {
            throw new RuntimeException( e );
         }
      }

      return instance;
   }

   static void ensureNewSession(){

      if(instance!=null)
      {
         instance.quit();
         instance = null;
      }
   }

   public static void setSauceLabsTestName(String testName){
      sauceLabsTestName = testName;
   }
}
