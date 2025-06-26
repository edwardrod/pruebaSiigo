package co.com.siigo.automation.stepdefinitions.front;

import co.com.siigo.automation.tasks.front.IngresarModuloCrearClientes;
import co.com.siigo.automation.tasks.front.LlenarFormularioClienteDesdeShadow;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;


public class CrearClienteStepDefinitions {

    @Y("ingresa al modulo de Crear Clientes")
    public void ingresaAlModuloDeCrearClientes() {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarModuloCrearClientes.desdeElDashboard());
    }

    @Y("diligencia todos los campos obligatorios con datos válidos")
    public void diligenciaCamposValidos() {
         OnStage.theActorInTheSpotlight().attemptsTo(
                 LlenarFormularioClienteDesdeShadow.conDatosFaker()
        );
    }

    @Y("confirma la creación del cliente")
    public void confirmaCreacion() {
    }

    @Entonces("debería ver el mensaje {string}")
    public void deberiaVerMensaje(String mensajeEsperado) {
    }


}
