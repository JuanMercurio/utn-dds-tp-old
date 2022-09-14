package utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.model.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.Transporte;

import java.util.List;

public abstract class TransportePublico implements Transporte {
    protected String nombre;
    protected String nombreFE;
    protected List<Parada> paradas;

    public void agregarParada(Parada nueva, double distProxima, double distAnterior, int i) {
        // IMPORTANTE: Esta implementado como que el administrador pone 0 para la primera parada, no 1
        // Se puede cambiar con un simple -1. Decidir que queda
        paradas.add(i, nueva);
        Parada anterior = paradas.get(Math.max(0, i-1));
        Parada proxima = paradas.get(Math.min(i+1, paradas.size() - 1));
        proxima.setDistanciaAnteriorParada(distProxima);
        anterior.setDistanciaProximaParada(distAnterior);
        if (i == 0) nueva.setAnteriorParada(null);
        else nueva.setAnteriorParada(anterior);
        if (i == paradas.size() - 1) nueva.setProximaParada(null);
        else nueva.setAnteriorParada(proxima);
    }

    public List<Parada> getParadas() {
        return this.paradas;
    }

    /* a checkear si esta bien, si a borrar.
    public double CalcularDistancia (Parada paradaIncial, Parada paradaFinal){
        return paradaIncial.distanciaAParada(paradaFinal,this);
    }*/

    @Override
    public double calcularHC(double distancia) {
        double fe;
        fe = (double) CalcularHC.getInstancia().buscarFactorEmision(this.nombreFE,"");
        if (fe != -1){
            return fe * distancia;
        }
        return -1;
    }

}
