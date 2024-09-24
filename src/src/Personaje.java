import javax.swing.JOptionPane;

public class Personaje {
    protected String nombre;
    protected int salud;
    protected int ataque;
    protected int defensa;

    public Personaje(String nombre, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void recibirDanio(int danio) {
        int danioReal = Math.max(0, danio - defensa);
        salud -= danioReal;
        mostrarMensaje(String.format("%s recibió %d de daño.", nombre, danioReal));
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    protected void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void atacar(Personaje defensor) {
        mostrarMensaje(String.format("%s ataca a %s", nombre, defensor.getNombre()));
        defensor.recibirDanio(ataque);
    }
}
