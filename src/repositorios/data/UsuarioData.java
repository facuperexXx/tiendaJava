package repositorios.data;

import modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

// Precarga de usuarios

public class UsuarioData {
    public static List<Usuario> cargarDatos() {
        List<Usuario> listado = new ArrayList<>();

        try {
            Usuario u1 = new Usuario.Builder()
                    .setDni(123456)
                    .setNombre("Lucas Gomez")
                    .setPermisos(1)
                    .setUserName("lc")
                    .setPass("123456")
                    .build();

            Usuario u2 = new Usuario.Builder()
                    .setDni(567890)
                    .setNombre("Lucia Paz")
                    .setPermisos(2)
                    .setUserName("lp")
                    .setPass("567890")
                    .build();

            Usuario u3 = new Usuario.Builder()
                    .setDni(222222)
                    .setNombre("Pablo Friaz")
                    .setPermisos(2)
                    .setUserName("pb")
                    .setPass("222222")
                    .build();

            listado.add(u1);
            listado.add(u2);
            listado.add(u3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listado;
    }
}
