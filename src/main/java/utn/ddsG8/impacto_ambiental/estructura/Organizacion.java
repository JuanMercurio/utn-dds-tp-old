package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private OrgTipo tipo;
    private Clasificacion clasificacion;
    private Direccion direccion;
    private List<Sector> sectores;
    private List<Miembro> potencialesMiembros;

    private String archivoDatosActividades;

    public void cargarMediciones() throws IOException {
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades(archivoDatosActividades);
        //todo a donde van estas mediciones?
    }

    public void agregarSector(Sector sector) {
        sectores.add(sector);
    }

    public void confimarMiembros(){

    }

    public void solicitudNuevoMiembro(Miembro miembro) {
    }
}
