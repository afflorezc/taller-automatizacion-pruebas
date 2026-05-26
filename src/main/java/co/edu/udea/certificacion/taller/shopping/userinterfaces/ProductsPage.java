package co.edu.udea.certificacion.taller.shopping.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("/products")
public class ProductsPage extends PageObject {

    public static final Target CATEGORY_TEXT = Target.the(
        "Title for categories")
        .locatedBy("/html/body/section[2]/div/div/div[1]/div/h2");
        
    public static final Target ALL_BUY_BUTTONS =
            Target.the("Todos los botones de compra")
                    .located(By.cssSelector(".single-products > .productinfo a"));

    public static final Target ALL_VIEW_PRODUCT_BUTTONS =
            Target.the("Todos los botones de ver producto")
                    .located(By.cssSelector(".choose a"));

}
