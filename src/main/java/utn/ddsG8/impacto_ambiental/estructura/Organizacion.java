package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.movilidad.Trayecto;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private OrgTipo tipo;
    private Clasificacion clasificacion;
    private Direccion direccion;
    private List<Sector> sectores;
    private List<SolicitudMiembro> potencialesMiembros;
    private String archivoDatosActividades;
    private List<Trayecto> trayectos;
    //TODO: la medicion pertenece a una organizacion o le hacemos a la organizacion una lsita de mediciones?
    private List<Medicion> mediciones;

    public Organizacion(String razonSocial, OrgTipo tipo, Clasificacion clasificacion,
                        Direccion direccion) {
        this.razonSocial         = razonSocial;
        this.tipo                = tipo;
        this.clasificacion       = clasificacion;
        this.direccion           = direccion;
        this.sectores            = new ArrayList<Sector>();
        this.potencialesMiembros = new ArrayList<SolicitudMiembro>();
        this.mediciones          = new ArrayList<Medicion>();
    }

    public void cargarMediciones() throws IOException {
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades(archivoDatosActividades);
        //todo a donde van estas mediciones? por ahora a un atributo
    }

    public void confimarMiembros(){
        potencialesMiembros.forEach(m -> aceptarMiembro(m));
    }

    public void aceptarMiembro(SolicitudMiembro m) {
        // TODO: como hace una org para confirmar un miembro
        m.getSolicitante().unirseAOrg(this, m.getSector());
    }

    public void solicitudNuevoMiembro(Miembro miembro, Sector sector) {
        SolicitudMiembro solicitante = new SolicitudMiembro(miembro, sector);
        potencialesMiembros.add(solicitante);
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public List<Sector> getSectores() {
        return sectores;
    }
    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }
}
