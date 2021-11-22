package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.InicarSesionTiendaUi;

public class AutenticacionExitosaQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(InicarSesionTiendaUi.LBL_MY_ACCOUNT).viewedBy(actor).asString();
    }
    public static AutenticacionExitosaQuestion confirmacionAutenticacion (){
        return new AutenticacionExitosaQuestion();
    }
}
