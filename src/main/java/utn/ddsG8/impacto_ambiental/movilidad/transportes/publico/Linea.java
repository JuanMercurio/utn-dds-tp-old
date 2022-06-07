package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.List;

public class Linea {
//    private List<Parada> paradas;     // una opcion es modelarlo asi
    private Parada inicio;
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParada(Parada nueva, Parada ant, Parada desp) {
        Parada parada = inicio;
        while (nueva != parada) {
            parada = parada.getProximaParada();
        }
        parada.nuevaParada(nueva);
    }

}
