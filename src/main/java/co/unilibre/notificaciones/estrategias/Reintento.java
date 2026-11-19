package co.unilibre.notificaciones.estrategias;
public class Reintento  {
    public boolean enviarConReintento(java.util.function.BooleanSupplier envio,int maxIntentos) {
        for(int i=0;i<maxIntentos;i++)if(envio.getAsBoolean())return true;
        return false;
    }
}
