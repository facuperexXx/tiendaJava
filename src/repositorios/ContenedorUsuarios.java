package repositorios;

import excepciones.UsuarioException;
import modelos.Usuario;
import repositorios.data.UsuarioData;

public class ContenedorUsuarios extends Repositorio<Usuario> {
    private static ContenedorUsuarios singleton;

    private ContenedorUsuarios() throws UsuarioException {
        datos = UsuarioData.cargarDatos();
    }

    public static ContenedorUsuarios getSingleton() throws UsuarioException {
        if(singleton == null) {
            singleton = new ContenedorUsuarios();
        }
        return singleton;
    }

    @Override
    protected int identificador(Usuario registro) {
        return registro.getDni();
    }
}
