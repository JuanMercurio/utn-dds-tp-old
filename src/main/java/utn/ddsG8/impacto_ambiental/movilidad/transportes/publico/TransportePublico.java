package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;

public abstract class TransportePublico implements Transporte {
    protected Parada paradaInicio;
    protected Parada paradaFin;

    @Override
    public void crearTramo(Direccion inicio, Direccion fin) {
//        inicio = paradaInicio.getDireccion();
//        fin = paradaInicio.getDireccion();
//        Tramo tramo = new Tramo(inicio, fin , this);
    }

    @Override
    public Distancia distancia(String token) throws IOException {
        int valor = paradaInicio.distancia(paradaFin);
        //todo: unidades son necesarias?
        String unidad = "m";
        return new Distancia(valor, unidad);

    }

    @Override
    public void calcularHC() {

    }
}
