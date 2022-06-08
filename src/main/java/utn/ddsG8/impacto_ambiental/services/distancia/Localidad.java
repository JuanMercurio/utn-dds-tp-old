package utn.ddsG8.impacto_ambiental.services.distancia;

public class Localidad {
    public int id;
    public String nombre;
    public int codPostal;
    public Municipio municipio;

    public Localidad(int id, String nombre, int codPostal, Municipio municipio) {
        this.id = id;
        this.codPostal = codPostal;
        this.municipio = municipio;
        this.nombre = nombre;
    }


    public int getId() {
        return this.id;
    }
}
