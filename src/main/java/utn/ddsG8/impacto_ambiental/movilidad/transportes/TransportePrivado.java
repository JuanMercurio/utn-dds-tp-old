package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;

public abstract class TransportePrivado implements Transporte {
    protected String nombreFE;
    public float calcularHC(CalcularHC calculador, float distancia) {
        float fe;
        fe = (float) calculador.buscarFactorEmision(this.nombreFE,"");
        if (fe != -1){
            return fe * distancia;
        }
        return -1;
    }

    public String getNombre() {
        return nombreFE;
    }

    public void setNombre(String nombre) {
        this.nombreFE = nombre;
    }
}
