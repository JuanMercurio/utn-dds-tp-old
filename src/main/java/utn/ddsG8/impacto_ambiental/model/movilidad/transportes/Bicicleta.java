package utn.ddsG8.impacto_ambiental.model.movilidad.transportes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("Bici")
public class Bicicleta extends TransportePrivado {

    public Bicicleta() {
        this.nombreFE = "Bici";
    }


}
