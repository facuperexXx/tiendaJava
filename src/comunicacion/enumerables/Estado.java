package comunicacion.enumerables;

import interfaces.iSerializable;

public enum Estado implements iSerializable<Estado> {
    PENDIENTE(11, "Pendiente", "Solicitud pendiente"),
    OK(22, "Realizado", "Solicitud exitosa"),
    ERROR(33, "Fallo", "Solicitud no realizada");

    private final int codigo;
    private final String estado;
    private final String descripcion;

    Estado(int codigo, String estado, String descripcion) {
        this.codigo = codigo;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "[ " + codigo + " - Status: " + estado + " - " + descripcion + " ]";
    }

    @Override
    public String serializar() {
        return String.valueOf(codigo);
    }
}
