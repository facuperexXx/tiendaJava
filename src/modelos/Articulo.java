package modelos;

import excepciones.ArticuloException;
import validadores.ArticuloValidador;

public class Articulo {
    protected int id;
    protected String producto;
    protected int stockDisponible;

    protected Articulo() {}

    private Articulo(int id) {
        this.id = id;
    }

    protected  int getId() {
        return this.id;
    }

    public String getProducto() {
        return producto;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public Articulo setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
        return this;
    }

    public Articulo setProducto(String producto) {
        this.producto = producto;
        return this;
    }

    @Override
    public String toString() {
        return "#" + id + " [ " + producto + " | Stock: " + stockDisponible + " ]";
    }

    public static class Builder {
        private String producto;
        private int stockDisponible;

        public Builder setProducto(String producto) {
            this.producto = producto;
            return this;
        }

        public Builder setStockDisponible(int stockDisponible) {
            this.stockDisponible = stockDisponible;
            return this;
        }

        public Articulo build() throws ArticuloException {
            ArticuloValidador.validar(producto, stockDisponible);

            // Recordatorio: asociar id a la base de datos.
            return new Articulo(1)
                    .setProducto(producto)
                    .setStockDisponible(stockDisponible);
        }
    }
}
