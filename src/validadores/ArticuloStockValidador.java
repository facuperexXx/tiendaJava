package validadores;

import excepciones.ArticuloException;

public class ArticuloStockValidador {
    public static void validar(String producto, int stock, Double precioUnitario) throws ArticuloException {
        ArticuloValidador.validar(producto, stock);

        if(precioUnitario <= 0) {
            throw new ArticuloException("Error de validacion ArticuloStock: Se ingreso precio unitario negativo.");
        }
    }
}
