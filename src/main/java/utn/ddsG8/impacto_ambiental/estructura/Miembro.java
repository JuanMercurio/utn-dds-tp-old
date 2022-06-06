package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.movilidad.Tramo;
import utn.ddsG8.impacto_ambiental.movilidad.Trayecto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private String apellido;
    private TipoDoc tipoDoc;
    private String documento;
    private List<Sector> sectores;
    private List<Trayecto> trayectos;

    public Miembro(String nombre, String apellido, TipoDoc tipoDoc, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.sectores = new ArrayList<Sector>();
        this.trayectos = new ArrayList<Trayecto>();
    }

    public void agregarSector(Sector sector) {
        this.sectores.add(sector);
    }

    public void crearTramo(Transporte transporte) {
        Tramo t = new Tramo(transporte);
    }

    public int crearTrayecto(Tramo ... tramos) {
        Trayecto trayecto = new Trayecto();
        trayecto.agregarMiembro(this);
        for (Tramo tramo:tramos) {
            trayecto.agregarTramo(tramo);
        }
        //TODO: agregar las organizaciones que forman parte

        // TODO: deberia retornar el id del trayecto
        return 0;
    }

    public void solicitudUnionOrganizacion(Organizacion org) {
        //TODO: deberia pasarle el sector tambien?
        org.solicitudNuevoMiembro(this);
    }

    //TODO: segun un id de trayecto se suma el miembro al viaje
    public void sumarseATrayecto(int idTrayecto) {
    }



}
