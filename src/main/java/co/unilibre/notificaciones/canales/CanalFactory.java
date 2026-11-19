package co.unilibre.notificaciones.canales;
public class CanalFactory  {
    public Canal crear(String nombre) {
        return switch(nombre.toLowerCase()) {
            case "correo"->new CorreoAdapter();
            case "sms"->new SmsAdapter();
            case "chat/push","chat","push"->new ChatAdapter();
            default->throw new IllegalArgumentException("Canal desconocido: "+nombre);
        }
        ;
    }
}
