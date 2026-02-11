package validadores;

import excepciones.ArticuloException;

public class ArticuloSeleccionadoValildador {
    public static void validar(int codigo, int cantidad) throws ArticuloException {
        if(codigo <= 0) {
            throw new ArticuloException("Error validación ArticuloSeleccionado: Codigo invalido.");
        }

        if(cantidad <= 0) {
            throw new ArticuloException("Error validación ArticuloSeleccionado: Cantidad seleccionada negativa.");
        }
    }
}
