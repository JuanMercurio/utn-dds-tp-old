package utn.ddsG8.impacto_ambiental.dominioPrimeraEntrega;

import java.util.List;

public class Organizacion {
  private String razonSocial;
  private OrgTipo tipo;
  private List<Sector> sectores;
  private Clasificacion clasificacion;
  //TODO: private Direccion ubicacion;


  public Organizacion(String razonSocial, OrgTipo tipo, List<Sector> sectores, Clasificacion clasificacion) {
    this.razonSocial = razonSocial;
    this.tipo = tipo;
    this.sectores = sectores;
    this.clasificacion = clasificacion;
  }

  public void agregarSector(Sector sector){
    this.sectores.add(sector);
  }
}
