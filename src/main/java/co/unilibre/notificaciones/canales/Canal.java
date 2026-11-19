package co.unilibre.notificaciones.canales;
public interface Canal  {
    String getNombre();
    boolean enviar(String destino,String mensaje);
}
