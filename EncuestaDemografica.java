public class EncuestaDemografica {

    static final int VALOR_MINIMO = 0;

    public static void main(String[] args) {
        int cantidadPersonas = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de personas encuestadas:", VALOR_MINIMO);
        String[] generos = ingresarGeneros(cantidadPersonas);

        int totalHombres = contarPorGenero(generos, "M");
        int totalMujeres = contarPorGenero(generos, "F");

        double porcentajeHombres = calcularPorcentaje(totalHombres, cantidadPersonas);
        double porcentajeMujeres = calcularPorcentaje(totalMujeres, cantidadPersonas);

        String mensaje = generarMensaje(porcentajeHombres, porcentajeMujeres);
        mostrarMensaje(mensaje);
    }

    public static String ingresarGeneroValido(String mensaje) {
        String genero = Reutilizacion.ingresarTexto(mensaje);
        while (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            genero = Reutilizacion.ingresarTexto("Género inválido. Ingrese M para masculino o F para femenino:");
        }
        return genero;
    }

    public static String[] ingresarGeneros(int cantidad) {
        String[] generos = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generos[i] = ingresarGeneroValido("Ingrese el género de la persona " + (i + 1) + " (M/F):");
        }
        return generos;
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

    public static double calcularPorcentaje(int cantidadParte, int total) {
        double porcentaje = (cantidadParte * 100.0) / total;
        return porcentaje;
    }

    public static String generarMensaje(double porcentajeHombres, double porcentajeMujeres) {
        String mensaje = "Resultados de la encuesta demográfica:\n"
                + "Porcentaje de hombres: " + porcentajeHombres + "%\n"
                + "Porcentaje de mujeres: " + porcentajeMujeres + "%";
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}