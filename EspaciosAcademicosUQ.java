public class EspaciosAcademicosUQ {

    static final int VALOR_MINIMO = 0;

    public static void main(String[] args) {
        int cantidadEspacios = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de espacios académicos:", VALOR_MINIMO);
        String[] nombresEspacios = Reutilizacion.ingresarNTextos("Ingrese el nombre del espacio académico:", cantidadEspacios);
        int[] estudiantesMatriculados = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese la cantidad de estudiantes matriculados:", cantidadEspacios, VALOR_MINIMO);

        int cantidadImpares = contarEspaciosImpares(estudiantesMatriculados);
        String[] espaciosImpares = filtrarEspaciosImpares(nombresEspacios, estudiantesMatriculados);

        String mensaje = generarMensaje(cantidadImpares, espaciosImpares);
        mostrarMensaje(mensaje);
    }

    public static int contarEspaciosImpares(int[] estudiantes) {
        int contador = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] % 2 != 0) {
                contador++;
            }
        }
        return contador;
    }

    public static String[] filtrarEspaciosImpares(String[] nombres, int[] estudiantes) {
        int cantidadImpares = contarEspaciosImpares(estudiantes);
        String[] resultado = new String[cantidadImpares];
        int indice = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] % 2 != 0) {
                resultado[indice] = nombres[i];
                indice++;
            }
        }
        return resultado;
    }

    public static String generarMensaje(int cantidadImpares, String[] espaciosImpares) {
        String mensaje = "Cantidad de espacios académicos con estudiantes impares: " + cantidadImpares
                + "\nEspacios académicos con cantidad impar de estudiantes:";
        for (int i = 0; i < espaciosImpares.length; i++) {
            mensaje += "\n- " + espaciosImpares[i];
        }
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}