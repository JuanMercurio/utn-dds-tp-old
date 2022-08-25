package utn.ddsG8.impacto_ambiental.services.distancia;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    public int id;
    @Column(name = "nombre")
    public String nombre;
    @Transient
    public Provincia provincia;
    @Transient
    public List<AgenteSectorial> agenteSectorialesM;

    public Municipio(int id, String nombre, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        agenteSectorialesM = new ArrayList<>();
    }

    public void AgregarAgenteSectorial(AgenteSectorial ags){
        agenteSectorialesM.add(ags);
    }
    public double CalcularHCMunicipio (List<Organizacion> organizaciones){
        double hc = 0;
        for (Organizacion org: organizaciones) {

            if(org.getDireccion().getLocalidad().municipio.nombre == this.nombre){
                hc+= org.CalcularHC();
            }
            //
        }
        return hc;
    }
}
