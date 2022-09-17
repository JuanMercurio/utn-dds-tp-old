package utn.ddsG8.impacto_ambiental.model.services.distancia;

import utn.ddsG8.impacto_ambiental.db.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pais {
    @Id
    public int id;
    @Column
    public String nombre;

    public Pais(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Pais() {}
}
