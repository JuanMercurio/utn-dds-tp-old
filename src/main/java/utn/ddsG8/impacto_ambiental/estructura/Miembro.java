package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.movilidad.Tramo;
import utn.ddsG8.impacto_ambiental.movilidad.Trayecto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;

import java.util.ArrayList;
import java.util.List;

public class Miembro {
    private String nombre;
    private String apellido;
    private TipoDoc tipoDoc;
    private String documento;
    private List<Sector> sectores;
    private List<Trayecto> trayectos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

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


//    public int crearTrayecto(Tramo ... tramos) {
//        Trayecto trayecto = new Trayecto();
//        trayecto.agregarMiembro(this);
//        for (Tramo tramo:tramos) {
//            trayecto.agregarTramo(tramo);
//            //TODO: agregar las organizaciones que forman parte
//            // idea de que por la direccion detecta la organizacion.
//            // se podria pensar que le dice si es una organizacion o no. dentro de cada tramo.
//            Organizacion orgInicial = EstaYendoAOrganizacion(tramo.getDireccionInicial());
//            Organizacion orgFinal = EstaYendoAOrganizacion(tramo.getDireccionFinal());
//            if(orgInicial != null){
//                trayecto.AgregarOrganizacion(orgInicial);
//            }
//            if(orgFinal!= null){
//                trayecto.AgregarOrganizacion(orgFinal);
//            }
//        }

        // TODO: deberia retornar el id del trayecto
        // podria devolver el objeto TRAYECTO.
//        return 0;
//    }
    // TODO: estoy suponiendo que en una direccion solo hay una org
    public Organizacion EstaYendoAOrganizacion(Direccion unaDireccion){
        for (Sector unSector:this.sectores) {
            Organizacion org = unSector.getOrganizacion();
            Direccion dir = org.getDireccion();
            if(dir == unaDireccion ){
                return org;
            }

        }
        return null;
    }

    public void unirseAOrg(Organizacion org, Sector sector) {
        //TODO: deberia pasarle el sector tambien?
        org.solicitudNuevoMiembro(this, sector);
    }

    public void sumarseATrayecto(int id, Organizacion org) {
        Trayecto trayecto = org.getTrayectos().stream().filter(t -> t.getId() == id)
                .findAny()
                .orElse(null);

        trayecto.agregarMiembro(this);
    }

    public void agregarATrayecto(Trayecto trayecto) {
        trayecto.agregarMiembro(this);
    }
}
