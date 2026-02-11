/*
    Notas de desarrollo:
        - El id del contructor debe cambiarse para que trabaje con el contenedor.

    Notas de uso:
    Para crear un modelos.Usuario, usar la clase interna Builder. Enviar datos aca y esta llamara un validador para
    inconsistencias en la información recibida.

    En caso de no haber errores, el usuario sera creado.

    Para agregar excepciones, ir a la clase validadores.UsuarioValidador.
 */

package modelos;

import enumerables.AccesoPerfil;
import excepciones.UsuarioException;
import validadores.UsuarioValidador;

public class Usuario {
    private final int id;
    private int dni;
    private String nombre;
    private String userName;
    private String password;
    private AccesoPerfil permisos;

    private Usuario(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public AccesoPerfil getPermisos() {
        return permisos;
    }

    public int getId() {
        return id;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Usuario setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Usuario setPassword(String pass) {
        this.password = pass;
        return this;
    }

    public Usuario setPermisos(int nivel) {
        // Usar numero de nivel para definir permisos.

        for(AccesoPerfil acceso : AccesoPerfil.values()) {
            if(nivel == acceso.getNivel()) {
                this.permisos = acceso;
            }
        }
        return this;
    }

    public Usuario setDni(int dni) {
        this.dni = dni;
        return this;
    }

    @Override
    public String toString() {
        return "#" + id + " [ Nombre: " + nombre + " - DNI: " + dni + " - modelos.Usuario: " + userName + " - Pass: "
                + password + " - Permisos: " + permisos.getPermiso() + " ]";
    }

    // Builder de la clase (clase interna)
    public static class Builder {
        private int dni;
        private String nombre;
        private String userName;
        private String password;
        private int nivelPermisos;

        public Builder setDni(int dni) {
            this.dni = dni;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPass(String pass) {
            this.password = pass;
            return this;
        }

        public Builder setPermisos(int nivel) {
            this.nivelPermisos = nivel;
            return this;
        }

        public Usuario build() throws UsuarioException {
                UsuarioValidador.validar(dni, nombre, userName, password, nivelPermisos);

                // Recordatorio: el id debe calcularse segun los registros del inventario (contenedor)
                return new Usuario(1)
                        .setNombre(nombre)
                        .setDni(dni)
                        .setUserName(userName)
                        .setPassword(password)
                        .setPermisos(nivelPermisos);
        }
    }
}
