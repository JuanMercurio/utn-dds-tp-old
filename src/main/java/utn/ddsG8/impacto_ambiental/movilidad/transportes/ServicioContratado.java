package utn.ddsG8.impacto_ambiental.movilidad.transportes;

public class ServicioContratado extends TransportePrivado {
    private String nombre;

    public ServicioContratado(String nombre) {
        this.nombre = nombre;
    }

    // Tal vez lo calcula igual que el auto, confirmar
    @Override
    public void calcularHC() {
    }
}
