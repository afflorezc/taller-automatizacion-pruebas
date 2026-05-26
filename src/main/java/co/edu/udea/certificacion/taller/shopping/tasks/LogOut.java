package co.edu.udea.certificacion.taller.shopping.tasks;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.HomePage.*;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SignUpLoginPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.edu.udea.certificacion.taller.shopping.interactions.RemoveInteractions;

public class LogOut implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        WaitUntil.the(
            LOGGED_AS_TEXT, 
            isVisible()
        ).forNoMoreThan(10).seconds();
        
        actor.attemptsTo(Click.on(LOGOUT_LINK));

        WaitUntil.the(
            NAME_FIELD, 
            isVisible()
        ).forNoMoreThan(10).seconds();

        actor.attemptsTo(RemoveInteractions.removeAdds());

    }

    public static LogOut theUser(){
        return Tasks.instrumented(LogOut.class);
    }

}
