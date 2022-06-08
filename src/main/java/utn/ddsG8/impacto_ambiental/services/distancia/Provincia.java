package utn.ddsG8.impacto_ambiental.services.distancia;

public class Provincia {
    public int id;
    public String nombre;
    public Pais pais;

    public Provincia(int id, String nombre, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
}
