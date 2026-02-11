package validadores;

import excepciones.VentaExitosaException;
import modelos.ArticuloSeleccionado;

import java.util.List;

public class VentaExitosaValidador {
    public static void validar(List<ArticuloSeleccionado> listado, int idCLiente, Double total) throws VentaExitosaException {
        if(listado.size() <= 0) {
            throw new VentaExitosaException("Error validacion venta: Carrito vacio.");
        }

        if(idCLiente <= 0) {
            throw new VentaExitosaException("Error validacion venta: Usuario no identificado.");
        }

        if(total <= 0) {
            throw new VentaExitosaException("Error validacion venta: total no calculado.");
        }
    }
}
