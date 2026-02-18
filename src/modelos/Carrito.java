/*
    Notas:
        - Vincularlo a la sesion, despues de que el usuario se loguee.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Double totalCalculado = 0.0;
    private List<ArticuloSeleccionado> listaProductos;

    public Carrito() {
        listaProductos = new ArrayList<>();
    }

    public Double getTotalCalculado() {
        actualizarTotal();
        return totalCalculado;
    }

    public List<ArticuloSeleccionado> getListaProductos() {
        return listaProductos;
    }

    public void actualizarTotal() {
        this.totalCalculado = 0.0;

        for(ArticuloSeleccionado item : listaProductos) {
            this.totalCalculado += item.getSubtotal();
        }
    }

    @Override
    public String toString() {
        String listado = "\n *** Carrito *** ";

        for (ArticuloSeleccionado seleccionado : listaProductos) {
            listado += "\n " + seleccionado.toString();
        }
        listado += "\n *************** ";

        return listado;
    }
}
