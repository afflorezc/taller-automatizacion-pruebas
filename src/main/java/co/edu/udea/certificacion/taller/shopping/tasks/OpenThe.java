package co.edu.udea.certificacion.taller.shopping.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import co.edu.udea.certificacion.taller.shopping.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;

public class OpenThe implements Task{

    private HomePage homePage;
 
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));
        
    }

    public static OpenThe browser(){
        return Tasks.instrumented(OpenThe.class);
    }

}
