package co.edu.udea.certificacion.taller.shopping.interactions;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterTheUser implements Interaction{

    private final String firstName;
    private final String lastName;
    private final String companyName;

    public EnterTheUser(String firstName, String lastName,String  companyName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.firstName)
            .into(FIRST_NAME_FIELD));

        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.lastName)
            .into(LAST_NAME_FIELD));

        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.companyName)
            .into(COMPANY_FIELD));
    }

    public static EnterTheUser personalInformation(String firstName, String lastName, String companyName){
        return Tasks.instrumented(EnterTheUser.class, firstName, lastName, companyName);
    }

}
