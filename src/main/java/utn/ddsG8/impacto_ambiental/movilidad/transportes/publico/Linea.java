package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.List;

public class Linea {
    private List<Parada> paradas;
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParada(Parada nueva, double distProxima, double distAnterior, int i) {
        paradas.add(i, nueva);
        Parada anterior = paradas.get(i-1);
        Parada proxima = paradas.get(i+1);

        nueva.setAnteriorParada(anterior);
        nueva.setAnteriorParada(proxima);

        proxima.setDistanciaAnteriorParada(distProxima);
        anterior.setDistanciaProximaParada(distAnterior);
    }

}
