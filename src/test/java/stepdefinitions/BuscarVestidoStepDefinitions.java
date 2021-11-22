package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import model.EnviarCorreoModel;
import model.IniciarSesionTiendaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import questions.CorreoEnviadoQuestion;
import tasks.AbrirPaginaTienda;
import tasks.ComprarVestido;
import tasks.EnviarCorreo;
import tasks.IniciarSesionTienda;

import java.util.List;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.startsWith;

public class BuscarVestidoStepDefinitions {


    @Managed(driver = "chrome")
    private WebDriver navegador;

    private Actor megan = Actor.named("Megan");

    @Before
    public void setUp(){
        megan.can(BrowseTheWeb.with(navegador));
    }

    @Dado("^El usuario quiere comprar el vestido mas caro$")
    public void elUsuarioQuiereComprarElVestidoMasCaro(List<IniciarSesionTiendaModel> modelo) throws Exception {
        megan.wasAbleTo(AbrirPaginaTienda.en());
        navegador.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        megan.wasAbleTo(IniciarSesionTienda.con(modelo.get(0)));

    }
    @Cuando("^el usuario quiere enviar el pago por correo$")
    public void elUsuarioQuiereEnviarElPagoPorCorreo(List<EnviarCorreoModel> modelo) throws Exception {
        megan.wasAbleTo(ComprarVestido.enTienda());
        megan.wasAbleTo(EnviarCorreo.enviar(modelo.get(0),navegador));
    }
    @Entonces("^el usuario envia un correo(.*)$")
    public void elUsuarioEnviaUnCorreo(String mensaje) throws Exception {
        megan.should(eventually(seeThat(CorreoEnviadoQuestion.enviado(), startsWith(mensaje))));
    }
}
