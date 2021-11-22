package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import ui.UrlTienda;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPaginaTienda implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(new UrlTienda()));
    }

   public static AbrirPaginaTienda en (){
        return instrumented(AbrirPaginaTienda.class);
   }
}
