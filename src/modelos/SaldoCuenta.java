package modelos;

import excepciones.SaldoCuentaException;
import excepciones.UsuarioException;
import validadores.SaldoCuentaValidador;

public class SaldoCuenta {
    private int dniVinculado;
    private Double dineroDisponible;

    public SaldoCuenta(int dni, Double dinero) {
        this.dniVinculado = dni;
        this.dineroDisponible = dinero;
    }

    public SaldoCuenta setDniVinculado(int dniVinculado) {
        this.dniVinculado = dniVinculado;
        return this;
    }

    public SaldoCuenta setDineroDisponible(Double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
        return this;
    }

    public int getDniVinculado() {
        return dniVinculado;
    }

    public Double getDineroDisponible() {
        return dineroDisponible;
    }

    @Override
    public String toString() {
        return "Saldo: $" + dineroDisponible;
    }

    public static class Builder {
        private int dniVinculado;
        private Double dinero = 0.0;

        public Builder setDniVinculado(int dniVinculado) {
            this.dniVinculado = dniVinculado;
            return this;
        }

        public Builder setDinero(Double dinero) {
            this.dinero = dinero;
            return this;
        }

        public SaldoCuenta build() throws SaldoCuentaException, UsuarioException {
            SaldoCuentaValidador.validar(dniVinculado, dinero);
            return new SaldoCuenta(dniVinculado, dinero);
        }
    }
}
