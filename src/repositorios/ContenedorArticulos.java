package repositorios;

import excepciones.ArticuloException;
import modelos.ArticuloStock;
import repositorios.data.ArticuloData;

public class ContenedorArticulos extends Repositorio<ArticuloStock> {
    private static ContenedorArticulos singleton;

    private ContenedorArticulos() throws ArticuloException {
        datos = ArticuloData.cargarDatos();
    }

    public static ContenedorArticulos getSingleton() throws ArticuloException {
        if(singleton == null) {
            singleton = new ContenedorArticulos();
        }
        return singleton;
    }

    @Override
    protected int identificador(ArticuloStock registro) {
        return registro.getId();
    }
}
