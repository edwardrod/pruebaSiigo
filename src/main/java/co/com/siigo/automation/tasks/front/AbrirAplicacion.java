package co.com.siigo.automation.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirAplicacion implements Task {

    private static final String URL_SIIGO = "https://qastaging.siigo.com/#/login";

    public static AbrirAplicacion enElNavegador() {
        return instrumented(AbrirAplicacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_SIIGO)
        );
    }
}
