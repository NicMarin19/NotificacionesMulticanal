package co.unilibre.notificaciones.estrategias;
import co.unilibre.notificaciones.modelo.Usuario;
import java.util.List;
public interface EstrategiaEnvio  {
    List<String> seleccionarCanales(Usuario usuario);
}
