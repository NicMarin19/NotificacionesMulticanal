package co.unilibre.notificaciones.estrategias;
import co.unilibre.notificaciones.modelo.Usuario;
import java.util.*;
public class Informativo implements EstrategiaEnvio  {
    public List<String> seleccionarCanales(Usuario u) {
        return u.getPreferencias().stream().map(s->s.equalsIgnoreCase("chat")||s.equalsIgnoreCase("push")?"Chat/Push":s.equalsIgnoreCase("sms")?"SMS":"Correo").distinct().toList();
    }
}
