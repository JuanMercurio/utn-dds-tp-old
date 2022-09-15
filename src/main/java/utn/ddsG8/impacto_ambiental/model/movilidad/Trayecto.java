package utn.ddsG8.impacto_ambiental.model.movilidad;

import utn.ddsG8.impacto_ambiental.db.converters.DistanciaConverter;
import utn.ddsG8.impacto_ambiental.model.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.model.estructura.Miembro;
import utn.ddsG8.impacto_ambiental.model.estructura.Organizacion;
import utn.ddsG8.impacto_ambiental.db.Persistable;
import utn.ddsG8.impacto_ambiental.model.services.distancia.Distancia;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
@Table(name = "trayecto")
public class Trayecto extends Persistable {

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Miembro> miembros;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Organizacion> organizaciones;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tramo> tramos;

    @Column(name = "distancia")
    @Convert(converter = DistanciaConverter.class)
    private Distancia distancia;

    public Trayecto() {
        this.miembros = new ArrayList<Miembro>() ;
        this.organizaciones = new ArrayList<Organizacion>() ;
        this.tramos = new ArrayList<Tramo>() ;
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

    public double CalcularHCTrayecto(){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHC();
        }
        return hc;

    }
    public double CalcularHCTrayectoMensual(CalcularHC calculador, int mes, int anio){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHCMensual(mes,anio);
        }
        return hc;

    }
    public double CalcularHCTrayectoAnual(CalcularHC calculador, int anio){
        double hc = 0;

        for ( Tramo tramo: tramos) {
            hc += tramo.calcularHCAnual(anio);
        }
        return hc;

    }

}
