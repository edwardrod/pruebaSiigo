package co.com.siigo.automation.questions.front;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.automation.userinterfaces.DashboardPage.TITULO_INICIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidacionLoginExitosa {

    public static Question<Boolean> esVisibleElDashboard() {

        return Visibility.of(TITULO_INICIO).asBoolean();

    }
}
