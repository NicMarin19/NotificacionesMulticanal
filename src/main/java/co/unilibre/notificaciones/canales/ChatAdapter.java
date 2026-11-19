package co.unilibre.notificaciones.canales;
public class ChatAdapter implements Canal  {
    private final CanalSimulado servicio=new CanalSimulado("Chat/Push");
    public String getNombre() {
        return "Chat/Push";
    }
    public boolean enviar(String destino,String mensaje) {
        return servicio.enviar(destino,mensaje);
    }
}
