package co.com.siigo.automation.runners.front;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/front/crear_cliente.feature",
        glue = "co.com.siigo.automation.stepdefinitions.front",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CrearClienteRunner {}
