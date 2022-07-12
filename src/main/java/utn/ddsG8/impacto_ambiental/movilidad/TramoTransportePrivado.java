package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.TransportePrivado;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public class TramoTransportePrivado extends Tramo {
    private TransportePrivado transporte;
    private Direccion inicio;
    private Direccion fin;

    public TramoTransportePrivado(TransportePrivado transportePrivado, Direccion inicio, Direccion fin, String token) {
        this.transporte = transportePrivado;
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = this.calcularDistancia(token);
    }

    private Distancia calcularDistancia(String token) {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        try {
            return distancia =  api.distancia(token, inicio, fin);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public float calcularHC(CalcularHC calculador) {
        return this.transporte.calcularHC(calculador,this.distancia.valor);
    }


}
