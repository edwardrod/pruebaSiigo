package co.com.siigo.automation.stepdefinitions.front;


import co.com.siigo.automation.questions.front.ValidacionLoginExitosa;
import co.com.siigo.automation.tasks.front.AbrirAplicacion;
import co.com.siigo.automation.tasks.front.IniciarSesion;
import co.com.siigo.automation.utils.setUpTest;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class LoginStepDefinitions {

    @Dado("que el usuario abre la aplicación de Siigo")
    public void queElUsuarioAbreLaAplicacionDeSiigo() {

        WebDriver navegador = setUpTest.iniciarChromeConOpciones();

        OnStage.setTheStage(new Cast());
        OnStage.theActorCalled("Eduar").can(
                BrowseTheWeb.with(navegador)
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                AbrirAplicacion.enElNavegador()
        );
    }

    @Cuando("ingresa sus credenciales válidas")
    public void ingresaSusCredencialesValidas() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conUsuarioYContrasena("retoautomationsiigo@yopmail.com", "T4b4ck0ff1c3P455w0rd658*")
        );
    }

    @Entonces("debería visualizar el panel principal de la aplicación")
    public void deberiaVisualizarElPanelPrincipal() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidacionLoginExitosa.esVisibleElDashboard(), is(true))
        );
    }
}
