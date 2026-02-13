package repositorios;

import excepciones.UsuarioException;
import modelos.Usuario;
import repositorios.data.UsuarioData;

public class UsuarioContenedor extends Repositorio<Usuario> {
    private static UsuarioContenedor singleton;

    private UsuarioContenedor() throws UsuarioException {
        datos = UsuarioData.cargarDatos();
    }

    public static UsuarioContenedor getSingleton() throws UsuarioException {
        if(singleton == null) {
            singleton = new UsuarioContenedor();
        }
        return singleton;
    }

    @Override
    protected int identificador(Usuario registro) {
        return registro.getDni();
    }
}
