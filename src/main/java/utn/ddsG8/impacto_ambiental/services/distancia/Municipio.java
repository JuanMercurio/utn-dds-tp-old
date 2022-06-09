package utn.ddsG8.impacto_ambiental.services.distancia;

public class Municipio {
    public int id;
    public String nombre;
    public Provincia provincia;

    public Municipio(int id, String nombre, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
    }
}
