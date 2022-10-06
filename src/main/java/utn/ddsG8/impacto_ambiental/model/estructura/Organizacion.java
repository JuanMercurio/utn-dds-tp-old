package utn.ddsG8.impacto_ambiental.model.estructura;

import lombok.Getter;
import lombok.Setter;
import utn.ddsG8.impacto_ambiental.model.Notificaciones.Contacto;
import utn.ddsG8.impacto_ambiental.model.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.model.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.model.movilidad.Trayecto;
import utn.ddsG8.impacto_ambiental.db.Persistable;
import utn.ddsG8.impacto_ambiental.model.services.sheets.LectorExcel;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "organizacion")
public class Organizacion extends Persistable {

    @Column(name = "razon_social")
    private String razonSocial;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipo")
    private OrgTipo tipo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "clasificacion")
    private Clasificacion clasificacion;

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    private Direccion direccion;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sector> sectores;

    // esta es la forma fea del one-to-many unidireccional
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion", referencedColumnName = "id")
    private List<SolicitudMiembro> potencialesMiembros;

    @Column(name = "archivo_datos_actividades")
    private String archivoDatosActividades;

    @Getter
    @ManyToMany(mappedBy = "organizaciones")
    private List<Trayecto> trayectos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion", referencedColumnName = "id")
    private List<Medicion> mediciones;

    @Getter
    // esta es la forma fea de one-to-many unidireccional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion", referencedColumnName = "id")
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


    public int cantidadMiembros(){
        // se puede buscar una forma mas elegante como ya tener un set de miembros, pero eso seria informacion redundante...
        Set<Miembro> miembros = new HashSet<Miembro>();
        sectores.forEach(sector -> miembros.addAll(sector.getMiembros()));
        return miembros.size();
    }

    public void setArchivoDatosActividades(String archivoDatosActividades) {
        this.archivoDatosActividades = archivoDatosActividades;
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

public double CalcularHC (){
        double hc = 0;
        for (Trayecto trayecto: trayectos) {
            hc+= trayecto.CalcularHCTrayecto();
        }
        return hc + CalcularHC.getInstancia().CalcularFEActividadesTOTAL(mediciones);
    }

    public void HuellaCarbonoMiembros(CalcularHC calculador){
        int cant = 0;
        for (Sector sector:  sectores) {
            for (Miembro miembro: sector.getMiembros()) {
                double hc = 0;
                for (Trayecto trayecto: this.trayectos) {
                    if(trayecto.getMiembros().contains(miembro)){
                        hc+= trayecto.CalcularHCTrayecto();
                    }
                }
            }
        }
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
        return CalcularHC()*cantidadMiembros();
    }

    public void CrearContacto (String nombre, String email,String telefono){
        Contacto c = new Contacto(email,telefono,nombre);
        contactos.add(c);
    }
    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
    }
}
