package co.com.siigo.automation.interactions.front;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EnterTextShadowRoot implements Interaction {
    private final Target shadowRootTarget; // Target para el shadow root
    private final String texto; // Texto a ingresar
    private final Target elementTarget; // Target del elemento dentro del shadow root

    public EnterTextShadowRoot(Target shadowRootTarget, Target elementTarget, String texto) {
        this.shadowRootTarget = shadowRootTarget;
        this.elementTarget = elementTarget;
        this.texto = texto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Acceder al shadow root
        Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowRootTarget.resolveFor(actor));

        // Ingresar texto en el elemento dentro del shadow root
        js.executeScript("var inputElement = arguments[0].querySelector(arguments[1]);" +
                        "inputElement.value = arguments[2];" +
                        "inputElement.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "inputElement.dispatchEvent(new Event('change', { bubbles: true }));",
                shadowRoot, elementTarget.getCssOrXPathSelector(), texto);
    }

    public static EnterTextShadowRoot with(Target shadowRootTarget, Target elementTarget, String texto) {
        return Tasks.instrumented(EnterTextShadowRoot.class, shadowRootTarget, elementTarget, texto);
    }
}

