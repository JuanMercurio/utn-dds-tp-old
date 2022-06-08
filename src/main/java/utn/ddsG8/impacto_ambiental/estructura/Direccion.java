package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.services.distancia.Localidad;
import utn.ddsG8.impacto_ambiental.services.distancia.Municipio;

public class Direccion {
    private String nombre; // esta de mas?
    private String calle;
    private Integer altura;
    private Localidad localidad;

    public Direccion(String calle, Integer altura, Localidad localidad) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }

    public Localidad getLocalidad() {
        return this.localidad;
    }

    public String getCalle() {
        return this.calle;
    }

    public String getAltura() {
        return this.altura.toString();
    }
}
