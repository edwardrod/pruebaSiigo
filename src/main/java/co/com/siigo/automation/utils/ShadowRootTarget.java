package co.com.siigo.automation.utils;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.*;

public class ShadowRootTarget {
    public static WebDriver driver = BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver();
    private ShadowRootTarget() {
        // Constructor privado para que no puedan instanciar esta clase
    }

    public static SearchContext getShadowRoot(By shadowHostLocator) {
        WebElement shadowHost = driver.findElement(shadowHostLocator);
        return (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", shadowHost);
    }



}