package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.TransportePrivado;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public class TramoTransportePrivado extends Tramo {
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

    public Double calcularHC() {
        return this.transporte.calcularHC(this.distancia.valor);
    }
    public Double calcularHCAnual(int anio) {
        if( this.fecha.getYear() == anio){
            return this.transporte.calcularHC(this.distancia.valor);
        }
        return 0.0;
    }
    public Double calcularHCMensual(int anio, int mes) {
        if(this.fecha.getMonth().getValue() == mes && this.fecha.getYear() == anio){
            return this.transporte.calcularHC(this.distancia.valor);
        }
        return 0.0;

    }


}
