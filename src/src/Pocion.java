import javax.swing.JOptionPane;

public class Pocion extends Item {
    private final int cantidadRecuperada;

    public Pocion(String nombre, int cantidadRecuperada) {
        super(nombre);
        this.cantidadRecuperada = cantidadRecuperada;
    }

    @Override
    public void usar(Personaje personaje) {
        personaje.salud += cantidadRecuperada;
        mostrarMensaje(String.format("%s ha recuperado %d de salud.", personaje.getNombre(), cantidadRecuperada));
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
