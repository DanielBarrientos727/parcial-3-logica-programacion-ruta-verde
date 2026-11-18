public class NominaHospital {

    static final int VALOR_MINIMO = 0;
    static final double TOPE_SUELDO_BONO = 1200000;
    static final double PORCENTAJE_BONO_ALTO = 0.20;
    static final double PORCENTAJE_BONO_BASE = 0.05;

    public static void main(String[] args) {
        int cantidadEmpleados = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de empleados del hospital: ", VALOR_MINIMO);
        double[] sueldos = Reutilizacion.ingresarNRealesMayoresQue("Ingrese el sueldo del empleado", cantidadEmpleados, VALOR_MINIMO);
        int[] edades = ingresarEdadesCondicional(sueldos);
        String[] generos = ingresarGenerosCondicional(sueldos);

        double[] bonos = calcularBonos(sueldos, edades, generos);
        int cantidadBonificados = contarEmpleadosConBono(bonos);
        double costoTotalNomina = calcularCostoTotalNomina(sueldos, bonos);

        String mensaje = generarMensaje(cantidadBonificados, costoTotalNomina);
        mostrarMensaje(mensaje);
    }

    public static int[] ingresarEdadesCondicional(double[] sueldos) {
        int[] edades = new int[sueldos.length];
        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] > TOPE_SUELDO_BONO) {
                edades[i] = Reutilizacion.ingresarEnteroMayorQue("Ingrese la edad del empleado " + (i + 1) + ": ", VALOR_MINIMO);
            }
        }
        return edades;
    }

    public static String ingresarGeneroValido(String mensaje) {
        String genero = Reutilizacion.ingresarTexto(mensaje);
        while (!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            genero = Reutilizacion.ingresarTexto("Género inválido. Ingrese M o F: ");
        }
        return genero;
    }

    public static String[] ingresarGenerosCondicional(double[] sueldos) {
        String[] generos = new String[sueldos.length];
        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] > TOPE_SUELDO_BONO) {
                generos[i] = ingresarGeneroValido("Ingrese el género del empleado " + (i + 1) + " (M/F): ");
            } else {
                generos[i] = "";
            }
        }
        return generos;
    }

    public static double[] calcularBonos(double[] sueldos, int[] edades, String[] generos) {
        double[] bonos = new double[sueldos.length];
        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] > TOPE_SUELDO_BONO) {
                if (edades[i] >= 55 && edades[i] <= 65 && generos[i].equalsIgnoreCase("F")) {
                    bonos[i] = sueldos[i] * PORCENTAJE_BONO_ALTO;
                } else {
                    bonos[i] = sueldos[i] * PORCENTAJE_BONO_BASE;
                }
            } else {
                bonos[i] = 0;
            }
        }
        return bonos;
    }

    public static int contarEmpleadosConBono(double[] bonos) {
        int contador = 0;
        for (int i = 0; i < bonos.length; i++) {
            if (bonos[i] > 0) {
                contador++;
            }
        }
        return contador;
    }

    public static double calcularCostoTotalNomina(double[] sueldos, double[] bonos) {
        double total = 0;
        for (int i = 0; i < sueldos.length; i++) {
            total += sueldos[i] + bonos[i];
        }
        return total;
    }

    public static String generarMensaje(int cantidadBonificados, double costoTotalNomina) {
        String mensaje = "Cantidad de empleados que recibieron bonificación: " + cantidadBonificados
                + "\nCosto total de la nómina para el hospital: $" + costoTotalNomina;
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}