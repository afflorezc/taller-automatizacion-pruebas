package co.edu.udea.certificacion.taller.shopping.tasks;

import co.edu.udea.certificacion.taller.shopping.interactions.EnterTheUserName;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterBasicSignUp implements Task{

    private final String name;
    private final String email;
    private final Target field;

    EnterBasicSignUp(String name, String email, Target field){
        this.name = name;
        this.email = email;
        this.field = field;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterTheUserName.ofClient(name, email));
        actor.attemptsTo(
            WaitUntil.the(
                this.field,
                isVisible()
            ).forNoMoreThan(10).seconds()
        );
    }

    public static EnterBasicSignUp withExistingEmail(String name, String email){
        return Tasks.instrumented(EnterBasicSignUp.class,name, email, REPEATED_EMAIL_MSG);
    }

    public static EnterBasicSignUp withEmptyFields(String name, String email){
        return Tasks.instrumented(EnterBasicSignUp.class, name, email, SIGN_UP_BUTTON);
    }

}
