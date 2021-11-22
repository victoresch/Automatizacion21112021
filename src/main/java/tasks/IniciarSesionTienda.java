package tasks;

import model.IniciarSesionTiendaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import ui.InicarSesionTiendaUi;
import ui.IniciarSesionCorreoUi;

import java.lang.ref.WeakReference;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionTienda implements Task {


    IniciarSesionTiendaModel modelo;

    public IniciarSesionTienda(IniciarSesionTiendaModel modelo) {
        this.modelo = modelo;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(modelo.getCorreoUsuario()).into(InicarSesionTiendaUi.LBL_EMAIL),
                         Enter.theValue(modelo.getClaveUsuario()).into(InicarSesionTiendaUi.LBL_PASSWORD),
                         Click.on(InicarSesionTiendaUi.BTN_SIGN_IN));
    }
    public static IniciarSesionTienda con(IniciarSesionTiendaModel modelo){
        return instrumented(IniciarSesionTienda.class,modelo);
    }
}
