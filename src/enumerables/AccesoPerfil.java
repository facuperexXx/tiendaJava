package enumerables;

public enum AccesoPerfil {
    EMPLEADO(1, "Empleado", "Administrador de la plataforma"),
    CLIENTE(2, "Cliente", "modelos.Usuario estandar de compra");

    private final int nivel;
    private final String permiso;
    private final String descripcion;

    AccesoPerfil(int nivel, String perfil, String descripcion) {
        this.nivel = nivel;
        this.permiso = perfil;
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public String getPermiso() {
        return permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "[ " + permiso + " - Nivel: " + nivel + " - " + descripcion + " ]";
    }
}
