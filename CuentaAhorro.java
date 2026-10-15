package pooproyectobanco;
// CuentaAhorro.java
public class CuentaAhorro extends CuentaBancaria {

    public double tasaInteresAnual;
    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }

    public boolean retirarConComision(double monto) {
        boolean exito;

        if (retirosRealizadosMes >= 3) {
            // A partir del 4to retiro se suma la comision al monto
            exito = retirar(monto + comisionPorExceso);
            if (exito) {
                System.out.printf("Se cobro una comision de L. %.2f%n", comisionPorExceso);
            }
        } else {
            exito = retirar(monto);
        }

        // El contador solo sube si el retiro fue exitoso
        if (exito) {
            retirosRealizadosMes++;
        }
        return exito;
    }

    public void aplicarInteresMensual() {
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
    }
}