package co.com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    public static final Target TITULO_INICIO= Target.the("Titulo de inicio")
            .located(By.xpath("//div[contains(text(),'Inicio')]"));

    public static final Target CLIENTES_BUTTON = Target.the("Clientes button")
            .locatedBy("//p[contains(text(),'Crea un Tercero')]");
}