/*
    Notas de desarrollo:
        - El id del contructor debe cambiarse para que trabaje con el contenedor.
        - Definir logica para obtener saldo y crear cuenta para clientes.

    Notas de uso:
    Para crear un modelos.Usuario, usar la clase interna Builder. Enviar datos aca y esta llamara un validador para
    inconsistencias en la información recibida.

    En caso de no haber errores, el usuario sera creado.

    Para agregar excepciones, ir a la clase validadores.UsuarioValidador.
 */

package modelos;

import enumerables.AccesoPerfil;
import excepciones.SaldoCuentaException;
import excepciones.UsuarioException;
import interfaces.iSerializable;
import validadores.UsuarioValidador;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario implements iSerializable<Usuario> {
    private final int id;
    private int dni;
    private String nombre;
    private String userName;
    private String password;
    private AccesoPerfil permisos;
    private SaldoCuenta saldo;  // Sin usar. Pendiente para cuando hayan contenedor con datos.

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

    public SaldoCuenta getSaldo() {
        return saldo;
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

    public Usuario setSaldoCuenta(SaldoCuenta saldo) {
        this.saldo = saldo;
        return this;
    }

    @Override
    public String toString() {
        if(permisos == AccesoPerfil.CLIENTE) {
            return "#" + id + " [ Nombre: " + nombre + " - DNI: " + dni + " - Username: " + userName + " - Pass: "
                    + password + " - Permisos: " + permisos.getPermiso() + " | " + saldo.toString() + " ]";
        }
        return "#" + id + " [ Nombre: " + nombre + " - DNI: " + dni + " - Username: " + userName + " - Pass: "
                + password + " - Permisos: " + permisos.getNivel() + " ]";
    }

    @Override
    public String serializar() {
        return codificar();
    }

    private String codificar() {
        String cadenaFinal = "";

        cadenaFinal = "{id=" + id + ",nombre=" + nombre + ",dni=" + dni + ",perfil=" + permisos.getNivel() + ",saldo=" +
                saldo.getDineroDisponible() + ",username=" + userName + "}";

        return cadenaFinal;
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

        public Usuario build() throws UsuarioException, SaldoCuentaException {
            UsuarioValidador.validar(dni, nombre, userName, password, nivelPermisos);

            // Recordatorio: el id debe calcularse segun los registros del inventario (contenedor)
            Usuario nuevo = new Usuario(1)
                    .setNombre(nombre)
                    .setDni(dni)
                    .setUserName(userName)
                    .setPassword(password)
                    .setPermisos(nivelPermisos);

            if(nivelPermisos == AccesoPerfil.CLIENTE.getNivel()) {
                // Crear cuenta de saldo en caso de ser cliente.
                SaldoCuenta cuenta = new SaldoCuenta.Builder()
                        .setDniVinculado(dni)
                        .setDinero(0.0)
                        .build();

                nuevo.setSaldoCuenta(cuenta);
            }

            return nuevo;
        }
    }
}
