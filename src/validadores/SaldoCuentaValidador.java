package validadores;

import excepciones.SaldoCuentaException;
import excepciones.UsuarioException;

public class SaldoCuentaValidador {
    public static void validar(int dni, Double saldo) throws SaldoCuentaException, UsuarioException {
        if(saldo < 0) {
            throw new SaldoCuentaException("Error validación SaldoCuenta: se ingreso saldo negativo.");
        }

        UsuarioValidador.validarDni(dni);
    }
}
