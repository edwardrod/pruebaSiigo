package co.com.siigo.automation.interactions.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WaitStatic implements Interaction {
    private final int millis;

    static final Logger LOGGER = LoggerFactory.getLogger(WaitStatic.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(millis);
            LOGGER.info("----Termino espera----");
        } catch (InterruptedException | CommandLine.ExecutionException e) {
            LOGGER.debug("Interrupted: {} {}", e, Level.WARN);
            Thread.currentThread().interrupt();
        }
    }

    public WaitStatic(int millis) {
        this.millis = millis;
    }

    public static WaitStatic milliseconds(int time) {
        return Tasks.instrumented(WaitStatic.class, time);
    }

}