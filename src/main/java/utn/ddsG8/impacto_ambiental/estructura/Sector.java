package utn.ddsG8.impacto_ambiental.estructura;

import java.util.ArrayList;
import java.util.List;

public class Sector {
    private String nombre;
    private List<Miembro> miembros;
    private Organizacion organizacion;

    public Sector(String nombre, Organizacion org) {
        this.nombre = nombre;
        this.organizacion = org;
        this.miembros = new ArrayList<Miembro>();
    }

    public Organizacion getOrganizacion() {
        return this.organizacion = organizacion;
    }
}
