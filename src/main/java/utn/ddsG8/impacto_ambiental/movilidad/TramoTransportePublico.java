package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.TransportePublico;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

public class TramoTransportePublico extends Tramo{
    private TransportePublico transporte;
    private Parada inicio;
    private Parada fin;

    public TramoTransportePublico(TransportePublico transporte, Parada inicio, Parada fin) {
        this.transporte = transporte;
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = calcularDistancia(inicio, fin);
    }

    private Distancia calcularDistancia(Parada inicio, Parada fin) {
        return new Distancia(inicio.distanciaAParada(fin,this.transporte), "KM");
    }

    @Override
    public Double calcularHC(CalcularHC calculador) {
        return transporte.calcularHC(calculador,this.distancia.valor);
    }

    @Override
    public Double calcularHCAnual(CalcularHC calculador, int anio) {
        if( this.fecha.getYear() == anio){
            return this.transporte.calcularHC(calculador,this.distancia.valor);
        }
        return 0.0;
    }
    @Override
    public Double calcularHCMensual(CalcularHC calculador, int anio, int mes) {
        if(this.fecha.getMonth().getValue() == mes && this.fecha.getYear() == anio){
            return this.transporte.calcularHC(calculador,this.distancia.valor);
        }
        return 0.0;

    }
}
