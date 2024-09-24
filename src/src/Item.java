public abstract class Item {
    protected String nombre;

    public Item(String nombre) {
        this.nombre = nombre;
    }

    public abstract void usar(Personaje personaje);
}
