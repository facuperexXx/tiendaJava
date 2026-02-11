/*
    Agregar las validaciones de articulos aqui.
 */
package validadores;

import excepciones.ArticuloException;

public class ArticuloValidador {
    public static void validar(String producto, int stockDisponible) throws ArticuloException {
        if(producto.isBlank()) {
            throw new ArticuloException("Error de validacion Articulo: Nombre del producto vacio.");
        }

        if(stockDisponible <= 0) {
            throw new ArticuloException("Error de validacion Articulo: Se ingreso stock negativo.");
        }
    }
}
