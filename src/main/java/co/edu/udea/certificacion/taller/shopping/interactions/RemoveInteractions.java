package co.edu.udea.certificacion.taller.shopping.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Evaluate;

public class RemoveInteractions implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Evaluate.javascript(
        "document.querySelectorAll('iframe').forEach(e => e.remove());" +
                "document.querySelectorAll('ins.adsbygoogle').forEach(e => e.remove());"
            )
        );
    }

    public static RemoveInteractions removeAdds(){
        return Tasks.instrumented(RemoveInteractions.class);
    }

}
