package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.List;

public class Linea {
    private List<Parada> paradas;
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParada(Parada nueva, Parada ant) {
        Parada parada = paradas.get(paradas.indexOf(ant));
        parada.nuevaParada(nueva);
    }

}
