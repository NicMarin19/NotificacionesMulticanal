package co.unilibre.notificaciones.vista.gui;
import co.unilibre.notificaciones.nucleo.*;
import co.unilibre.notificaciones.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Ventana extends JFrame  {
    private final FacadeNotificaciones f=new FacadeNotificaciones();
    private final JTextArea historial=new JTextArea();
    private final JTextField nombre=new JTextField(),correo=new JTextField(),telefono=new JTextField(),mensaje=new JTextField();
    private final JComboBox<String> preferencia=new JComboBox<>(new String[] {
        "Correo","SMS","Chat/Push"
    }
    ),tipo=new JComboBox<>(new String[] {
        "Informativo","Urgente"
    }
    );
    public Ventana() {
        super("Sistema de Notificaciones Multicanal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        f.registrarUsuario(new Usuario("Nicolas","nicolas@correo.com","3001234567",Set.of("Correo")));
        f.registrarUsuario(new Usuario("Bryan","bryan@correo.com","3101234567",Set.of("SMS")));
        JPanel formulario=new JPanel(new GridLayout(0,2,8,8));
        formulario.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        formulario.add(new JLabel("Nombre usuario"));
        formulario.add(nombre);
        formulario.add(new JLabel("Correo"));
        formulario.add(correo);
        formulario.add(new JLabel("Telefono"));
        formulario.add(telefono);
        formulario.add(new JLabel("Canal preferido"));
        formulario.add(preferencia);
        formulario.add(new JLabel("Tipo"));
        formulario.add(tipo);
        formulario.add(new JLabel("Mensaje"));
        formulario.add(mensaje);
        JButton registrar=new JButton("Registrar usuario"),enviar=new JButton("Enviar notificacion");
        formulario.add(registrar);
        formulario.add(enviar);
        historial.setEditable(false);
        add(formulario,BorderLayout.NORTH);
        add(new JScrollPane(historial),BorderLayout.CENTER);
        registrar.addActionListener(e-> {
            if(nombre.getText().isBlank())return;f.registrarUsuario(new Usuario(nombre.getText(),correo.getText(),telefono.getText(),Set.of((String)preferencia.getSelectedItem())));historial.append("Usuario registrado: "+nombre.getText()+"\n");
        }
        );
        enviar.addActionListener(e-> {
            try {
                f.enviar(nombre.getText(),(String)tipo.getSelectedItem(),mensaje.getText(),Map.of("nombre",nombre.getText()));actualizar();
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        );
    }
    private void actualizar() {
        historial.setText("");
        f.historial().forEach(m->historial.append(m+"\n"));
    }
    public static void main(String[]a) {
        SwingUtilities.invokeLater(()->new Ventana().setVisible(true));
    }
}
