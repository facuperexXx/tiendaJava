package comunicacion.decodificacion;

import comunicacion.enumerables.Accion;
import comunicacion.modelos.Solicitud;

import java.util.HashMap;

public class ParserSolicitud {

    String[] fragmentos = new String[4];
    HashMap<String, String> params;

    public ParserSolicitud() {
        params = new HashMap<>();
    }

    public Solicitud toSolicitud(String mensaje) throws Exception {
        limpiarVariables();

        String[] mensajePartes = mensaje.split("\\|");

        for(int i = 0; i < fragmentos.length; i++) {
            try {
                if(i == 3 && mensajePartes[i].startsWith("{") && mensajePartes[i].endsWith("}")) {
                    definirParams(mensajePartes[i]);
                } else {
                    fragmentos[i] = mensajePartes[i];
                }
            } catch (Exception e) {
                fragmentos[i] = "{}";
            }
        }

        String recurso = fragmentos[0];
        Accion accion = Accion.definirAccion(fragmentos[1]);
        int idUser = Integer.parseInt(fragmentos[2]);
        HashMap<String, String> parametros = new HashMap<>(params);

        return new Solicitud(recurso, accion, idUser, parametros);
    }

    private void limpiarVariables() {
        // Limpieza rapida de array: Arrays.fill(fragmentos, "");
        for(int i = 0; i < fragmentos.length; i++) {
            fragmentos[i] = "";
        }

        params.clear();
    }

    private void definirParams(String fragmento) {

        String fragmentoLimpio = fragmento.substring(1, fragmento.length()-1);

        String[] paramIndividual = fragmentoLimpio.split(",");

        for(String item : paramIndividual) {
            String[] valores = item.split("=");
            String clave = valores[0];
            String valor = valores[1];

            params.put(clave, valor);
        }
    }
}
