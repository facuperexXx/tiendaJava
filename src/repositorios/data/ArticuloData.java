package repositorios.data;

import excepciones.ArticuloException;
import modelos.ArticuloStock;

import java.util.ArrayList;
import java.util.List;

public class ArticuloData {
    public static List<ArticuloStock> cargarDatos() throws ArticuloException {
        List<ArticuloStock> listado = new ArrayList<>();

        try {
            ArticuloStock a1 = new ArticuloStock.Builder()
                    .setProducto("Oreo")
                    .setStockDisponible(5)
                    .setPrecioUnitario(10.0)
                    .build();

            ArticuloStock a2 = new ArticuloStock.Builder()
                    .setProducto("Leche")
                    .setStockDisponible(7)
                    .setPrecioUnitario(5.0)
                    .build();

            ArticuloStock a3 = new ArticuloStock.Builder()
                    .setProducto("Alfajor")
                    .setStockDisponible(3)
                    .setPrecioUnitario(15.0)
                    .build();

            listado.add(a1);
            listado.add(a2);
            listado.add(a3);

        } catch (Exception e) {
            throw new ArticuloException(e.getMessage());
        }

        return listado;
    }
}
