package comunicacion.modelos;

public class Respuesta extends Solicitud {
    private String cuerpoRespuesta;

    public Respuesta(Solicitud peticion, String bodyRespuesta) {
        super(peticion.getRecurso(), peticion.getAccion(), peticion.getEstado(), peticion.getCuerpoSolicitud());
        this.cuerpoRespuesta = bodyRespuesta;
    }

    public String getCuerpoRespuesta() {
        return cuerpoRespuesta;
    }

    @Override
    public String toString() {
        return "**** RESPUESTA ****" +
                "\n Recurso: " + this.getRecurso() +
                "\n Acción: " + this.getAccion() +
                "\n comunicacion.enumerables.Estado: " + this.getEstado() +
                "\n Cuerpo solicitud: " + this.getCuerpoSolicitud() +
                "\n Cuerpo respuesta: " + cuerpoRespuesta;
    }
}
