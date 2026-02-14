package repositorios;

import modelos.VentaExitosa;
import repositorios.data.VentaData;

public class ContenedorVentas extends Repositorio<VentaExitosa> {
    private static ContenedorVentas singleton;

    private ContenedorVentas() throws Exception {
        datos = VentaData.cargarDatos();
    }

    public static ContenedorVentas getSingleton() throws Exception {
        if(singleton == null) {
            singleton = new ContenedorVentas();
        }
        return singleton;
    }

    @Override
    protected int identificador(VentaExitosa registro) {
        return registro.getId();
    }
} 