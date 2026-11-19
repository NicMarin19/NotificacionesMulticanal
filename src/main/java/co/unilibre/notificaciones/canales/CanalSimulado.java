package co.unilibre.notificaciones.canales;
public class CanalSimulado  {
    private final String nombre;
    public CanalSimulado(String nombre) {
        this.nombre=nombre;
    }
    public boolean enviar(String destino,String mensaje) {
        System.out.println("["+nombre+"] Para: "+destino+" | "+mensaje);
        return true;
    }
}
