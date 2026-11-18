public class NominaEmpresarial {

    static final int VALOR_MINIMO = 0;

    public static void main(String[] args) {
        int cantidadEmpleados = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de empleados: ", VALOR_MINIMO);
        String[] nombres = Reutilizacion.ingresarNTextos("Ingrese el nombre del empleado", cantidadEmpleados);
        String[] generos = ingresarGeneros(cantidadEmpleados);
        double[] salarios = Reutilizacion.ingresarNRealesMayoresQue("Ingrese el salario del empleado", cantidadEmpleados, VALOR_MINIMO);

        int cantidadHombres = contarPorGenero(generos, "M");
        int cantidadMujeres = contarPorGenero(generos, "F");
        double porcentajeHombres = calcularPorcentaje(cantidadHombres, cantidadEmpleados);
        double porcentajeMujeres = calcularPorcentaje(cantidadMujeres, cantidadEmpleados);

        double sumaTotal = calcularSumaTotalSalarios(salarios);
        double sumaHombres = calcularSumaSalariosPorGenero(salarios, generos, "M");
        double sumaMujeres = calcularSumaSalariosPorGenero(salarios, generos, "F");

        String empleadoMasGana = obtenerEmpleadoMayorSalario(nombres, salarios);
        String empleadoMenosGana = obtenerEmpleadoMenorSalario(nombres, salarios);
        String mujerMasGana = obtenerMujerMayorSalario(nombres, generos, salarios);
        String hombreMenosGana = obtenerHombreMenorSalario(nombres, generos, salarios);

        String mensaje = generarMensaje(porcentajeHombres, porcentajeMujeres, sumaTotal, sumaHombres, sumaMujeres,
                empleadoMasGana, empleadoMenosGana, mujerMasGana, hombreMenosGana);
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
            generos[i] = ingresarGeneroValido("Ingrese el género del empleado " + (i + 1) + " (M/F): ");
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

    public static double calcularSumaTotalSalarios(double[] salarios) {
        double suma = 0;
        for (int i = 0; i < salarios.length; i++) {
            suma += salarios[i];
        }
        return suma;
    }

    public static double calcularSumaSalariosPorGenero(double[] salarios, String[] generos, String generoBuscado) {
        double suma = 0;
        for (int i = 0; i < salarios.length; i++) {
            if (generos[i].equalsIgnoreCase(generoBuscado)) {
                suma += salarios[i];
            }
        }
        return suma;
    }

    public static String obtenerEmpleadoMayorSalario(String[] nombres, double[] salarios) {
        int indiceMayor = 0;
        for (int i = 1; i < salarios.length; i++) {
            if (salarios[i] > salarios[indiceMayor]) {
                indiceMayor = i;
            }
        }
        String nombreMayor = nombres[indiceMayor];
        return nombreMayor;
    }

    public static String obtenerEmpleadoMenorSalario(String[] nombres, double[] salarios) {
        int indiceMenor = 0;
        for (int i = 1; i < salarios.length; i++) {
            if (salarios[i] < salarios[indiceMenor]) {
                indiceMenor = i;
            }
        }
        String nombreMenor = nombres[indiceMenor];
        return nombreMenor;
    }

    public static String obtenerMujerMayorSalario(String[] nombres, String[] generos, double[] salarios) {
        int indiceMayor = -1;
        for (int i = 0; i < salarios.length; i++) {
            if (generos[i].equalsIgnoreCase("F")) {
                if (indiceMayor == -1 || salarios[i] > salarios[indiceMayor]) {
                    indiceMayor = i;
                }
            }
        }
        String resultado = "No hay mujeres registradas";
        if (indiceMayor != -1) {
            resultado = nombres[indiceMayor];
        }
        return resultado;
    }

    public static String obtenerHombreMenorSalario(String[] nombres, String[] generos, double[] salarios) {
        int indiceMenor = -1;
        for (int i = 0; i < salarios.length; i++) {
            if (generos[i].equalsIgnoreCase("M")) {
                if (indiceMenor == -1 || salarios[i] < salarios[indiceMenor]) {
                    indiceMenor = i;
                }
            }
        }
        String resultado = "No hay hombres registrados";
        if (indiceMenor != -1) {
            resultado = nombres[indiceMenor];
        }
        return resultado;
    }

    public static String generarMensaje(double porcentajeHombres, double porcentajeMujeres, double sumaTotal,
                                        double sumaHombres, double sumaMujeres, String empleadoMasGana, String empleadoMenosGana,
                                        String mujerMasGana, String hombreMenosGana) {
        String mensaje = "Porcentaje de hombres: " + porcentajeHombres + "%"
                + "\nPorcentaje de mujeres: " + porcentajeMujeres + "%"
                + "\nSuma total de salarios: $" + sumaTotal
                + "\nSuma salarios hombres: $" + sumaHombres
                + "\nSuma salarios mujeres: $" + sumaMujeres
                + "\nEmpleado que más gana: " + empleadoMasGana
                + "\nEmpleado que menos gana: " + empleadoMenosGana
                + "\nMujer que más gana: " + mujerMasGana
                + "\nHombre que menos gana: " + hombreMenosGana;
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}