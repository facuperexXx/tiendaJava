package repositorios.data;

import excepciones.ArticuloException;
import modelos.ArticuloSeleccionado;
import modelos.VentaExitosa;
import java.util.ArrayList;
import java.util.List;

// Precarga de ventas.

public class VentaData {
    public static List<VentaExitosa> cargarDatos() throws Exception {
        List<VentaExitosa> listado = new ArrayList<>();

        try {
            int clienteId = 1;

            List<ArticuloSeleccionado> carrito = VentaData.cargarCarrito();

            VentaExitosa venta1 = new VentaExitosa.Builder()
                    .setIdCliente(clienteId)
                    .setListaProductos(carrito)
                    .setTotalCompra()
                    .build();

            listado.add(venta1);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return listado;
    }

    private static List<ArticuloSeleccionado> cargarCarrito() throws ArticuloException {
        int producto1 = 1;
        int producto2 = 2;

        ArticuloSeleccionado a1 = new ArticuloSeleccionado.Builder()
                .setCodigo(producto1)
                .setCantidadSeleccionada(3)
                .build();

        ArticuloSeleccionado a2 = new ArticuloSeleccionado.Builder()
                .setCodigo(producto2)
                .setCantidadSeleccionada(2)
                .build();

        List<ArticuloSeleccionado> carrito = new ArrayList<>();
        carrito.add(a1);
        carrito.add(a2);

        return carrito;
    }
}
