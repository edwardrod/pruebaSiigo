package co.com.siigo.automation.interactions.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectProduc implements Interaction {

    private Target listaTarget;
    private  String item;

    public SelectProduc( Target listaTarget, String item) {
        this.listaTarget = listaTarget;
        this.item = item;
    }

    public static SelectProduc items(Target listaTarget, String item){
        return Tasks.instrumented(SelectProduc.class,listaTarget,item);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            List<WebElement> listopcion = listaTarget.resolveFor(actor).findElements(By.xpath(item));
            listopcion.get(0).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}