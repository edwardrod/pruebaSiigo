package co.com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    public static final Target TITULO_INICIO= Target.the("Titulo de inicio")
            .located(By.xpath("//div[contains(text(),'Inicio')]"));

    public static final Target HOME_LABEL = Target.the("Home label")
            .locatedBy("//div[@class='menu-tab-title']");
    public static final Target HEADER_MOLECULE_SHADOW_ROOT = Target.the("Header molecule shadow root")
            .located(By.cssSelector("generalheader > siigo-header-molecule"));
    public static final Target CREATE_SHADOW_ROOT = Target.the("Create button")
            .locatedBy("siigo-button-atom[data-id='header-create-button']");
    public static final Target CLIENTES_BUTTON = Target.the("Clientes button")
            .locatedBy("siigo-header-create-button-dropdown a[data-value='Clientes']");
}