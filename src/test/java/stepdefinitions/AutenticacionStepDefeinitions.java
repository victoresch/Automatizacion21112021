package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import model.IniciarSesionTiendaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import questions.AutenticacionExitosaQuestion;
import questions.AutenticacionFallidaQuestion;
import tasks.AbrirPaginaTienda;
import tasks.IniciarSesionTienda;

import java.util.List;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class AutenticacionStepDefeinitions {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor megan = Actor.named("Megan");

    @Before
    public void setUp(){
        megan.can(BrowseTheWeb.with(navegador));
    }

    @Dado("^El que el actor cuenta con los datos de autenticacion$")
    public void elQueElActorCuentaConLosDatosDeAutenticacion() throws Exception {
        megan.wasAbleTo(AbrirPaginaTienda.en());
    }

    @Cuando("^el usuario el realiza la autenticacion$")
    public void elUsuarioElRealizaLaAutenticacion(List<IniciarSesionTiendaModel> modelo) throws Exception {
        navegador.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        megan.wasAbleTo(IniciarSesionTienda.con(modelo.get(0)));
    }

    @Entonces("^el debe ver el titulo(.*)$")
    public void elDebeVerLaInformacionDelUsuario(String mensaje) throws Exception {
        megan.should(eventually(seeThat(AutenticacionExitosaQuestion.confirmacionAutenticacion(), equalToIgnoringWhiteSpace(mensaje))));
    }

    @Dado("^El que el actor cuenta con los datos de autenticacion erroneos$")
    public void elQueElActorCuentaConLosDatosDeAutenticacionErroneos() throws Exception {
        megan.wasAbleTo(AbrirPaginaTienda.en());
    }

    @Entonces("^el debe ver el error (.*)$")
    public void elDebeVerElErrorEnUnMENSAJE(String mensaje) throws Exception {
        megan.should(eventually(seeThat(AutenticacionFallidaQuestion.confirmacionAutenticacion(), equalToIgnoringWhiteSpace(mensaje))));
    }
}
