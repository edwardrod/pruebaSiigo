package co.com.siigo.automation.interactions.front;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ClickShadowRoot implements Interaction {
    private final Target shadowRootTarget; // Target para el shadow root
    private final Target elementTarget; // Target del elemento dentro del shadow root

    public ClickShadowRoot(Target shadowRootTarget, Target elementTarget) {
        this.shadowRootTarget = shadowRootTarget;
        this.elementTarget = elementTarget;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //Obtiene el WebDriver actual y lo convierte en JavascriptExecutor, para ejecutar scripts de JS directamente.
        WebDriver driver = Serenity.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Acceder al shadow root
        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowRootTarget.resolveFor(actor));

        // Interactuar con el elemento dentro del shadow root
        js.executeScript("return arguments[0].querySelector(arguments[1]).click();",
                shadowRoot, elementTarget.getCssOrXPathSelector());
    }

    public static ClickShadowRoot with(Target shadowRootTarget, Target elementTarget) {
        return Tasks.instrumented(ClickShadowRoot.class, shadowRootTarget, elementTarget);
    }
}

