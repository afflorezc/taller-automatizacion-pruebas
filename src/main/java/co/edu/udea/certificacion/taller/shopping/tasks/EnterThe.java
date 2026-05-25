package co.edu.udea.certificacion.taller.shopping.tasks;

import co.edu.udea.certificacion.taller.shopping.interactions.RegisterThe;
import co.edu.udea.certificacion.taller.shopping.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnterThe implements Task{

    private final User user;

    public EnterThe(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RegisterThe.client(this.user));
    }

    public static EnterThe signupInformation(User userData){
        return Tasks.instrumented(EnterThe.class, userData);
    }

}
