package co.com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target CAMPO_CORREO_ELECTRONICO = Target.the("Campo de correo electronico")
            .located(By.id("siigoSignInName"));

    public static final Target CAMPO_CONTRASENA = Target.the("Campo de Contraseña")
            .located(By.id("siigoPassword"));

    public static final Target BOTON_CONTINUAR = Target.the("Boton Continuar")
            .located(By.id("siigoNext"));
}
