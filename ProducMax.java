public class ProducMax {

    static final int DIAS_PRODUCCION = 50;
    static final int VALOR_MINIMO = 0;

    public static void main(String[] args) {
        int[] unidadesDiarias = Reutilizacion.ingresarNEnterosMayoresQue("Ingrese las unidades producidas en el día:", DIAS_PRODUCCION, VALOR_MINIMO);
        double productoAcumulado = calcularProductoAcumulado(unidadesDiarias);
        String mensaje = generarMensaje(productoAcumulado);
        mostrarMensaje(mensaje);
    }

    public static double calcularProductoAcumulado(int[] unidades) {
        double producto = 1;
        for (int i = 0; i < unidades.length; i++) {
            producto = producto * unidades[i];
        }
        return producto;
    }

    public static String generarMensaje(double productoAcumulado) {
        String mensaje = "El producto total acumulado de las unidades producidas en los " + DIAS_PRODUCCION + " días es: " + productoAcumulado;
        return mensaje;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}