package validadores;

import excepciones.ArticuloException;

public class ArticuloStockValidador {
    public static void validar(String producto, int stock, Double precioUnitario) throws ArticuloException {
        // Falta verificar existencia con el contenedor.

        if(producto.isBlank()) {
            throw new ArticuloException("Error de validacion ArticuloStock: Nombre del producto vacio.");
        }

        if(stock <= 0) {
            throw new ArticuloException("Error de validacion ArticuloStock: Se ingreso stock negativo.");
        }

        if(precioUnitario <= 0) {
            throw new ArticuloException("Error de validacion ArticuloStock: Se ingreso precio unitario negativo.");
        }
    }
}
