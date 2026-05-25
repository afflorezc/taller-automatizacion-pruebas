package co.edu.udea.certificacion.taller.shopping.interactions;

import co.edu.udea.certificacion.taller.shopping.models.InputDate;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class EnterTheBirthDate implements Interaction{

    private final InputDate birthDate;

    public EnterTheBirthDate(InputDate birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delay.betweenSteps());
        SelectFromOptions.byVisibleText(Integer.toString(this.birthDate.getMonthDay()))
                         .from(BIRTH_DAY_SELECT);

        actor.attemptsTo(Delay.betweenSteps());
        SelectFromOptions.byVisibleText(this.birthDate.getMonthName())
                         .from(BIRTH_MONTH_SELECT);

        actor.attemptsTo(Delay.betweenSteps());
        SelectFromOptions.byVisibleText(Integer.toString(this.birthDate.getYear()))
                         .from(BIRTH_YEAR_SELECT);
    }

    public static EnterTheBirthDate ofUser(InputDate birthDate){
        return Tasks.instrumented(EnterTheBirthDate.class, birthDate);
    }

}
