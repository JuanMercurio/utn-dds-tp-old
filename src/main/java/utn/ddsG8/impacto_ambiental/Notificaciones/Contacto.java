package utn.ddsG8.impacto_ambiental.Notificaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Contacto {
    // email, telefono, nombre
    private List<Notificacion> notificaciones;
    private Timer t;
    private long tiempoNotificacion;

    public Contacto() {
        this.notificaciones = new ArrayList<>();
        Whatsapp wpp = new Whatsapp();
        Mail mail = new Mail();
        notificaciones.add(wpp);
        notificaciones.add(mail);
        tiempoNotificacion = 1000;
         t = new Timer();

         t.scheduleAtFixedRate(wpp,0,this.tiempoNotificacion);
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
