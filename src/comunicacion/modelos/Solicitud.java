package comunicacion.modelos;

import comunicacion.enumerables.Accion;
import comunicacion.enumerables.Estado;

public class Solicitud {
    private final String recurso;
    private final Accion accion;
    private Estado estado = Estado.PENDIENTE;
    private final String cuerpoSolicitud;

    // Contructor para cliente
    public Solicitud(String recurso, Accion accion,String cuerpo) {
        this.recurso = recurso;
        this.accion = accion;
        this.cuerpoSolicitud = cuerpo;
    }

    // Contructor para servidor
    public Solicitud(String recurso, Accion accion, Estado estado, String cuerpo) {
        this.recurso = recurso;
        this.accion = accion;
        this.estado = estado;
        this.cuerpoSolicitud = cuerpo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getRecurso() {
        return recurso;
    }

    public Accion getAccion() {
        return accion;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getCuerpoSolicitud() {
        return cuerpoSolicitud;
    }

    @Override
    public String toString() {
        return "**** SOLICITUD ****" +
                "\n Recurso: " + recurso +
                "\n Acción: " + accion +
                "\n comunicacion.enumerables.Estado: " + estado +
                "\n Cuerpo solicitud: " + cuerpoSolicitud;
    }
}
