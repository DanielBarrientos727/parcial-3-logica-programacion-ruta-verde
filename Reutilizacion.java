
import java.util.Scanner;

/**
 * Clase de utilidades para la reutilización de código.
 * Contiene métodos estáticos para solicitar y validar
 * datos ingresados por el usuario mediante consola.
 *
 * Permite trabajar con números enteros, números decimales,
 * cadenas de texto y arreglos de diferentes tipos de datos.
 *
 * @author Daniel Barrientos
 * @version v1.0
 */

 /**
 * Descripción de la clase o método.
 *
 * @param nombre Parámetro recibido.
 * @return Resultado devuelto.
 * @author Autor del código.
 * @version 1.0
 * @since 1.0
 * @throws Exception Descripción del error.
 * @see OtraClase
 * @deprecated Elemento obsoleto.
 */
 
 
 //Leer: https://sergarb1.github.io/ApuntesProgramacion/02-introduccion/05-comentarios/
 //Leer: https://prabasco.github.io/PRG/ut/ut03/035_ComentariosEstructurados.html
 
public class Reutilizacion {

    /**
     * Objeto Scanner compartido por todos los métodos
     * de la clase para leer datos desde la entrada estándar.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Solicita un número entero al usuario y valida que
     * la entrada corresponda a un valor de tipo int.
     * Si el dato ingresado no es válido, vuelve a solicitarlo.
     *
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Número entero ingresado por el usuario.
     */
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

    /**
     * Solicita un número decimal al usuario y valida
     * que la entrada corresponda a un valor de tipo double.
     * Si el dato ingresado no es válido, vuelve a solicitarlo.
     *
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Número decimal ingresado por el usuario.
     */
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

    /**
     * Solicita una cadena de texto al usuario y lee
     * la línea completa ingresada, incluyendo espacios.
     *
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Cadena de texto ingresada.
     */
    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        String texto = scanner.nextLine();

        return texto;
    }

    /**
     * Solicita un número entero y valida que sea
     * estrictamente mayor que el límite mínimo establecido.
     * Si no cumple la condición, vuelve a solicitarlo.
     *
     * @param mensaje Mensaje que se muestra al usuario.
     * @param valorMinimo Valor mínimo que debe superar el número.
     * @return Número entero que cumple la condición.
     */
    public static int ingresarEnteroMayorQue(String mensaje, int valorMinimo) {
        int valor = ingresarEntero(mensaje);

        while (valor <= valorMinimo) {
            System.out.println("El valor debe ser mayor que " + valorMinimo);
            valor = ingresarEntero(mensaje);
        }

        return valor;
    }

    /**
     * Solicita un número decimal y valida que sea
     * estrictamente mayor que el límite mínimo establecido.
     * Si no cumple la condición, vuelve a solicitarlo.
     *
     * @param mensaje Mensaje que se muestra al usuario.
     * @param valorMinimo Valor mínimo que debe superar el número.
     * @return Número decimal que cumple la condición.
     */
    public static double ingresarRealMayorQue(String mensaje, double valorMinimo) {
        double valor = ingresarRealD(mensaje);

        while (valor <= valorMinimo) {
            System.out.println("El valor debe ser mayor que " + valorMinimo);
            valor = ingresarRealD(mensaje);
        }

        return valor;
    }

    /**
     * Crea un arreglo de cadenas de texto con la cantidad
     * de posiciones indicada y solicita cada elemento
     * mediante un ciclo for.
     *
     * @param mensaje Mensaje que se muestra al solicitar cada texto.
     * @param cantidad Cantidad de textos que se van a ingresar.
     * @return Arreglo de cadenas de texto ingresadas.
     */
    public static String[] ingresarNTextos(String mensaje, int cantidad) {
        String[] textos = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            textos[i] = ingresarTexto(mensaje + " (" + (i + 1) + " de " + cantidad + "): ");
        }

        return textos;
    }

    /**
     * Crea un arreglo de números enteros y solicita
     * cada elemento mediante un ciclo for.
     * Valida que todos los números sean mayores
     * que el límite inferior establecido.
     *
     * @param mensaje Mensaje que se muestra al solicitar cada número.
     * @param cantidad Cantidad de números que se van a ingresar.
     * @param limiteInferior Valor mínimo que deben superar los números.
     * @return Arreglo de números enteros ingresados y validados.
     */
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

    /**
     * Crea un arreglo de números decimales y solicita
     * cada elemento mediante un ciclo for.
     * Valida que todos los números sean mayores
     * que el límite inferior establecido.
     *
     * @param mensaje Mensaje que se muestra al solicitar cada número.
     * @param cantidad Cantidad de números que se van a ingresar.
     * @param limiteInferior Valor mínimo que deben superar los números.
     * @return Arreglo de números decimales ingresados y validados.
     */
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
