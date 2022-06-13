package utn.ddsG8.impacto_ambiental.services.distancia;

public class Distancia {
    public float valor;
    public String unidad;

    public Distancia(float valor, String unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public Distancia sumar(Distancia distancia) {
        return new Distancia(distancia.valor + valor, "KM");
    }
}
