package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;

public interface Transporte {

    float calcularHC(CalcularHC calculador,float distancia);
}
