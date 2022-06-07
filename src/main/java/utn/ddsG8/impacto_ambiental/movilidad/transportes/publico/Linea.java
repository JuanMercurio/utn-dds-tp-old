package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.List;

public class Linea {
//    private List<Parada> paradas;
    private Parada inicio;
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParada(Parada nueva, Parada ant, Parada desp) {
        Parada paradaT = inicio;
        while (nueva != paradaT) {
            paradaT = paradaT.getProximaParada();
        }
        paradaT.nuevaParada(nueva);
    }

}
