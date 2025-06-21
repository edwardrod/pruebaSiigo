package co.com.siigo.automation.tasks.front;

import static co.com.siigo.automation.userinterfaces.DashboardPage.TITULO_INICIO;
import static co.com.siigo.automation.userinterfaces.LoginPage.CAMPO_CORREO_ELECTRONICO;
import static co.com.siigo.automation.userinterfaces.LoginPage.CAMPO_CONTRASENA;
import static co.com.siigo.automation.userinterfaces.LoginPage.BOTON_CONTINUAR;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesion implements Task {

    private final String correoElectronico;
    private final String contrasena;

    public IniciarSesion(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public static IniciarSesion conUsuarioYContrasena(String usuario, String contrasena) {
        return instrumented(IniciarSesion.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CAMPO_CORREO_ELECTRONICO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(correoElectronico).into(CAMPO_CORREO_ELECTRONICO),
                Enter.theValue(contrasena).into(CAMPO_CONTRASENA),
                Click.on(BOTON_CONTINUAR),
                WaitUntil.the(TITULO_INICIO, isVisible()).forNoMoreThan(10).seconds());
    }
}
