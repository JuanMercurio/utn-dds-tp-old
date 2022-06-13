package utn.ddsG8.impacto_ambiental.movilidad;

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
        return new Distancia(inicio.distanciaAParada(fin), "KM");
    }

}
