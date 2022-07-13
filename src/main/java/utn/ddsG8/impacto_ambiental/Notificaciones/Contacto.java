package utn.ddsG8.impacto_ambiental.Notificaciones;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    // email, telefono, nombre
    private List<Notificacion> notificaciones;

    public Contacto() {
        this.notificaciones = new ArrayList<>();
        Whatsapp wpp = new Whatsapp();
        Mail mail = new Mail();
        notificaciones.add(wpp);
        notificaciones.add(mail);
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
