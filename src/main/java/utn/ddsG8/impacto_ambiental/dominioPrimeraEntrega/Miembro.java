package utn.ddsG8.impacto_ambiental.dominioPrimeraEntrega;

import java.util.List;

public class Miembro {
  private String nombre;
  private String apellido;
  private TipoDocumento tipoDocumento;
  private String documento;
  private List<Sector> sectoresDeTrabajo;
  //TODO: private List<Trayecto> trayectos


  public Miembro(String nombre, String apellido, TipoDocumento tipoDocumento, String documento, List<Sector> sectoresDeTrabajo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipoDocumento = tipoDocumento;
    this.documento = documento;
    this.sectoresDeTrabajo = sectoresDeTrabajo;
  }

  //TODO: public method viajar(this){
  //}
}
