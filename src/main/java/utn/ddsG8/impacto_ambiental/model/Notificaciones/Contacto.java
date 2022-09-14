package utn.ddsG8.impacto_ambiental.model.Notificaciones;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    // email, telefono, nombre
    private String email;
    private String telefono;
    private String nombre;
    private List<Notificacion> notificaciones;
    //private Timer t;
    //private long tiempoNotificacion;
    //private List<LocalDate> fechas;

    public Contacto(String emaill, String telefonoo, String nombree) {
        this.email = emaill;
        this.telefono = telefonoo;
        this.nombre = nombree;
        this.notificaciones = new ArrayList<>();
        Whatsapp wpp = new Whatsapp(this.telefono);
        Mail mail = new Mail(this.email);
        notificaciones.add(wpp);
        notificaciones.add(mail);
       // tiempoNotificacion = 1000;


        /* t = new Timer();

         t.scheduleAtFixedRate(wpp,5,this.tiempoNotificacion);
         t.schedule(wpp,5);
        t.schedule(wpp,new Date(2022,7,13));*/
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
