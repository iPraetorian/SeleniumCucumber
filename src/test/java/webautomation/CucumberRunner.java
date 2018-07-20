package webautomation;
        import cucumber.api.CucumberOptions;
        import cucumber.api.junit.Cucumber;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format ={"pretty","html:reports/test-report"}, tags = CucumberRunner.RUN_ALL)
public class CucumberRunner {

   @Override
   public boolean equals(Object obj) {
      return super.equals(obj);
   }

   // Putting each test on a separate line will make it easier to merge
   static final String RUN_ALL = "@acceptance";

}