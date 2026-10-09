package practica6;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Operaciones operaciones;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.operaciones = new Operaciones();
    }

    public void mostrarMenu() {
        int opcion = 0;

        // Estructura do-while para mantener el menú repetitivo
        do {
            System.out.println("\n\t CAJERO AUTOMATICO");
            System.out.println("1. Deposito");
            System.out.println("2. Retiro");
            System.out.println("3. Consulta de saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion (1-4): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        operaciones.deposito();
                        break;
                    case 2:
                        operaciones.retiro();
                        break;
                    case 3:
                        operaciones.consultaSaldo();
                        break;
                    case 4:
                        operaciones.salir();
                        break;
                    default:
                        System.out.println("Error: Opcion fuera del rango (1-4). Por favor intente de nuevo.");
                }
            } else {
                System.out.println("Error: Entrada no valida (ha ingresado letras o simbolos). Ingrese un numero del 1 al 4.");
                scanner.next(); // Descartar lectura inválida
            }

        } while (opcion != 4); 
    }
}
