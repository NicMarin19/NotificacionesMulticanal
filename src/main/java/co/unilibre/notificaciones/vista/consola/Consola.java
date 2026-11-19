package co.unilibre.notificaciones.vista.consola;
import co.unilibre.notificaciones.nucleo.*;
import co.unilibre.notificaciones.modelo.*;
import java.util.*;
public class Consola  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        FacadeNotificaciones f=new FacadeNotificaciones();
        f.registrarUsuario(new Usuario("Nicolas","nicolas@correo.com","3001234567",Set.of("Correo")));
        f.registrarUsuario(new Usuario("Bryan","bryan@correo.com","3101234567",Set.of("SMS")));
        int op;
        do {
            System.out.println("\n=== NOTIFICACIONES MULTICANAL ===\n1. Registrar usuario\n2. Enviar notificacion\n3. Ver historial\n4. Ver usuarios\n0. Salir");
            op=leer(sc,"Opcion: ");
            switch(op) {
                case 1-> {
                    System.out.print("Nombre: ");
                    String n=sc.nextLine();
                    System.out.print("Correo: ");
                    String c=sc.nextLine();
                    System.out.print("Telefono: ");
                    String t=sc.nextLine();
                    System.out.print("Preferencia (Correo/SMS/Chat): ");
                    String p=sc.nextLine();
                    f.registrarUsuario(new Usuario(n,c,t,Set.of(p)));
                    System.out.println("Usuario registrado.");
                }
                case 2-> {
                    System.out.print("Usuario: ");
                    String n=sc.nextLine();
                    System.out.print("Tipo (Urgente/Informativo): ");
                    String tipo=sc.nextLine();
                    System.out.print("Mensaje (puede usar {nombre}): ");
                    String m=sc.nextLine();
                    f.enviar(n,tipo,m,Map.of("nombre",n));
                    System.out.println("Notificacion procesada.");
                }
                case 3->f.historial().forEach(System.out::println);
                case 4->f.usuarios().forEach(u->System.out.println(u.getNombre()+" | "+u.getCorreo()+" | "+u.getTelefono()+" | "+u.getPreferencias()));
            }
        }
        while(op!=0);
    }
    private static int leer(Scanner s,String m) {
        System.out.print(m);
        try {
            return Integer.parseInt(s.nextLine());
        }
        catch(Exception e) {
            return -1;
        }
    }
}
