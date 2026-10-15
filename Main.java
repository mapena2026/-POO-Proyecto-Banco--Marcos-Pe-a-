package pooproyectobanco;
// Main.java
public class Main {
    public static void main(String[] args) {

        // 1 y 2. Encapsulamiento y atributos publicos
        System.out.println("=== Prueba de encapsulamiento y atributos publicos ===");
        CuentaBancaria miCuenta = new CuentaBancaria("001", "Maria Lopez", 2000);

        // miCuenta.saldo = 50000;
        // Esta linea NO compila: saldo es private, solo se puede usar dentro de CuentaBancaria.

        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);
        miCuenta.depositar(500);
        miCuenta.retirar(300);
        miCuenta.mostrarDatos();

        // 3. Cuenta de ahorro con 4 retiros
        System.out.println("\n=== Prueba de CuentaAhorro ===");
        CuentaAhorro ahorro = new CuentaAhorro("002", "Carlos Mejia", 3000, 5);
        ahorro.retirarConComision(500);
        System.out.printf("Saldo: L. %.2f%n", ahorro.getSaldo());
        ahorro.retirarConComision(500);
        System.out.printf("Saldo: L. %.2f%n", ahorro.getSaldo());
        ahorro.retirarConComision(500);
        System.out.printf("Saldo: L. %.2f%n", ahorro.getSaldo());
        ahorro.retirarConComision(500); // 4to retiro: se cobra comision
        System.out.printf("Saldo: L. %.2f%n", ahorro.getSaldo());

        // 4. Interes mensual
        System.out.println("\n=== Rendimiento de ahorro ===");
        ahorro.aplicarInteresMensual();
        System.out.printf("Saldo despues del interes: L. %.2f%n", ahorro.getSaldo());

        // 5. Cuenta corriente con sobregiro
        System.out.println("\n=== Prueba de CuentaCorriente ===");
        CuentaCorriente corriente = new CuentaCorriente("003", "Ana Torres", 1000, "Inversiones Torres", 5000);
        corriente.retirarConSobregiro(3500);
        System.out.printf("Saldo: L. %.2f%n", corriente.getSaldo());
        System.out.printf("Sobregiro utilizado: L. %.2f%n", corriente.getSobregiroUtilizado());

        // 6. Pago de la deuda
        System.out.println("\n=== Amortizacion de deuda ===");
        corriente.pagarSobregiro(3000);
        System.out.printf("Saldo final: L. %.2f%n", corriente.getSaldo());
        System.out.printf("Sobregiro utilizado: L. %.2f%n", corriente.getSobregiroUtilizado());
    }
} 