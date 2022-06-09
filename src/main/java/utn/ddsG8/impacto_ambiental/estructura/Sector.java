package utn.ddsG8.impacto_ambiental.estructura;

import java.util.ArrayList;
import java.util.List;

public class Sector {
    private String nombre;

    public List<Miembro> getMiembros() {
        return miembros;
    }

    private List<Miembro> miembros;
    private Organizacion organizacion;

    public Sector(String nombre, Organizacion org) {
        this.nombre = nombre;
        this.organizacion = org;
        this.miembros = new ArrayList<Miembro>();
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public Organizacion getOrganizacion() {
        return this.organizacion = organizacion;
    }
}
