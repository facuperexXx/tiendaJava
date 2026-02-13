package modelos;

import excepciones.ArticuloException;
import validadores.ArticuloStockValidador;

public class ArticuloStock extends Articulo {
    private Double precioUnitario;

    private ArticuloStock(String nombre, int stockDisponible, Double precioUnitario) throws ArticuloException {
        super(contadorArticulos);

        this.producto = nombre;
        this.stockDisponible = stockDisponible;
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "#" + id + " [ " + producto + " | Precio x unidad: $" + precioUnitario + " - Stock: " + stockDisponible + " ]";
    }

    public static class Builder {
        private String producto;
        private int stockDisponible;
        private Double precioUnitario;

        public Builder setPrecioUnitario(Double precioUnitario) {
            this.precioUnitario = precioUnitario;
            return this;
        }

        public Builder setProducto(String producto) {
            this.producto = producto;
            return this;
        }

        public Builder setStockDisponible(int stockDisponible) {
            this.stockDisponible = stockDisponible;
            return this;
        }

        public ArticuloStock build() throws ArticuloException {
            ArticuloStockValidador.validar(producto, stockDisponible, precioUnitario);

            contadorArticulos++;

            return new ArticuloStock(producto, stockDisponible, precioUnitario);
        }
    }
}