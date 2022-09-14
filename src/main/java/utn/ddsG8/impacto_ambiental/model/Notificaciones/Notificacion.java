package utn.ddsG8.impacto_ambiental.model.Notificaciones;

import java.util.TimerTask;

public abstract class Notificacion extends TimerTask {
    public abstract void Enviar();

    //public abstract void run(Contacto contacto);
}
