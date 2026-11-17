
import java.util.Scanner;

// Clase principal del programa Ruta Verde.
public class RutaVerde {

    // Valor mínimo permitido para los datos numéricos.
    static final int VALOR_MINIMO = 0;

    // Método principal: coordina la ejecución del programa.
    public static void main(String[] args) {

        // Solicita la cantidad de puntos de recolección.
        int cantidadPuntos = Reutilizacion.ingresarEnteroMayorQue(
                "Cantidad de puntos: ", VALOR_MINIMO);

        // Ingresa los nombres de los puntos de recolección.
        String[] nombres = Reutilizacion.ingresarNTextos(
                "Nombre del punto: ", cantidadPuntos);

        // Ingresa los códigos de identificación de cada punto.
        String[] codigos = Reutilizacion.ingresarNTextos(
                "Codigo del punto: ", cantidadPuntos);

        // Ingresa los materiales recolectados en cada punto.
        String[] materiales = Reutilizacion.ingresarNTextos(
                "Material: ", cantidadPuntos);

        // Ingresa los kilogramos recolectados en cada punto.
        double[] kilogramos = ingresarNCantidades(
                "Kilogramos recolectados: ", cantidadPuntos);

        // Ingresa el valor pagado por cada kilogramo.
        double[] valores = ingresarNCantidades(
                "Valor por kilogramo: ", cantidadPuntos);

        // Calcula el valor total pagado durante la jornada.
        double total = calcularTotalPagado(kilogramos, valores);

        // Obtiene la posición del punto con mayor recolección.
        int mayor = buscarMayorRecoleccion(kilogramos);

        // Genera un arreglo con los códigos sin duplicados.
        String[] codigosUnicos = filtrarCodigosUnicos(codigos);

        // Combina los nombres y los materiales en un nuevo arreglo.
        String[] combinados = combinarArreglos(nombres, materiales);

        // Presenta la información registrada y los resultados.
        generarMensaje(nombres, codigos, materiales, kilogramos,
                valores, total, mayor, codigosUnicos, combinados);
    }

    // Ingresa una cantidad determinada de valores reales y los almacena
    // en un arreglo.
    public static double[] ingresarNCantidades(
            String mensaje, int cantidad) {

        double[] resultado = new double[cantidad];

        // Recorre el arreglo para solicitar cada uno de sus valores.
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = Reutilizacion.ingresarDoubleMayorQue(
                    mensaje, VALOR_MINIMO);
        }

