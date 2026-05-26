package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage extends PageObject {
    public static final Target CART_ELEMENTS =
            Target.the("Elementos del carrito")
                    .located(By.cssSelector("#cart_info_table tbody tr"));

    public static final Target QUANTITY_OF_FIRST_PRODUCT =
            Target.the("Elemento que indica la cantidad del producto")
                    .located(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
}
