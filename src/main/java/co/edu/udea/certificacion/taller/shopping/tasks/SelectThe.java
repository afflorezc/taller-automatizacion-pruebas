package co.edu.udea.certificacion.taller.shopping.tasks;

import co.edu.udea.certificacion.taller.shopping.interactions.ViewProduct;
import co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductsPage;
import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class SelectThe implements Task{

    private static List<WebElementFacade> buttons;

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        buttons = ProductsPage.ALL_VIEW_PRODUCT_BUTTONS.resolveAllFor(actor);
        WebElementFacade button = RandomValues.randomItem(buttons);
        
        actor.attemptsTo(ViewProduct.details(button));

    }

    public static SelectThe product(){
        return Tasks.instrumented(SelectThe.class);
    }

}
