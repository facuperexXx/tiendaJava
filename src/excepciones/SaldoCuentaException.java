package excepciones;

public class SaldoCuentaException extends Exception {
    public SaldoCuentaException(String mensaje) {
        super(mensaje);
    }
}
