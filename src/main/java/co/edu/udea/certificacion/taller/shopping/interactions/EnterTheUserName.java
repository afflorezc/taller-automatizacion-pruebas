package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterTheUserName implements Interaction{

    private final String name;
    private final String email;

    public EnterTheUserName(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(this.name).into(NAME_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(this.email).into(EMAIL_FIELD));

        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Click.on(SIGN_UP_BUTTON));
    }

    public static EnterTheUserName ofClient(String name, String email){
        return Tasks.instrumented(EnterTheUserName.class, name, email);
    }
}
