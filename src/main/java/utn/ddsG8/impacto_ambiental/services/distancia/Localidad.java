package utn.ddsG8.impacto_ambiental.services.distancia;

public class Localidad {
    public int id;
    public String nombre;
    public int codPostal;
    public Municipio municipio;

    public int getId() {
        return this.id;
    }
}
