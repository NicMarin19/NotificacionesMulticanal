package co.unilibre.notificaciones.modelo;
import java.util.*;
public class Usuario  {
    private final String nombre, correo, telefono;
    private final Set<String> preferencias;
    public Usuario(String nombre,String correo,String telefono,Set<String> preferencias) {
        this.nombre=nombre;
        this.correo=correo;
        this.telefono=telefono;
        this.preferencias=new HashSet<>(preferencias);
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public Set<String> getPreferencias() {
        return Collections.unmodifiableSet(preferencias);
    }
}
