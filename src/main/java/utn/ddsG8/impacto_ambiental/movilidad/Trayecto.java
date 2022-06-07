package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Miembro;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class Trayecto {
    private List<Miembro> miembros;
    private List<Organizacion> organizaciones;
    private List<Tramo> tramos;

    public Trayecto() {
        this.miembros = new ArrayList<Miembro>() ;
        this.organizaciones = new ArrayList<Organizacion>() ;
        this.tramos = new ArrayList<Tramo>() ;
    }
    public  void AgregarOrganizacion(Organizacion unaOrg){ organizaciones.add(unaOrg);}
    public void agregarTramo(Tramo tramo) {
        tramos.add(tramo);
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }
}
