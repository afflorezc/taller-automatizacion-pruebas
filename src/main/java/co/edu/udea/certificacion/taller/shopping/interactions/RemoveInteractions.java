package co.edu.udea.certificacion.taller.shopping.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Evaluate;

public class RemoveInteractions implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Evaluate.javascript("""
            document.querySelectorAll(
                'iframe, .adsbygoogle, .advertisement, .grippy-host'
            ).forEach(el => el.remove());
            """)
        );

        String currentUrl = BrowseTheWeb.as(actor)
            .getDriver()
            .getCurrentUrl();

        if(currentUrl.contains("#google_vignette")) {
            BrowseTheWeb.as(actor)
                .getDriver()
                .navigate()
                .to(currentUrl.replace("#google_vignette", ""));
        }
    }

    public static RemoveInteractions removeAdds(){
        return Tasks.instrumented(RemoveInteractions.class);
    }

}
