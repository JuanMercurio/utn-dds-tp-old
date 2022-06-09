package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

public class Colectivo extends TransportePublico {
    public Colectivo(Linea linea,Parada paradaFin,Parada paradaInicio) {
        super.linea = linea;
        super.paradaFin = paradaFin;
        super.paradaInicio =paradaInicio;
    }
}
