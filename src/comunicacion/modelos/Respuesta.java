package comunicacion.modelos;

import java.util.HashMap;
import java.util.List;

public class Respuesta<T> extends Solicitud {
    private List<T> cuerpoRespuesta;

    public Respuesta(Solicitud peticion, List<T> bodyRespuesta) {
        super(peticion.getRecurso(), peticion.getAccion(), peticion.getEstado(), peticion.getUsuario(), peticion.getCuerpoSolicitud());
        this.cuerpoRespuesta = bodyRespuesta;
    }

    public List<T> getCuerpoRespuesta() {
        return cuerpoRespuesta;
    }

    @Override
    public String toString() {
        return "**** RESPUESTA ****" +
                "\n Recurso: " + this.getRecurso() +
                "\n Acción: " + this.getAccion() +
                "\n Usuario: " + this.getUsuario() +
                "\n Estado: " + this.getEstado() +
                "\n Cuerpo solicitud: " + this.getCuerpoSolicitud() +
                "\n Cuerpo respuesta: " + cuerpoRespuesta;


    }
}