        return resultado;
    }

    // Calcula el valor total pagado por todos los puntos de recolección.
    public static double calcularTotalPagado(
            double[] kilogramos, double[] valores) {

        double total = 0;

        // Multiplica los kilogramos por su valor correspondiente
        // y acumula los resultados.
        for (int i = 0; i < kilogramos.length; i++) {
            total += kilogramos[i] * valores[i];
        }

        return total;
    }

    // Busca y devuelve la posición del punto con mayor cantidad
    // de kilogramos recolectados.
    public static int buscarMayorRecoleccion(double[] kilogramos) {

        // Inicialmente se considera que el primer punto tiene el máximo.
        int mayor = 0;

        // Compara los demás elementos con el valor máximo encontrado.
        for (int i = 1; i < kilogramos.length; i++) {
            if (kilogramos[i] > kilogramos[mayor]) {
                mayor = i;
            }
        }

        return mayor;
    }

    // Genera un nuevo arreglo que contiene los códigos sin repetir.
    public static String[] filtrarCodigosUnicos(String[] codigos) {

        // Arreglo temporal para almacenar los códigos únicos.
        String[] temporal = new String[codigos.length];

        // Cuenta la cantidad de códigos diferentes encontrados.
        int contador = 0;

        // Recorre todos los códigos del arreglo original.
        for (int i = 0; i < codigos.length; i++) {

            // Indica si el código actual ya se encuentra almacenado.
            boolean existe = false;

            // Compara el código actual con los códigos únicos encontrados.
            for (int j = 0; j < contador; j++) {
                if (codigos[i].equals(temporal[j])) {
                    existe = true;
                }
            }

            // Si el código no existe, se agrega al arreglo temporal.
            if (!existe) {
                temporal[contador] = codigos[i];
                contador++;
            }
        }

        // Crea el arreglo definitivo con el tamaño exacto de códigos únicos.
        String[] resultado = new String[contador];

        // Copia los códigos únicos al nuevo arreglo.
        for (int i = 0; i < contador; i++) {
            resultado[i] = temporal[i];
        }

        return resultado;
    }

    // Combina los nombres y materiales alternando sus elementos.
    public static String[] combinarArreglos(
            String[] nombres, String[] materiales) {

        // El nuevo arreglo necesita dos posiciones por cada punto.
        String[] resultado = new String[nombres.length * 2];

        // Almacena primero el nombre y después el material correspondiente.
        for (int i = 0; i < nombres.length; i++) {
            resultado[i * 2] = nombres[i];
            resultado[i * 2 + 1] = materiales[i];
        }

        return resultado;
    }

    // Construye y presenta el resumen de la información registrada.
    public static void generarMensaje(
            String[] nombres, String[] codigos, String[] materiales,
            double[] kilogramos, double[] valores, double total,
            int mayor, String[] unicos, String[] combinados) {

        // Inicializa el mensaje con el encabezado de la empresa.
        String mensaje = "\n===== RUTA VERDE S.A.S. =====";

        mensaje += "\n\nINFORMACION DE LOS PUNTOS:";

        // Agrega al mensaje los datos y el valor de cada punto.
        for (int i = 0; i < nombres.length; i++) {
            mensaje += "\n\nPunto: " + nombres[i];
            mensaje += "\nCodigo: " + codigos[i];
            mensaje += "\nMaterial: " + materiales[i];
            mensaje += "\nKilogramos: " + kilogramos[i];
            mensaje += "\nValor por kilogramo: " + valores[i];
            mensaje += "\nTotal del punto: "
                    + (kilogramos[i] * valores[i]);
        }

        // Agrega el valor total pagado durante la jornada.
        mensaje += "\n\nTOTAL PAGADO: $" + total;

        // Utiliza la posición encontrada para mostrar el punto con mayor
        // cantidad de kilogramos recolectados.
        mensaje += "\n\nPUNTO CON MAYOR RECOLECCION:";
        mensaje += "\nNombre: " + nombres[mayor];
        mensaje += "\nCodigo: " + codigos[mayor];
        mensaje += "\nKilogramos: " + kilogramos[mayor];

        // Agrega al mensaje los códigos de identificación sin duplicados.
        mensaje += "\n\nCODIGOS UNICOS:";

        for (int i = 0; i < unicos.length; i++) {
            mensaje += "\n" + unicos[i];
        }

        // Presenta el arreglo que combina nombres y materiales.
        mensaje += "\n\nNOMBRES Y MATERIALES COMBINADOS:";

        for (int i = 0; i < combinados.length; i++) {
            mensaje += "\n" + combinados[i];
        }

        // Muestra el resumen completo en la terminal.
        System.out.println(mensaje);
    }
}

// Clase auxiliar para reutilizar métodos de ingreso de información.
class Reutilizacion {

    // Scanner compartido para leer los datos ingresados por el usuario.
    static Scanner sc = new Scanner(System.in);

    // Solicita un texto y devuelve el contenido ingresado.
    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    // Solicita varios textos y los almacena en un arreglo.
    public static String[] ingresarNTextos(String mensaje, int cantidad) {

        String[] textos = new String[cantidad];

        // Repite el ingreso de texto según la cantidad solicitada.
        for (int i = 0; i < cantidad; i++) {
            textos[i] = ingresarTexto(mensaje);
        }

        return textos;
    }

    // Solicita un entero y repite el ingreso mientras no supere el límite.
    public static int ingresarEnteroMayorQue(
            String mensaje, int limite) {

        int numero;

        do {
            System.out.print(mensaje);
            numero = sc.nextInt();

            // Limpia el salto de línea pendiente del Scanner.
            sc.nextLine();

        } while (numero <= limite);

        return numero;
    }

    // Solicita un número real y repite el ingreso mientras no supere
    // el límite establecido.
    public static double ingresarDoubleMayorQue(
            String mensaje, double limite) {

        double numero;

        do {
            System.out.print(mensaje);
            numero = sc.nextDouble();

            // Limpia el salto de línea pendiente del Scanner.
            sc.nextLine();

        } while (numero <= limite);

        return numero;
    }
}
