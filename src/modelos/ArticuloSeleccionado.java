package modelos;

import excepciones.ArticuloException;
import repositorios.ContenedorArticulos;
import repositorios.Repositorio;
import validadores.ArticuloSeleccionadoValidador;

public class ArticuloSeleccionado {
    private int cantidadSeleccionada;
    private Double subtotal;
    private ArticuloStock seleccionado;

    private ArticuloSeleccionado(int codigo, int cantidad) throws ArticuloException {
        Repositorio<ArticuloStock> repo = ContenedorArticulos.getSingleton();

        this.cantidadSeleccionada = cantidad;
        this.seleccionado = repo.buscar(codigo);

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
            ArticuloSeleccionadoValidador.validar(codigo, cantidadSeleccionada);
            return new ArticuloSeleccionado(codigo, cantidadSeleccionada);
        }
    }
}
