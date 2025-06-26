package co.com.siigo.automation.tasks.front;

import co.com.siigo.automation.interactions.front.WaitStatic;
import co.com.siigo.automation.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.automation.userinterfaces.DashboardPage.TITULO_INICIO;
import static co.com.siigo.automation.userinterfaces.LoginPage.BTN_INGRESAR;
import static co.com.siigo.automation.userinterfaces.LoginPage.TXT_BANNER;
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
        // Hacer un espera estática si es necesario
        actor.attemptsTo(WaitUntil.the(TXT_BANNER, isVisible()).forNoMoreThan(30).seconds());
        LoginPage.getCorreoField().sendKeys(correoElectronico);
        LoginPage.getContrasenaField().sendKeys(contrasena);
        actor.attemptsTo(Click.on(BTN_INGRESAR));
        actor.attemptsTo(WaitUntil.the(TITULO_INICIO, isVisible()).forNoMoreThan(30).seconds());
    }
}
