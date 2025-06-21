package co.com.siigo.automation.tasks.front;

import co.com.siigo.automation.interactions.front.ClickShadowRoot;
import co.com.siigo.automation.interactions.front.WaitStatic;
import net.serenitybdd.core.pages.ResolvableElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.siigo.automation.userinterfaces.CrearClientePage.APELLIDO_SHADOW_ROOT;
import static co.com.siigo.automation.userinterfaces.DashboardPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarModuloCrearClientes implements Task {

    private Target listaTarget;

    public static IngresarModuloCrearClientes desdeElDashboard() {
        return instrumented(IngresarModuloCrearClientes.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(HEADER_MOLECULE_SHADOW_ROOT, isVisible()).forNoMoreThan(30).seconds(),
                    ClickShadowRoot.with(HEADER_MOLECULE_SHADOW_ROOT, CREATE_SHADOW_ROOT),
                    ClickShadowRoot.with(HEADER_MOLECULE_SHADOW_ROOT, CLIENTES_BUTTON),
                    WaitStatic.milliseconds(10000),
                    WaitUntil.angularRequestsHaveFinished()

            );
    }
}