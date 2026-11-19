package co.unilibre.notificaciones.nucleo;

import co.unilibre.notificaciones.modelo.*;
import co.unilibre.notificaciones.canales.*;
import co.unilibre.notificaciones.estrategias.*;
import java.util.*;

public class FacadeNotificaciones {

    private final Map<String, Usuario> usuarios = new LinkedHashMap<>();
    private final List<Mensaje> historial = new ArrayList<>();
    private final CanalFactory factory = new CanalFactory();
    private final Reintento reintento = new Reintento();

    public void registrarUsuario(Usuario u) {
        usuarios.put(u.getNombre().toLowerCase(), u);
    }

    public List<Usuario> usuarios() {
        return List.copyOf(usuarios.values());
    }

    public Usuario buscar(String nombre) {
        return usuarios.get(nombre.toLowerCase());
    }

    public List<Mensaje> historial() {
        return List.copyOf(historial);
    }

    public List<Mensaje> enviar(String nombre, String tipo, String plantilla,
                                Map<String, String> variables) {
        Usuario u = buscar(nombre);

        if (u == null) {
            throw new IllegalArgumentException("No existe ese usuario.");
        }

        String texto = plantilla;
        for (var e : variables.entrySet()) {
            texto = texto.replace("{" + e.getKey() + "}", e.getValue());
        }

        EstrategiaEnvio estrategia = tipo.equalsIgnoreCase("Urgente")
                ? new Urgente()
                : new Informativo();

        List<Mensaje> nuevos = new ArrayList<>();

        // Variable final para poder usarla dentro de la lambda.
        final String mensajeFinal = texto;

        for (String canalNombre : estrategia.seleccionarCanales(u)) {
            Canal canal = factory.crear(canalNombre);

            String destino = canalNombre.equals("Correo")
                    ? u.getCorreo()
                    : u.getTelefono();

            boolean ok = reintento.enviarConReintento(
                    () -> canal.enviar(destino, mensajeFinal),
                    2
            );

            Mensaje registro = new Mensaje(
                    u.getNombre(),
                    tipo,
                    mensajeFinal,
                    canalNombre,
                    ok ? "Enviado" : "Fallido"
            );

            historial.add(registro);
            nuevos.add(registro);
        }

        return nuevos;
    }
}
