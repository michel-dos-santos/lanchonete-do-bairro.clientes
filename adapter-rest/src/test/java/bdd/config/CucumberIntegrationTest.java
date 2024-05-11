package bdd.config;

import br.com.lanchonete.Application;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
@SpringBootTest(classes = Application.class)
public class CucumberIntegrationTest {
}