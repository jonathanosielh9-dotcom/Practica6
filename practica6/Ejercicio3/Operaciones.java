package practica6;

import java.util.Scanner;

public class Operaciones {
    private double saldo;
    private Scanner scanner;

    public Operaciones() {
        this.saldo = 1000.0; // Saldo inicial 
        this.scanner = new Scanner(System.in);
    }

    // Método para validar fondos suficientes
    public boolean validarSaldo(double monto) {
        if (this.saldo < monto) {
            System.out.println("Fondos insuficientes");
            return false;
        }
        return true;
    }

    // Método para solicitar y filtrar montos numéricos válidos utilizando do-while
    private double solicitarMonto(String tipoOperacion) {
        double monto;
        do {
            System.out.print("Ingrese el monto a " + tipoOperacion + ": $");
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el salto de línea
                if (monto <= 0) {
                    System.out.println("Error: El monto debe ser mayor a 0. Intente de nuevo.");
                }
            } else {
                System.out.println("Error: Entrada no valida. Ingrese un valor numerico correcto.");
                scanner.nextLine(); // Limpiar entrada errónea
                monto = -1; // Fuerza a repetir el ciclo
            }
        } while (monto <= 0);

        return monto;
    }

    // Método Deposito 
    public void deposito() {
        double monto = solicitarMonto("depositar");
        this.saldo += monto;
        
        System.out.println("Deposito realizado");
        System.out.printf("Cantidad disponible en su cuenta: $%.2f%n", this.saldo);
    }

    // Método Retiro 
    public void retiro() {
        double monto = solicitarMonto("retirar");

        if (!validarSaldo(monto)) {
            return; 
        }

        this.saldo -= monto;
        System.out.println("Retiro realizado");
        System.out.printf("Saldo restante: $%.2f%n", this.saldo);
    }

    // Método ConsultaSaldo
    public void consultaSaldo() {
        System.out.printf("Saldo actual en la cuenta: $%.2f%n", this.saldo);
    }

    // Método Salir
    public void salir() {
        System.out.println("Gracias por utilizar el cajero automatico. Que tenga un buen dia.");
    }
}
