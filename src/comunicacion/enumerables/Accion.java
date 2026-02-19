package comunicacion.enumerables;

public enum Accion {
    CREAR(501, "crear"),
    MODIFICAR(502, "modificar"),
    BORRAR(503, "borrar"),
    CONSULTAR(504, "consultar");

    private int codigo;
    private String accion;

    Accion(int codigo, String accion) {
        this.codigo = codigo;
        this.accion = accion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getAccion() {
        return accion;
    }

    @Override
    public String toString() {
        return "[ " + codigo + " - " + accion + " ]";
    }

    public static Accion definirAccion(String accion) throws Exception {
        for(Accion a : Accion.values()) {
            if(accion.equalsIgnoreCase(a.getAccion())) {
                return a;
            }
        }
        throw new Exception("Error: Accion no definida.");
    }
}
