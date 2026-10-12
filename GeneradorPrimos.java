public class GeneradorPrimos {
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
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método main opcional por si deseas probar esta clase de forma individual
    public static void main(String[] args) {
        GeneradorPrimos primos = new GeneradorPrimos(10);
        primos.mostrarPrimos();
    }
}
