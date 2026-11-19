package co.unilibre.notificaciones.canales;
public class CorreoAdapter implements Canal  {
    private final CanalSimulado servicio=new CanalSimulado("Correo");
    public String getNombre() {
        return "Correo";
    }
    public boolean enviar(String destino,String mensaje) {
        return servicio.enviar(destino,mensaje);
    }
}
