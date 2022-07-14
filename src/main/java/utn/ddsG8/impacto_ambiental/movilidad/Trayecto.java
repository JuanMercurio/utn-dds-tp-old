package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Miembro;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Trayecto {
    private List<Miembro> miembros;
    private List<Organizacion> organizaciones;
    private List<Tramo> tramos;
    private Distancia distancia;
    private int id;

    public Trayecto() {
        this.miembros = new ArrayList<Miembro>() ;
        this.organizaciones = new ArrayList<Organizacion>() ;
        this.tramos = new ArrayList<Tramo>() ;
        // TODO: id?
        // TODO: falta una forma de agregar las organizaciones que forman parte del trayecto
    }

    public Distancia getDistancia() {
        if (distancia == null) this.setDistancia();
        return distancia;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public Distancia getDistanciaDeTramo(int index) {
        return tramos.get(index).getDistancia();
    }

    private void setDistancia() {
        double valor = (double) tramos.stream().mapToDouble(t -> t.getDistancia().valor) .sum();
        final String unidad = tramos.get(0).getDistancia().unidad;
        this.distancia = new Distancia(valor, unidad);
    }

    public void agregarTramo(Tramo tramo) {
        tramos.add(tramo);
    }

    public void agregarTramos(Tramo ... tramo) {
        Stream.of(tramo).forEach(t -> tramos.add(t));
    }

    public  void agregarOrganizacion(Organizacion unaOrg) {
        this.organizaciones.add(unaOrg);
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public int getId() {
        return id;
    }

    public double CalcularHCTrayecto(CalcularHC calculador){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHC(calculador);
        }
        return hc;

    }
    public double CalcularHCTrayectoMensual(CalcularHC calculador, int mes, int anio){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHCMensual(calculador,mes,anio);
        }
        return hc;

    }
    public double CalcularHCTrayectoAnual(CalcularHC calculador, int anio){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHCAnual(calculador,anio);
        }
        return hc;

    }

}
