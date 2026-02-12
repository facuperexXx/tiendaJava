package repositorios;

import java.util.List;

/*
    - Falta la funcion de modificar datos.
 */

public abstract class Repositorio<T> {
    protected List<T> datos;

    protected abstract int identificador(T registro);

    public List<T> registros() {
        return datos;
    }

    // METODOS CRUD
    public void agregar(T nuevo) {
        if(!checkRegistro(identificador(nuevo))) {
            datos.add(nuevo);
        }
    }

    public T buscar(int id) {
        T encontrado = null;
        for(T e : datos) {
            if(identificador(e) == id) {
                encontrado = e;
            }
        }
        return encontrado;
    }

    public void borrar(int id) {
        T registro = buscar(id);
        datos.remove(registro);
    }

    // METODOS AUXILIARES
    public boolean checkRegistro(int id) {
        // True -> Existe en base de datos.
        Boolean check = false;
        if(buscar(id) != null) {
            check = true;
        }
        return check;
    }
}
