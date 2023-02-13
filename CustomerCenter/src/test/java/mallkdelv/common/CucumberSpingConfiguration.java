package mallkdelv.common;


import mallkdelv.CustomerCenterApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerCenterApplication.class })
public class CucumberSpingConfiguration {
    
}
