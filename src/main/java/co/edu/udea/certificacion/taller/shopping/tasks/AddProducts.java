package co.edu.udea.certificacion.taller.shopping.tasks;

import java.util.List;

import co.edu.udea.certificacion.taller.shopping.interactions.AddToCart;
import co.edu.udea.certificacion.taller.shopping.interactions.Delay;
import co.edu.udea.certificacion.taller.shopping.userinterfaces.ProductsPage;
import co.edu.udea.certificacion.taller.shopping.utils.RandomValues;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AddProducts implements Task{

    private static List<WebElementFacade> buttons;
    private final int quantity;
    private final int times;

    public AddProducts(int quantity, int times){
        this.quantity = quantity;
        this.times = times;
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
       buttons = ProductsPage.ALL_BUY_BUTTONS.resolveAllFor(actor);

       for(int i=0; i < quantity; i++) {
            WebElementFacade product = RandomValues.randomItem(buttons);
            
            for(int j=0; j < times; j++){
                actor.attemptsTo(Delay.betweenSteps());
                actor.attemptsTo(AddToCart.theProduct(product));
            }
            
            buttons.remove(product);
        }
    }

    public static AddProducts fromProductPage(int quantity){
        return Tasks.instrumented(AddProducts.class, quantity, 1);
        
    }

    public static AddProducts multipleTimesFromProductPage(int times){
        return Tasks.instrumented(AddProducts.class, 1, times);
    }

}
