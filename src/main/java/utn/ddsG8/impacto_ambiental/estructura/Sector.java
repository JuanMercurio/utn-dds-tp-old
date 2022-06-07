package utn.ddsG8.impacto_ambiental.estructura;

import java.util.List;

public class Sector {
    private String nombre;
    private List<Miembro> miembros;
    private Organizacion organizacion;

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}