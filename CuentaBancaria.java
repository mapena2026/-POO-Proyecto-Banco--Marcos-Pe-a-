package pooproyectobanco;
// CuentaBancaria.java
public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;
    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            totalTransacciones++;
            System.out.printf("Deposito exitoso: L. %.2f%n", monto);
        } else {
            System.out.println("Error: el monto del deposito debe ser mayor que cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo = saldo - monto;
            totalTransacciones++;
            System.out.printf("Retiro exitoso: L. %.2f%n", monto);
            return true;
        } else {
            System.out.println("Error: monto invalido o saldo insuficiente.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.printf("Saldo actual: L. %.2f%n", saldo);
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
}