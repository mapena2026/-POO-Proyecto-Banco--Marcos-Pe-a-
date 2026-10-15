package pooproyectobanco;
// CuentaCorriente.java
public class CuentaCorriente extends CuentaBancaria {

    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public boolean retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor que cero.");
            return false;
        }

        // Si el saldo alcanza, es un retiro normal
        if (getSaldo() >= monto) {
            return retirar(monto);
        }

        double faltante = monto - getSaldo();
        double recargo = faltante * 0.03;
        double creditoDisponible = limiteSobregiro - sobregiroUtilizado;

        // La deuda (faltante + recargo) no puede pasar del limite autorizado
        if (faltante + recargo > creditoDisponible) {
            System.out.println("Error: el retiro supera el limite de sobregiro autorizado.");
            return false;
        }

        // Se usa todo el saldo disponible
        if (getSaldo() > 0) {
            retirar(getSaldo());
        }

        // El recargo se suma una sola vez a la deuda
        sobregiroUtilizado = sobregiroUtilizado + faltante + recargo;

        System.out.printf("Sobregiro usado: L. %.2f%n", faltante);
        System.out.printf("Recargo del 3%%: L. %.2f%n", recargo);
        System.out.printf("Deuda total de sobregiro: L. %.2f%n", sobregiroUtilizado);
        return true;
    }

    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto del pago debe ser mayor que cero.");
            return;
        }

        if (monto >= sobregiroUtilizado) {
            double sobrante = monto - sobregiroUtilizado;
            sobregiroUtilizado = 0.0;
            System.out.println("Sobregiro pagado completamente.");
            if (sobrante > 0) {
                depositar(sobrante); // lo que sobra va al saldo
            }
        } else {
            sobregiroUtilizado = sobregiroUtilizado - monto;
            System.out.printf("Abono realizado. Deuda restante: L. %.2f%n", sobregiroUtilizado);
        }
    }
}