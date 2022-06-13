package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;

import java.util.List;

public abstract class TransportePublico implements Transporte {
    protected String nombre;
    protected List<Parada> paradas;

    public void agregarParada(Parada nueva, float distProxima, float distAnterior, int i) {
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

    @Override
    public void calcularHC() {

    }

    public List<Parada> getParadas() {
        return this.paradas;
    }
}
