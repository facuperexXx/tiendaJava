package comunicacion.modelos;

import java.util.HashMap;

public class Respuesta extends Solicitud {
    private HashMap<String, String> cuerpoRespuesta;

    public Respuesta(Solicitud peticion, HashMap<String, String> bodyRespuesta) {
        super(peticion.getRecurso(), peticion.getAccion(), peticion.getEstado(), peticion.getUsuario(), peticion.getCuerpoSolicitud());
        this.cuerpoRespuesta = bodyRespuesta;
    }

    public HashMap<String, String> getCuerpoRespuesta() {
        return cuerpoRespuesta;
    }

    @Override
    public String toString() {
        return "**** RESPUESTA ****" +
                "\n Recurso: " + this.getRecurso() +
                "\n Acción: " + this.getAccion() +
                "\n Estado: " + this.getEstado() +
                "\n Cuerpo solicitud: " + this.getCuerpoSolicitud() +
                "\n Cuerpo respuesta: " + cuerpoRespuesta;
    }
}
