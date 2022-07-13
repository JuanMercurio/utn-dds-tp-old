package utn.ddsG8.impacto_ambiental.Notificaciones;

public class Mail extends Notificacion{
    @Override
    public void Enviar(Contacto contacto) {
        // TODO
        System.out.println("ENVIANDOME MAIL");
    }

    @Override
    public void run() {
        Enviar(null);
    }
}
