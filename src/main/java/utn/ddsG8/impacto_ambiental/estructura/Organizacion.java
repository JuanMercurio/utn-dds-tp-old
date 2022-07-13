package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.Notificaciones.Contacto;
import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
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
    private List<Medicion> mediciones;
    private List<Contacto> contactos;

    // TODO: HC / CANT. DE MIEMBRO. agregar metodo.

    public Organizacion(String razonSocial, OrgTipo tipo, Clasificacion clasificacion,
                        Direccion direccion) {
        this.razonSocial         = razonSocial;
        this.tipo                = tipo;
        this.clasificacion       = clasificacion;
        this.direccion           = direccion;
        this.sectores            = new ArrayList<Sector>();
        this.potencialesMiembros = new ArrayList<SolicitudMiembro>();
        this.mediciones          = new ArrayList<Medicion>();
        this.contactos = new ArrayList<>();
    }



    public List<SolicitudMiembro> getPotencialesMiembros() {
        return potencialesMiembros;
    }

    public void cargarMediciones() throws IOException {
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades(archivoDatosActividades);
    }

    public void confimarMiembros(){
        potencialesMiembros.forEach(m -> aceptarMiembro(m));
    }

    public void aceptarMiembro(SolicitudMiembro m) {
        // TODO: como hace una org para confirmar un miembro
        m.getSector().agregarMiembro(m.getSolicitante());

    }

    public void aceptarTodosLosMiembros(){
        for(SolicitudMiembro solicitudMiembro : potencialesMiembros ){
            aceptarMiembro(solicitudMiembro);
        }
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

    public double CalcularHC (CalcularHC calculador){
        double hc = 0;
        for (Trayecto trayecto: trayectos) {
            hc+= trayecto.CalcularHCTrayecto(calculador);
        }
        return hc;
    }
    public double CalcularHCAnual (CalcularHC calculador, int anio){
        double hc = 0;
        for (Trayecto trayecto: trayectos) {
            hc+= trayecto.CalcularHCTrayectoAnual(calculador,anio);
        }
        return hc + calculador.CalcularFEActividadesAnual(mediciones,anio);
    }
    public double CalcularHCMensual (CalcularHC calculador, int anio, int mes){
        double hc = 0;
        for (Trayecto trayecto: trayectos) {
            hc+= trayecto.CalcularHCTrayectoMensual(calculador,mes,anio);
        }
        return hc + calculador.CalcularFEActividadesMensual(mediciones,mes,anio);
    }

    public double IndicadorHC_CANT (CalcularHC calculardor){
        return CalcularHC(calculardor)*cantidadMiembros();
    }
    public int cantidadMiembros(){
        int cant = 0;
        for (Sector sector:  sectores) {
            cant += sector.getMiembros().size();
        }
        //todo no contemplo que un empleado puede estar en dos sectores
        return cant;
    }


    public void CrearContacto (String nombre, String email,String telefono){
        Contacto c = new Contacto(email,telefono,nombre);
        contactos.add(c);
    }
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    // todo funcion cron
    public void Cron (){
        this.contactos.forEach(contacto -> contacto.getNotificaciones().forEach(notificacion -> notificacion.Enviar()));
    }
}
