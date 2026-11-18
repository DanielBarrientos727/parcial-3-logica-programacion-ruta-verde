public class MatematicasGenerales {

    static final int VALOR_MINIMO = 0;
    static final double NOTA_MINIMA = 0.0;
    static final double NOTA_MAXIMA = 5.0;
    static final double NOTA_MINIMA_APROBACION = 3.0;

    public static void main(String[] args) {
        int cantidadEstudiantes = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de estudiantes: ", VALOR_MINIMO);
        String[] nombres = Reutilizacion.ingresarNTextos("Ingrese el nombre del estudiante", cantidadEstudiantes);
        String[] generos = ingresarGeneros(cantidadEstudiantes);
        int[] edades = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese la edad del estudiante", cantidadEstudiantes, VALOR_MINIMO);
        double[] notas = ingresarNotasValidas(cantidadEstudiantes);

        int cantidadMasculino = contarPorGenero(generos, "M");
        int cantidadFemenino = contarPorGenero(generos, "F");
        String[] reprobados = obtenerDatosReprobados(nombres, generos, edades, notas);

        String mensaje = generarMensaje(cantidadMasculino, cantidadFemenino, reprobados);
        mostrarMensaje(mensaje);
    }

    public static String ingresarGeneroValido(String mensaje) {
        String genero = Reutilizacion.ingresarTexto(mensaje);
        while (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            genero = Reutilizacion.ingresarTexto("Género inválido. Ingrese M o F: ");
        }
        return genero;
    }

    public static String[] ingresarGeneros(int cantidad) {
        String[] generos = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generos[i] = ingresarGeneroValido("Ingrese el género del estudiante " + (i + 1) + " (M/F): ");
        }
        return generos;
    }

    public static double ingresarNotaValida(String mensaje) {
        double nota = Reutilizacion.ingresarRealD(mensaje);
        while (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
            nota = Reutilizacion.ingresarRealD("Nota inválida. Ingrese una nota entre 0.0 y 5.0: ");
        }
        return nota;
    }

    public static double[] ingresarNotasValidas(int cantidad) {
        double[] notas = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            notas[i] = ingresarNotaValida("Ingrese la nota final del estudiante " + (i + 1) + " (0.0 a 5.0): ");
        }
        return notas;
    }

    public static int contarPorGenero(String[] generos, String generoBuscado) {
        int contador = 0;
        for (int i = 0; i < generos.length; i++) {
            if (generos[i].equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarReprobados(double[] notas) {
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < NOTA_MINIMA_APROBACION) {
                contador++;
            }
        }
        return contador;
    }

    public static String[] obtenerDatosReprobados(String[] nombres, String[] generos, int[] edades, double[] notas) {
        int totalReprobados = contarReprobados(notas);
        String[] reprobados = new String[totalReprobados];
        int indice = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < NOTA_MINIMA_APROBACION) {
                reprobados[indice] = nombres[i] + " | Género: " + generos[i] + " | Edad: " + edades[i] + " | Nota: " + notas[i];
                indice++;
            }
        }
        return reprobados;
    }

    public static String generarMensaje(int masculino, int femenino, String[] reprobados) {
        String mensaje = "Cantidad de estudiantes masculinos: " + masculino
                + "\nCantidad de estudiantes femeninos: " + femenino
                + "\n\nEstudiantes que deben repetir la asignatura:";
        for (int i = 0; i < reprobados.length; i++) {
            mensaje += "\n- " + reprobados[i];
        }
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}