/*
    Uso exclusivo de la clase modelos.Usuario.
    Para agregar nuevas validadores, hacerlo en el metodo validar().
 */

package validadores;

import enumerables.AccesoPerfil;
import excepciones.UsuarioException;

public class UsuarioValidador {
    public static void validar(int dni, String nombre, String userName, String pass, int nivelPermisos) throws UsuarioException {
        if(nombre.isBlank()) {
            throw new UsuarioException("Error de validación Usuario: Nombre de usuario en blanco.");
        }

        if(userName.isBlank()) {
            throw new UsuarioException("Error de validación Usuario: UserName en blanco.");
        }

        if(!checkNivel(nivelPermisos)) {
            throw new UsuarioException("Error de validación Usuario: Perfil no existe");
        }

        if(pass.length() < 6 || pass.isBlank()) {
            throw new UsuarioException("Error de validación Usuario: Contraseña no cumple con los requisitos.");
        }

        validarDni(dni);
    }

    public static void validarDni(int dni) throws UsuarioException {
        if(dni <= 1000) {
            throw new UsuarioException("Error de validación Usuario: dni fuera de rango.");
        }
    }

    private static boolean checkNivel(int nivel) {
        boolean check = false;

        for(AccesoPerfil a : AccesoPerfil.values()) {
            if(nivel == a.getNivel()) {
                check = true;
            }
        }
        return check;
    }
}
