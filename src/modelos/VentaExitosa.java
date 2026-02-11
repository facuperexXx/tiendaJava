package modelos;

import excepciones.VentaExitosaException;
import validadores.VentaExitosaValidador;

import java.beans.VetoableChangeListener;
import java.util.List;

public class VentaExitosa {
    private final int id;
    private List<ArticuloSeleccionado> listaProductos;
    private int idCliente;
    private Double totalCompra;

    public VentaExitosa(int id) {
        this.id = id;
    }

    public List<ArticuloSeleccionado> getListaProductos() {
        return listaProductos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public VentaExitosa setListaProductos(List<ArticuloSeleccionado> listaProductos) {
        this.listaProductos = listaProductos;
        return this;
    }

    public VentaExitosa setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public VentaExitosa setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
        return this;
    }

    @Override
    public String toString() {
        String resumenCompra = "\n *** Resumen de compra ***";

        for(ArticuloSeleccionado item : listaProductos) {
            resumenCompra += "\n " + item.toString();
        }

        resumenCompra += "\n Total: $" + totalCompra;

        return resumenCompra;
    }

    public static class Builder {
        private List<ArticuloSeleccionado> listaProductos;
        private int idCliente;
        private Double totalCompra;

        public Builder setIdCliente(int idCliente) {
            this.idCliente = idCliente;
            return this;
        }

        public Builder setListaProductos(List<ArticuloSeleccionado> listaProductos) {
            this.listaProductos = listaProductos;
            return this;
        }

        public Builder setTotalCompra(Double totalCompra) {
            this.totalCompra = totalCompra;
            return this;
        }

        public VentaExitosa build() throws VentaExitosaException {
            VentaExitosaValidador.validar(listaProductos, idCliente, totalCompra);

            return new VentaExitosa(1)  // Nota: Obtener id con el contenedor.
                    .setIdCliente(idCliente)
                    .setListaProductos(listaProductos)
                    .setTotalCompra(totalCompra);

        }
    }
}
