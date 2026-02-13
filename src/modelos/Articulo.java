package modelos;

public abstract class Articulo {
    protected final int id;
    protected String producto;
    protected int stockDisponible;

    protected static int contadorArticulos = 0;

    protected Articulo(int id) {
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
}
