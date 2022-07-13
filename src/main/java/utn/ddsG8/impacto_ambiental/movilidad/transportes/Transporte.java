package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;

public interface Transporte {

    double calcularHC(CalcularHC calculador,double distancia);
}
