package co.edu.udea.certificacion.taller.shopping.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class Delay implements Interaction{

    private static final EnvironmentVariables ENV =
        SystemEnvironmentVariables
                .createEnvironmentVariables();

    private static final long DELAY =
        Long.parseLong(
            ENV.getProperty(
                    "custom.debug.delay",
                    "0"
            )
        );

    public static Delay betweenSteps() {
        return Tasks.instrumented(Delay.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       try {
            Thread.sleep(DELAY);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new RuntimeException(e);
        }
    }
}
