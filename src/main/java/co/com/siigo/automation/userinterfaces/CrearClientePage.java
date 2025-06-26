package co.com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearClientePage {

    public static final Target TIPO_PERSONA_SHADOW_ROOT = Target.the("Person type shadow root")
            .locatedBy("siigo-card-web:nth-child(1) siigo-dropdownlist-web:nth-child(1)");
    public static final Target TIPO_PERSONA_LIST = Target.the("Person type list")
            .locatedBy(".mdc-select__anchor.mdc-ripple-upgraded");


    public static final Target TIPO_IDENTIFICACION_SHADOW_ROOT = Target.the("Person type shadow root")
            .locatedBy("siigo-card-web:nth-child(1) siigo-identification-input-web:nth-child(1)");
    public static final Target TIPO_IDENTIFICACION_INPUT = Target.the("Person type list")
            .locatedBy("#identification > input");

    public static final Target NOMBRES_SHADOW_ROOT = Target.the("Person type shadow root")
            .locatedBy("siigo-textfield-web[required='true'][maxlength='50'].hydrated");
    public static final Target NOMBRE_INPUT = Target.the("Person type list")
            .locatedBy(".mdc-text-field__input");


    public static final Target APELLIDO_SHADOW_ROOT = Target.the("Person type shadow root")
            .locatedBy("div > div > div:nth-child(1) > div.column.is-7 > div:nth-child(2) > siigo-textfield-web");
    public static final Target APELLIDO_INPUT = Target.the("Person type list")
            .locatedBy(".mdc-text-field__input");

    public static final Target PRUEBA = Target.the("Person type shadow root")
            .locatedBy("siigo-textfield-web:nth-child(1):nth(2)");
    public static final Target PRUEBA_IMPUT = Target.the("Person type list")
            .locatedBy(".mdc-text-field__ripple");




}

