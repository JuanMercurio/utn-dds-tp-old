package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

public class Parada {

    private Parada proximaParada;
    private Parada anteriorParada;
    private Direccion direccion;
    private String nombre;
    // SOLUCIONADO: es necesario que guarde su transporte? si el transporte guarda
    //private TransportePublico tranportePublico;
    private Distancia distanciaProximaParada;
    private Distancia distanciaAnteriorParada; //TODO por ahora no se usa esto, analizar si lo sacamos

    public Parada(String nombre, Direccion direccion/*, float distanciaProxima,
                  float distanciaAnterior, int i*/) {
        this.nombre = nombre;
        //this.tranportePublico = transportePublico;
        this.direccion = direccion;
        // Analizar si la unidad de las distancia siempre sera KM y si deberia tener un parametro "unidad" el constructor
        //this.distanciaProximaParada = new Distancia(distanciaProxima, "KM");
        //this.distanciaAnteriorParada = new Distancia(distanciaAnterior, "KM");
        //transportePublico.agregarParada(this, distanciaProxima, distanciaAnterior, i);
    }

    public float distanciaAParada(Parada paradaFinal, TransportePublico transporte) {
        float sum = 0;
        for (Parada parada :transporte.getParadas()) {
            sum += parada.distanciaProximaParada.valor ;
            if (parada == paradaFinal) break;
        }
        return sum;
    }

    public Distancia getDistanciaProximaParada() {
        return this.distanciaProximaParada;
    }

    public void setDistanciaProximaParada(float distanciaProximaParada) {
        this.distanciaProximaParada = new Distancia(distanciaProximaParada, "KM");
    }

    public void setDistanciaAnteriorParada(float distanciaAnteriorParada) {
        this.distanciaAnteriorParada = new Distancia(distanciaAnteriorParada, "KM");
    }

    public void setAnteriorParada(Parada anteriorParada) {
        this.anteriorParada = anteriorParada;
    }

    public void setProximaParada(Parada parada) {
        this.proximaParada = parada;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
