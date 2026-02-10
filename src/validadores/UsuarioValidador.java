package validadores;/*
    Uso exclusivo de la clase modelos.Usuario.
    Para agregar nuevas validadores, hacerlo en el metodo validar().
 */

import enumerables.AccesoPerfil;
import excepciones.UsuarioException;

public class UsuarioValidador {
    public static void validar(int dni, String nombre, String userName, String pass, int nivelPermisos) throws UsuarioException {
        if(dni <= 10000) {
            throw new UsuarioException("Error de validación modelos.Usuario: dni fuera de rango.");
        }

        if(nombre.isBlank()) {
            throw new UsuarioException("Error de validación modelos.Usuario: Nombre de usuario en blanco.");
        }

        if(userName.isBlank()) {
            throw new UsuarioException("Error de validación modelos.Usuario: UserName en blanco.");
        }

        if(!checkNivel(nivelPermisos)) {
            throw new UsuarioException("Error de validación modelos.Usuario: Perfil no existe");
        }

        if(pass.length() < 6 || pass.isBlank()) {
            throw new UsuarioException("Error de validación modelos.Usuario: Contraseña no cumple con los requisitos.");
        }
    }

    private static boolean checkNivel(int nivel) {
        Boolean check = false;

        for(AccesoPerfil a : AccesoPerfil.values()) {
            if(nivel == a.getNivel()) {
                check = true;
            }
        }
        return check;
    }
}
