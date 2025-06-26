package co.com.siigo.automation.tasks.front;

import co.com.siigo.automation.interactions.front.EnterTextShadowRoot;
import co.com.siigo.automation.interactions.front.WaitStatic;
import co.com.siigo.automation.utils.FakerRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.*;

import static co.com.siigo.automation.userinterfaces.CrearClientePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LlenarFormularioClienteDesdeShadow implements Task {


    public static LlenarFormularioClienteDesdeShadow conDatosFaker() {
        return instrumented(LlenarFormularioClienteDesdeShadow.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        actor.attemptsTo(
                WaitStatic.milliseconds(5000),
                EnterTextShadowRoot.with(TIPO_IDENTIFICACION_SHADOW_ROOT,TIPO_IDENTIFICACION_INPUT,FakerRandom.documento()),
                EnterTextShadowRoot.with(NOMBRES_SHADOW_ROOT,NOMBRE_INPUT,FakerRandom.nombre()),
                EnterTextShadowRoot.with(APELLIDO_SHADOW_ROOT,APELLIDO_INPUT,FakerRandom.apellido()),
                WaitStatic.milliseconds(10000)
        );
    }
}
