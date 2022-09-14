package utn.ddsG8.impacto_ambiental.model.estructura;

public class SolicitudMiembro {
    private Miembro solicitante;
    private Sector sector;

    public SolicitudMiembro(Miembro solicitante, Sector sector) {
        this.solicitante = solicitante;
        this.sector = sector;
    }

    public Miembro getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Miembro solicitante) {
        this.solicitante = solicitante;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
