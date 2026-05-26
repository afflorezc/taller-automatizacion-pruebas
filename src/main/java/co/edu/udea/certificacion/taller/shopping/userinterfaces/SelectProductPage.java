package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectProductPage {
    public static final Target PRODUCT_QUANTITY_INPUT =
            Target.the("Input de cantidad de producto")
                    .located(By.id("quantity"));

    public static final Target ADD_PRODUCT_TO_CART_BUTTON =
            Target.the("Boton de añadir el producto al carrito")
                    .located(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
                    
}                                                   