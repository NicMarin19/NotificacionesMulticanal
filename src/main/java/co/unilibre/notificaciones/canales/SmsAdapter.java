package co.unilibre.notificaciones.canales;
public class SmsAdapter implements Canal  {
    private final CanalSimulado servicio=new CanalSimulado("SMS");
    public String getNombre() {
        return "SMS";
    }
    public boolean enviar(String destino,String mensaje) {
        return servicio.enviar(destino,mensaje);
    }
}
