import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private final String nombre;
    private final List<Enemigo> enemigos;

    public Mapa(String nombre) {
        this.nombre = nombre;
        enemigos = new ArrayList<>();
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    public void mostrarEnemigos() {
        StringBuilder lista = new StringBuilder("Enemigos en el mapa:\n");
        for (Enemigo enemigo : enemigos) {
            lista.append(String.format("Enemigo: %s - Salud: %d\n", enemigo.getNombre(), enemigo.getSalud()));
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public String getNombre() {
        return nombre;
    }
}
