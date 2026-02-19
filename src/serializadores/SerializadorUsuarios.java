package serializadores;

import modelos.Usuario;

import java.util.List;

public class SerializadorUsuarios implements iSerializador<List<Usuario>>{

    @Override
    public String serializar(List<Usuario> listaResultados) {
        String serial = "{";

        for(int i = 0; i < listaResultados.size(); i++) {
            serial += transformar(listaResultados.get(i));

            if(i < listaResultados.size()-1) {
                serial += ",";
            }
        }

        serial += "}";

        return serial;
    }

    private String transformar(Usuario u) {
        String texto = "";

        texto +=    "id=" + u.getId() +
                    "|nombre=" + u.getNombre() +
                    "|dni=" + u.getDni() +
                    "|nivel=" + u.getPermisos().getNivel() +
                    "|user=" + u.getUserName();

        return texto;
    }
}
