
import java.util.Scanner;

public class Reutilizacion {

    private static final Scanner scanner = new Scanner(System.in);

    public static int ingresarEntero(String mensaje) {
        System.out.print(mensaje);

        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un numero entero.");
            scanner.next();
            System.out.print(mensaje);
        }

        int valor = scanner.nextInt();
        scanner.nextLine();

        return valor;
    }

    public static double ingresarRealD(String mensaje) {
        System.out.print(mensaje);

        while (!scanner.hasNextDouble()) {
            System.out.println("Ingrese un numero valido.");
            scanner.next();
            System.out.print(mensaje);
        }

        double valor = scanner.nextDouble();
        scanner.nextLine();

        return valor;
    }

    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine();

        return texto;
    }

    public static int ingresarEnteroMayorQue(String mensaje, int valorMinimo) {
        int valor = ingresarEntero(mensaje);

        while (valor <= valorMinimo) {
            System.out.println("El valor debe ser mayor que " + valorMinimo);
            valor = ingresarEntero(mensaje);
        }

        return valor;
    }

    public static double ingresarRealMayorQue(String mensaje, double valorMinimo) {
        double valor = ingresarRealD(mensaje);

        while (valor <= valorMinimo) {
            System.out.println("El valor debe ser mayor que " + valorMinimo);
            valor = ingresarRealD(mensaje);
        }

        return valor;
    }

    public static String[] ingresarNTextos(String mensaje, int cantidad) {
        String[] textos = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            textos[i] = ingresarTexto(mensaje + " (" + (i + 1) + " de " + cantidad + "): ");
        }

        return textos;
    }

    public static int[] ingresarNEnterosMayoresQue(
            String mensaje, int cantidad, int limiteInferior) {

        int[] valores = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            valores[i] = ingresarEnteroMayorQue(
                    mensaje + " (" + (i + 1) + " de " + cantidad + "): ",
                    limiteInferior);
        }

        return valores;
    }

    public static double[] ingresarNRealesMayoresQue(
            String mensaje, int cantidad, double limiteInferior) {

        double[] valores = new double[cantidad];

        for (int i = 0; i < cantidad; i++) {
            valores[i] = ingresarRealMayorQue(
                    mensaje + " (" + (i + 1) + " de " + cantidad + "): ",
                    limiteInferior);
        }

        return valores;
    }
}
