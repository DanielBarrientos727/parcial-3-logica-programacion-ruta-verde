public class TravelBus {

    static final int VALOR_MINIMO = 0;
    static final double KM_POR_GALON = 8.0;
    static final double VALOR_GALON = 15000.0;

    public static void main(String[] args) {
        int cantidadBuses = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de buses a registrar: ", VALOR_MINIMO);
        String[] placas = Reutilizacion.ingresarNTextos("Ingrese la placa del bus", cantidadBuses);
        int[] recorridos = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese el número de recorridos del bus", cantidadBuses, VALOR_MINIMO);
        int[] pasajeros = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese la cantidad total de pasajeros del bus", cantidadBuses, VALOR_MINIMO);
        double[] kmInicio = Reutilizacion.ingresarNRealesMayoresQue("Ingrese los kilómetros al inicio del día", cantidadBuses, -1);
        double[] kmFin = ingresarKmFinales(kmInicio);

        int limiteRecorridos = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad mínima de recorridos a comparar: ", -1);

        double promedioRecorridos = calcularPromedioRecorridos(recorridos);
        int busesSobreLimite = contarBusesSuperanRecorridos(recorridos, limiteRecorridos);
        String placaMasPasajeros = obtenerPlacaMasPasajeros(placas, pasajeros);
        double[] valorCombustible = calcularCombustiblePorBus(kmInicio, kmFin);
        String detalleRecorridos = generarDetalleRecorridos(placas, recorridos);

        String mensaje = generarMensaje(placas, promedioRecorridos, limiteRecorridos, busesSobreLimite,
                placaMasPasajeros, valorCombustible, detalleRecorridos);
        mostrarMensaje(mensaje);
    }

    public static double ingresarKmFinalValido(String mensaje, double kmInicial) {
        double kmFinal = Reutilizacion.ingresarRealD(mensaje);
        while (kmFinal < kmInicial) {
            kmFinal = Reutilizacion.ingresarRealD("El kilometraje final no puede ser menor al inicial (" + kmInicial + "): ");
        }
        return kmFinal;
    }

    public static double[] ingresarKmFinales(double[] kmInicio) {
        double[] kmFin = new double[kmInicio.length];
        for (int i = 0; i < kmInicio.length; i++) {
            kmFin[i] = ingresarKmFinalValido("Ingrese los kilómetros al final del día para el bus " + (i + 1) + ": ", kmInicio[i]);
        }
        return kmFin;
    }

    public static double calcularPromedioRecorridos(int[] recorridos) {
        int suma = 0;
        for (int i = 0; i < recorridos.length; i++) {
            suma += recorridos[i];
        }
        double promedio = (double) suma / recorridos.length;
        return promedio;
    }

    public static int contarBusesSuperanRecorridos(int[] recorridos, int limite) {
        int contador = 0;
        for (int i = 0; i < recorridos.length; i++) {
            if (recorridos[i] > limite) {
                contador++;
            }
        }
        return contador;
    }

    public static String obtenerPlacaMasPasajeros(String[] placas, int[] pasajeros) {
        int indiceMayor = 0;
        for (int i = 1; i < pasajeros.length; i++) {
            if (pasajeros[i] > pasajeros[indiceMayor]) {
                indiceMayor = i;
            }
        }
        String placaMayor = placas[indiceMayor];
        return placaMayor;
    }

    public static double[] calcularCombustiblePorBus(double[] kmInicio, double[] kmFin) {
        double[] valoresCombustible = new double[kmInicio.length];
        for (int i = 0; i < kmInicio.length; i++) {
            double kmRecorridos = kmFin[i] - kmInicio[i];
            double galonesConsumidos = kmRecorridos / KM_POR_GALON;
            valoresCombustible[i] = galonesConsumidos * VALOR_GALON;
        }
        return valoresCombustible;
    }

    public static String generarDetalleRecorridos(String[] placas, int[] recorridos) {
        String detalle = "";
        for (int i = 0; i < placas.length; i++) {
            detalle += "\nBus " + placas[i];
            for (int j = 1; j <= recorridos[i]; j++) {
                detalle += "\nRecorrido " + j;
            }
        }
        return detalle;
    }

    public static String generarMensaje(String[] placas, double promedioRecorridos, int limiteRecorridos,
                                        int busesSobreLimite, String placaMasPasajeros, double[] valorCombustible, String detalleRecorridos) {
        String mensaje = "Promedio de recorridos realizados por los buses: " + promedioRecorridos
                + "\nBuses con más de " + limiteRecorridos + " recorridos: " + busesSobreLimite
                + "\nPlaca del bus que transportó más pasajeros: " + placaMasPasajeros
                + "\n\nValor aproximado del combustible consumido por bus:";
        for (int i = 0; i < placas.length; i++) {
            mensaje += "\nBus " + placas[i] + ": $" + valorCombustible[i];
        }
        mensaje += "\n\nDetalle de recorridos por bus:" + detalleRecorridos;
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}