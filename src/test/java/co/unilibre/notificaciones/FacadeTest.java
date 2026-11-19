package co.unilibre.notificaciones;
import co.unilibre.notificaciones.nucleo.*;
import co.unilibre.notificaciones.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class FacadeTest  {
    @Test void urgenteUsaTresCanales() {
        FacadeNotificaciones f=new FacadeNotificaciones();
        f.registrarUsuario(new Usuario("Ana","a@b.com","123",Set.of("Correo")));
        assertEquals(3,f.enviar("Ana","Urgente","Hola {nombre}",Map.of("nombre","Ana")).size());
    }
    @Test void informativoRespetaPreferencia() {
        FacadeNotificaciones f=new FacadeNotificaciones();
        f.registrarUsuario(new Usuario("Ana","a@b.com","123",Set.of("SMS")));
        assertEquals(1,f.enviar("Ana","Informativo","Hola",Map.of()).size());
    }
    @Test void usuarioNoRegistradoFalla() {
        FacadeNotificaciones f=new FacadeNotificaciones();
        assertThrows(IllegalArgumentException.class,()->f.enviar("No","Urgente","Hola",Map.of()));
    }
}
