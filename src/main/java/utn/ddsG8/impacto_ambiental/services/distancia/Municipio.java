package utn.ddsG8.impacto_ambiental.services.distancia;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
    public int id;
    public String nombre;
    public Provincia provincia;
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
