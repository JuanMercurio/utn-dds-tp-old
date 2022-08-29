package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;

public abstract class TransportePrivado implements Transporte {
    protected String nombreFE;

    public double calcularHC( double distancia) {
        double fe;
        fe = (double) CalcularHC.getInstancia().buscarFactorEmision(this.nombreFE,"");
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
