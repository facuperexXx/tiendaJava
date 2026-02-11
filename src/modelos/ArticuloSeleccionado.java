package modelos;

import excepciones.ArticuloException;
import validadores.ArticuloSeleccionadoValildador;

public class ArticuloSeleccionado {
    private int cantidadSeleccionada;
    private Double subtotal;
    private ArticuloStock seleccionado;

    public ArticuloSeleccionado(int codigo, int cantidad) throws ArticuloException {
        this.cantidadSeleccionada = cantidad;
        this.seleccionado = new ArticuloStock.Builder()
                .setProducto("Fideos")
                .setPrecioUnitario(5.0)
                .setStockDisponible(5)
                .build();       // Esta harcodeado. Usar parametro codigo para buscar y asignar con el contenedor.

        this. subtotal = getSubtotal();
    }

    public ArticuloSeleccionado setCantidadSeleccionada(int cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
        this.subtotal = getSubtotal();
        return this;
    }

    public int getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public Double getSubtotal() {
        return cantidadSeleccionada * seleccionado.getPrecioUnitario();
    }

    public ArticuloStock getSeleccionado() {
        return seleccionado;
    }

    @Override
    public String toString() {
        return "Seleccionado [ " + seleccionado.getId() + " - " + seleccionado.getProducto() + " | Cantidad: " +
                cantidadSeleccionada + " - PrecioUnidad: " + seleccionado.getPrecioUnitario() + " - Total: " + subtotal + " ]";
    }

    public static class Builder {
        private int codigo;
        private int cantidadSeleccionada;

        public Builder setCodigo(int codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder setCantidadSeleccionada(int cantidadSeleccionada) {
            this.cantidadSeleccionada = cantidadSeleccionada;
            return this;
        }

        public ArticuloSeleccionado build() throws ArticuloException {
            ArticuloSeleccionadoValildador.validar(codigo, cantidadSeleccionada);
            return new ArticuloSeleccionado(codigo, cantidadSeleccionada);
        }
    }
}
