package repositorios;

import modelos.Usuario;
import repositorios.data.UsuarioData;

public class UsuarioContenedor extends Repositorio<Usuario> {
    private static UsuarioContenedor singleton;

    private UsuarioContenedor() {
        datos = UsuarioData.cargarDatos();
    }

    public static UsuarioContenedor getSingleton() {
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
