package co.edu.udea.certificacion.taller.shopping.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.shopping.userinterfaces.SelectProductPage.*;

public class EnterTheQuantity  implements Interaction {
    private final int quantity;

    public EnterTheQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Delay.betweenSteps());
        actor.attemptsTo(Enter.theValue(String.valueOf(quantity))
                .into(PRODUCT_QUANTITY_INPUT));

    }

    public static EnterTheQuantity ofProducts(int quantity){
        return Tasks.instrumented(EnterTheQuantity.class, quantity);
    }

}
