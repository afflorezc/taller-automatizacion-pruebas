package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.edu.udea.certificacion.taller.shopping.exceptions.EmptyFieldsInSignUpException;


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

        if(this.name.isEmpty() || this.email.isEmpty()){
            return;
        }

        WaitUntil.the(
            PASSWORD_FIELD, 
            isVisible()
        ).forNoMoreThan(10).seconds();

        actor.attemptsTo(RemoveInteractions.removeAdds());
    }

    public static EnterTheUserName ofClient(String name, String email){
        return Tasks.instrumented(EnterTheUserName.class, name, email);
    }
}
