package utn.ddsG8.impacto_ambiental.dominioPrimeraEntrega;

import java.util.List;

public class Sector {
  private String Nombre;
  private List<Miembro> miembros;
  private Organizacion organizacion;

  public Sector(String nombre, List<Miembro> miembros, Organizacion organizacion) {
    Nombre = nombre;
    this.miembros = miembros;
    this.organizacion = organizacion;
  }
}
