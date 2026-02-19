package comunicacion.modelos;

import comunicacion.enumerables.Accion;
import comunicacion.enumerables.Estado;
import modelos.Usuario;

import java.util.HashMap;

public class Solicitud {
    private final String recurso;
    private final Accion accion;
    private Estado estado = Estado.PENDIENTE;
    private Usuario usuario;
    private final HashMap<String, String> cuerpoSolicitud;

    private final int idUser;


    // Contructor para mensajes entrantes
    public Solicitud(String recurso, Accion accion, int user, HashMap<String, String> cuerpo) {
        this.recurso = recurso;
        this.accion = accion;
        this.cuerpoSolicitud = cuerpo;
        this.idUser = user;
        // El endpoint debera verificar usuario y cargarlo.
    }

    // Contructor para generar Respuesta
    public Solicitud(String recurso, Accion accion, Estado estado, Usuario user, HashMap<String, String> cuerpo) {
        this.recurso = recurso;
        this.accion = accion;
        this.estado = estado;
        this.cuerpoSolicitud = cuerpo;
        this.usuario = user;
        this.idUser = user.getId();
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

    public Usuario getUsuario() {
        return this.usuario;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public HashMap<String, String> getCuerpoSolicitud() {
        return cuerpoSolicitud;
    }

    @Override
    public String toString() {
        return "**** SOLICITUD ****" +
                "\n Recurso: " + recurso +
                "\n Acción: " + accion +
                "\n Usuario: " + this.getUsuario() +
                "\n Estado: " + estado +
                "\n Cuerpo solicitud: " + cuerpoSolicitud;
    }
}
