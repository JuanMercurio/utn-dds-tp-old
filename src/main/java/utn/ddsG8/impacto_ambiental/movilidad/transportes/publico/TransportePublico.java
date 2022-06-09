package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;

public abstract class TransportePublico implements Transporte {
    protected Parada paradaInicio;
    protected Parada paradaFin;
    protected Linea linea;

    @Override
    public Distancia calcularDistancia(String token) throws IOException {
        // TODO
        return null;
    }

    @Override
    public void calcularHC() {

    }

    @Override
    public Distancia getDistanciaTramo(){
        return null;
    }
}
