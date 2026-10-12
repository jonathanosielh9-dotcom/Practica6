import java.util.Scanner;

// 1. Clase del Ejercicio 1
class TablaMultiplicar {
    private int numero;

    public TablaMultiplicar(int numero) {
        this.numero = numero;
    }

    public void mostrarTabla() {
        System.out.println("--- Tabla del " + numero + " ---");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}

// 2. Clase del Ejercicio 2
class GeneradorPrimos {
    private int cantidad;

    public GeneradorPrimos(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarPrimos() {
        int contadorPrimos = 0;
        int numeroActual = 2;
        System.out.println("--- Los primeros " + cantidad + " numeros primos ---");
        while (contadorPrimos < cantidad) {
            if (esPrimo(numeroActual)) {
                System.out.print(numeroActual + " ");
                contadorPrimos++;
            }
            numeroActual++;
        }
        System.out.println();
    }

    private boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// 3. Clase del Ejercicio 3 (Cuenta Bancaria)
class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso.");
        } else {
            System.out.println("Monto inválido.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }
}

// 3. Clase del Cajero Automático
class Cajero {
    private CuentaBancaria cuenta;

    public Cajero(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.print("Monto a depositar: ");
                    cuenta.depositar(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Monto a retirar: ");
                    cuenta.retirar(scanner.nextDouble());
                    break;
                case 4:
                    System.out.println("Saliendo del cajero...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}

// Clase Principal con el método main obligatorio
public class Main {
    public static void main(String[] args) {
        // Prueba Ejercicio 1
        TablaMultiplicar tabla = new TablaMultiplicar(5);
        tabla.mostrarTabla();

        System.out.println();

        // Prueba Ejercicio 2
        GeneradorPrimos primos = new GeneradorPrimos(10);
        primos.mostrarPrimos();

        System.out.println();

        // Prueba Ejercicio 3 (Comenta esta línea si quieres probar solo los otros dos sin el menú interactivo)
        CuentaBancaria miCuenta = new CuentaBancaria(1500.0);
        Cajero cajero = new Cajero(miCuenta);
        cajero.iniciarMenu();
    }
}
