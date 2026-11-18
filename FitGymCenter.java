public class FitGymCenter {

    static final int VALOR_MINIMO = 0;
    static final double PAGO_POR_HORA = 20000.0;
    static final double PORCENTAJE_BONO = 0.10;
    static final double SATISFACCION_MINIMA = 1.0;
    static final double SATISFACCION_MAXIMA = 10.0;

    public static void main(String[] args) {
        int cantidadEntrenadores = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de entrenadores: ", VALOR_MINIMO);
        String[] nombres = Reutilizacion.ingresarNTextos("Ingrese el nombre del entrenador", cantidadEntrenadores);
        int[] clientesAtendidos = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese el número de clientes atendidos", cantidadEntrenadores, -1);
        double[] horasImpartidas = Reutilizacion.ingresarNRealesMayoresQue("Ingrese las horas de entrenamiento impartidas", cantidadEntrenadores, -1);
        double[] satisfaccion = ingresarSatisfaccionValida(cantidadEntrenadores);

        double[] ingresosDiarios = calcularIngresosDiarios(horasImpartidas);
        double[] bonosDesempeno = calcularBonosDesempeno(ingresosDiarios, satisfaccion);
        String[] entrenadoresBajoDesempeno = filtrarDesempenoBajo(nombres, clientesAtendidos, satisfaccion);
        String entrenadorNombreCorto = obtenerNombreMasCorto(nombres);

        String mensaje = generarMensaje(nombres, ingresosDiarios, bonosDesempeno, entrenadoresBajoDesempeno, entrenadorNombreCorto);
        mostrarMensaje(mensaje);
    }

    public static double ingresarSatisfaccionIndividual(String mensaje) {
        double valor = Reutilizacion.ingresarRealD(mensaje);
        while (valor < SATISFACCION_MINIMA || valor > SATISFACCION_MAXIMA) {
            valor = Reutilizacion.ingresarRealD("Nivel inválido. Ingrese un valor entre 1 y 10: ");
        }
        return valor;
    }

    public static double[] ingresarSatisfaccionValida(int cantidad) {
        double[] satisfaccion = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            satisfaccion[i] = ingresarSatisfaccionIndividual("Ingrese el nivel de satisfacción del entrenador " + (i + 1) + " (1 a 10): ");
        }
        return satisfaccion;
    }

    public static double[] calcularIngresosDiarios(double[] horas) {
        double[] ingresos = new double[horas.length];
        for (int i = 0; i < horas.length; i++) {
            ingresos[i] = horas[i] * PAGO_POR_HORA;
        }
        return ingresos;
    }

    public static double[] calcularBonosDesempeno(double[] ingresos, double[] satisfaccion) {
        double[] bonos = new double[ingresos.length];
        for (int i = 0; i < ingresos.length; i++) {
            if (satisfaccion[i] >= 9.0) {
                bonos[i] = ingresos[i] * PORCENTAJE_BONO;
            } else {
                bonos[i] = 0;
            }
        }
        return bonos;
    }

    public static int contarDesempenoBajo(int[] clientes, double[] satisfaccion) {
        int contador = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (satisfaccion[i] <= 6.0 || clientes[i] < 3) {
                contador++;
            }
        }
        return contador;
    }

    public static String[] filtrarDesempenoBajo(String[] nombres, int[] clientes, double[] satisfaccion) {
        int cantidadBajos = contarDesempenoBajo(clientes, satisfaccion);
        String[] bajos = new String[cantidadBajos];
        int indice = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (satisfaccion[i] <= 6.0 || clientes[i] < 3) {
                bajos[indice] = nombres[i];
                indice++;
            }
        }
        return bajos;
    }

    public static String obtenerNombreMasCorto(String[] nombres) {
        String masCorto = nombres[0];
        for (int i = 1; i < nombres.length; i++) {
            if (nombres[i].length() < masCorto.length()) {
                masCorto = nombres[i];
            }
        }
        return masCorto;
    }

    public static String generarMensaje(String[] nombres, double[] ingresos, double[] bonos,
                                        String[] desempenoBajo, String nombreMasCorto) {
        String mensaje = "Resumen diario de entrenadores FitGym Center:\n";
        for (int i = 0; i < nombres.length; i++) {
            mensaje += "\nEntrenador: " + nombres[i]
                    + " | Ingreso diario: $" + ingresos[i]
                    + " | Bono desempeño: $" + bonos[i];
        }
        mensaje += "\n\nEntrenadores con desempeño Bajo:";
        for (int i = 0; i < desempenoBajo.length; i++) {
            mensaje += "\n- " + desempenoBajo[i];
        }
        mensaje += "\n\nEntrenador con el nombre más corto: " + nombreMasCorto;
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}