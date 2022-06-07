package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Miembro;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Trayecto {
    private List<Miembro> miembros;
    private List<Organizacion> organizaciones;
    private List<Tramo> tramos;
    private int id;

    public Trayecto() {
        this.miembros = new ArrayList<Miembro>() ;
        this.organizaciones = new ArrayList<Organizacion>() ;
        this.tramos = new ArrayList<Tramo>() ;
        // TODO: id
    }

    public Distancia distancia(String token) {
        float valor = (float) tramos.stream().mapToDouble(t -> t.distancia(token).valor)
                .sum();
        // ver unidades para confimar que siempre seran metros y que simplemente sumar esta bien
        final String unidad = "m";
        return new Distancia(valor, unidad);
    }

    public  void AgregarOrganizacion(Organizacion unaOrg){ organizaciones.add(unaOrg);}

    public void agregarTramo(Tramo tramo) {
        tramos.add(tramo);
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
