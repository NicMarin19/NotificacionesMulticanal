package co.unilibre.notificaciones.modelo;
import java.time.LocalDateTime;
public class Mensaje  {
    private final String usuario, tipo, contenido, canal, estado;
    private final LocalDateTime fecha;
    public Mensaje(String usuario,String tipo,String contenido,String canal,String estado) {
        this.usuario=usuario;
        this.tipo=tipo;
        this.contenido=contenido;
        this.canal=canal;
        this.estado=estado;
        fecha=LocalDateTime.now();
    }
    public String toString() {
        return fecha.toString().replace('T',' ') + " | "+usuario+" | "+tipo+" | "+canal+" | "+estado+" | "+contenido;
    }
    public String getEstado() {
        return estado;
    }
    public String getCanal() {
        return canal;
    }
}
