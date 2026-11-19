package co.unilibre.notificaciones.estrategias;
import co.unilibre.notificaciones.modelo.Usuario;
import java.util.List;
public class Urgente implements EstrategiaEnvio  {
    public List<String> seleccionarCanales(Usuario u) {
        return List.of("Correo","SMS","Chat/Push");
    }
}
