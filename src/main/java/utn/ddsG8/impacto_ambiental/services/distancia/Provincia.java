package utn.ddsG8.impacto_ambiental.services.distancia;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
    public int id;
    public String nombre;
    public Pais pais;
    public List<AgenteSectorial> agenteSectorialesP;

    public Provincia(int id, String nombre, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        agenteSectorialesP = new ArrayList<>();
    }
    public void AgregarAgenteSectorial(AgenteSectorial ags){
        agenteSectorialesP.add(ags);
    }
    public double CalcularHCProvincia (List<Organizacion> organizaciones, CalcularHC calculador){
        double hc = 0;
        for (Organizacion org: organizaciones) {

            if(org.getDireccion().getLocalidad().municipio.provincia.nombre == this.nombre){
                hc+= org.CalcularHC(calculador);
            }
            //
        }
        return hc;
    }
}
