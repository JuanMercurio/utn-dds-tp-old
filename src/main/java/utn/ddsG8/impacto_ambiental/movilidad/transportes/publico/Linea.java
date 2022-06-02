package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import java.util.List;

public class Linea {
    private List<Parada> paradas;
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void agregarParada(Parada parada) {
        paradas.add(parada);
    }

}
