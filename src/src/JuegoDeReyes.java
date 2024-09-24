import javax.swing.JOptionPane;

public class JuegoDeReyes {
    public static void main(String[] args) {

        Personaje luigi = new Personaje("Luigi", 100, 15, 5);
        Enemigo mbappe = new Enemigo("Mbappé", 50, 10, 2);

        Pocion pocionHuesoDePlatano = new Pocion("Hueso de Plátano", 20);
        Arma armaForyfay = new Arma("Foryfay", 5);

        Mapa mundoDeLasMaravillas = new Mapa("Mundo de las Maravillas");
        mundoDeLasMaravillas.agregarEnemigo(mbappe);

        JOptionPane.showMessageDialog(null, "Explorando en: " + mundoDeLasMaravillas.getNombre());

        realizarBatalla(luigi, mbappe, pocionHuesoDePlatano, armaForyfay);
        mundoDeLasMaravillas.mostrarEnemigos();
    }

    private static void realizarBatalla(Personaje atacante, Enemigo defensor, Pocion pocion, Arma arma) {
        atacante.atacar(defensor);
        defensor.atacar(atacante);
        pocion.usar(atacante);
        arma.usar(atacante);
        atacante.atacar(defensor);
    }
}
