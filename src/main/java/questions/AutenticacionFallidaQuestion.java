package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.InicarSesionTiendaUi;

public class AutenticacionFallidaQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(InicarSesionTiendaUi.LBL_AUTHENTICATION_FAILED).viewedBy(actor).asString();
    }
    public static AutenticacionFallidaQuestion confirmacionAutenticacion (){
        return new AutenticacionFallidaQuestion();
    }
}
