package co.edu.udea.certificacion.taller.shopping.interactions;

import co.edu.udea.certificacion.taller.shopping.models.User;
import static co.edu.udea.certificacion.taller.shopping.userinterfaces.RegistrationDetailsPage.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class EnterTheAddress implements Interaction{

    private final User user;

    public EnterTheAddress(User user){
        this.user = user;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getAddress())
            .into(ADDRESS_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getAddress2())
            .into(ADDRESS2_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        SelectFromOptions.byVisibleText(this.user.getLocationData().getCountry())
                         .from(COUNTRY_SELECT);
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getLocationData().getState())
            .into(STATE_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getLocationData().getCity())
            .into(CITY_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getZipCode())
            .into(ZIPCODE_FIELD));
        
        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(
            this.user.getMobileNumber())
            .into(MOBILE_NUMBER_FIELD));
    }

    public static EnterTheAddress ofTheUser(User user){
        return Tasks.instrumented(EnterTheAddress.class, user);
    }

}
