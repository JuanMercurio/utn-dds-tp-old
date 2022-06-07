package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.calculos.Medicion;
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
    private List<Miembro> potencialesMiembros;
    private String archivoDatosActividades;
    private List<Medicion> mediciones;

    public Organizacion(String razonSocial, OrgTipo tipo, Clasificacion clasificacion,
                        Direccion direccion) {
        this.razonSocial         = razonSocial;
        this.tipo                = tipo;
        this.clasificacion       = clasificacion;
        this.direccion           = direccion;
        this.sectores            = new ArrayList<Sector>();
        this.potencialesMiembros = new ArrayList<Miembro>();
    }

    public void cargarMediciones() throws IOException {
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades(archivoDatosActividades);
        //todo a donde van estas mediciones? por ahora a un atributo
    }

    public void confimarMiembros(){
        potencialesMiembros.forEach(m -> aceptarMiembro(m));
    }

    public void aceptarMiembro(Miembro miembro) {
        // TODO: como hace una org para confirmar un miembro
    }

    public void solicitudNuevoMiembro(Miembro miembro) {
        potencialesMiembros.add(miembro);
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
}
