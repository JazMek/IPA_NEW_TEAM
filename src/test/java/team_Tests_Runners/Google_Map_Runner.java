package team_Tests_Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/karimmekdoud/IdeaProjects/Rahul_Rest_API/src/test/java/team_Files_Fuatur/Place.feature"},
        glue = "team_Steps_Definitions",
        strict = true,
        monochrome = true,
        dryRun = false
)
public class Google_Map_Runner {


}
