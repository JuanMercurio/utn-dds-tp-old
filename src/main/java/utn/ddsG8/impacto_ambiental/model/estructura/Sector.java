package utn.ddsG8.impacto_ambiental.model.estructura;

import lombok.Getter;
import utn.ddsG8.impacto_ambiental.db.Persistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sector")
public class Sector extends Persistable {
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Miembro> miembros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion", referencedColumnName = "id")
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
