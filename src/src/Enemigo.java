import javax.swing.JOptionPane;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, int salud, int ataque, int defensa) {
        super(nombre, salud, ataque, defensa);
    }

    @Override
    public void atacar(Personaje objetivo) {
        mostrarMensaje(String.format("%s ataca a %s", nombre, objetivo.getNombre()));
        objetivo.recibirDanio(ataque);
    }

    @Override
    protected void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
