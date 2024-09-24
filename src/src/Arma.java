import javax.swing.JOptionPane;

public class Arma extends Item {
    private final int incrementoAtaque;

    public Arma(String nombre, int incrementoAtaque) {
        super(nombre);
        this.incrementoAtaque = incrementoAtaque;
    }

    @Override
    public void usar(Personaje personaje) {
        personaje.ataque += incrementoAtaque;
        mostrarMensaje(String.format("%s ha equipado %s. Ataque aumentado en %d.", personaje.getNombre(), nombre, incrementoAtaque));
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
