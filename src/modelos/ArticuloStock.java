package modelos;

import excepciones.ArticuloException;
import validadores.ArticuloStockValidador;

public class ArticuloStock extends Articulo {
    private Double precioUnitario;

    private ArticuloStock(String nombre, int stockDisponible, Double precioUnitario) throws ArticuloException {
        Articulo art = new Articulo.Builder()
                .setStockDisponible(stockDisponible)
                .setProducto(nombre)
                .build();

        this.setProducto(art.getProducto());
        this.setStockDisponible(art.getStockDisponible());
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
        return "#" + id + " [ " + producto + " | Precio x unidad: " + precioUnitario + " - Stock: " + stockDisponible + " ]";
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
            return new ArticuloStock(producto, stockDisponible, precioUnitario);
        }
    }
}