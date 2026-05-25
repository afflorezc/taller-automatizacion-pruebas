package co.edu.udea.certificacion.taller.shopping.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

public class OpenThe implements Task{

    private final String AUTOMATION_EXERCISE_PAGE = "https://automationexercise.com/";
 
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed(AUTOMATION_EXERCISE_PAGE));
        
    }

    public static OpenThe browser(){
        return Tasks.instrumented(OpenThe.class);
    }

}
