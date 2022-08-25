package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.persistence.Persistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sector")
public class Sector extends Persistable {
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Miembro> miembros;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion", referencedColumnName = "id")
    private Organizacion organizacion;

    public Sector(String nombre, Organizacion org) {
        this.nombre = nombre;
        this.organizacion = org;
        this.miembros = new ArrayList<Miembro>();
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    public Organizacion getOrganizacion() {
        return this.organizacion = organizacion;
    }
}
