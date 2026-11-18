
public class RutaVerde {

    /*
                                                MAIN
     */
    static final int VALOR_MINIMO = 0; //Constante

    public static void main(String[] args) {

        int cantidadPuntos = Reutilizacion.ingresarEnteroMayorQue(
                "Ingrese la cantidad de puntos estimado usuario: ", VALOR_MINIMO); //puntos es lugares para tirar basura, como una zona de reciclaje en la UQ.

        String[] nombresPuntos = Reutilizacion.ingresarNTextos(
                "Ingrese el nombre del punto", cantidadPuntos); //Nombre de lugar para el primer indice del arreglo

        int[] codigosPuntos = Reutilizacion.ingresarNEnterosMayoresQue(
                "Ingrese el codigo del punto", cantidadPuntos, VALOR_MINIMO); //101, 102, etc.

        String[] materiales = Reutilizacion.ingresarNTextos(
                "Ingrese el material (ya sea plastico, carton o vidrio)", cantidadPuntos); //que es, vidrio, carton, etc.

        double[] kilos = Reutilizacion.ingresarNRealesMayoresQue(
                "Ingrese por favor los kilogramos recolectados", cantidadPuntos, VALOR_MINIMO);

        double[] precios = Reutilizacion.ingresarNRealesMayoresQue(
                "Ingrese el valor pagado por kilogramo estimado usuario", cantidadPuntos, VALOR_MINIMO); //1kg de plastico

        double totalPagado = calcularTotal(kilos, precios); //totalPagado es k*p, abajo sale

        String puntoMayor = buscarMayor(nombresPuntos, kilos); //Cuál es el sitio con mayor recolecta de basura

        int[] codigosUnicos = filtrarCodigosUnicos(codigosPuntos); //Eliminación de repeticiones

        String[] nombresMateriales = combinarArreglos(nombresPuntos, materiales); //Le da a cada lugar su respectivo materia vendido, UQ -> hierro ejemplo y combinan dos Arrays

        generarMensaje(nombresPuntos, codigosPuntos, materiales, kilos, precios,
                totalPagado, puntoMayor, codigosUnicos, nombresMateriales); //Imprimo todo a pantalla
    }


    /*
                                            IMPLEMENTACIONES DE METODOS DE LO QUE HAY EN EL MAIN
     */

    // Calcula el total pagado por todos los puntos ---> cuanto se pago por los materiales

    public static double calcularTotal(double[] kilos, double[] precios) {
        double total = 0;

        //USAMOS UN FOR
        for (int i = 0; i < kilos.length; i++) {

            total = total + kilos[i] * precios[i]; //y vuelve en la primera, en la segunda, en la tercera y así hasta acabar

            //total es acumulador

        }
        return total;
    }

    // Busca el punto que recolecto mayor kilogramos.
    public static String buscarMayor(String[] nombres, double[] kilos) {
        int posicionMayor = 0;

        //Usamos otro FOR
        for (int i = 0; i < kilos.length; i++) {
            if (kilos[i] > kilos[posicionMayor]) {
                posicionMayor = i;
            }
        }
        int mayor = posicionMayor;
        return mayor;
    }

    // Crea un arreglo con los codigos sin repetir ---> eliminar arreglos repetidos

    public static int[] filtrarCodigosUnicos(int[] codigos) {

        int contador = 0;

        for (int i = 0; i < codigos.length; i++) {
            boolean existe = false;

            for (int j = 0; j < i; j++) {
                if (codigos[i] == codigos[j]) {
                    existe = true;
                }
            }
            if (!existe) {
                contador++;
            }
        }
        int[] resultado = new int[contador];

        int index = 0;

        for (int i = 0; i < codigos.length; i++) {
            boolean existe = false;
            for (int j = 0; j < i; j++) {
                if (codigos[i] == codigos[j]) {
                    existe = true;
                }
            }

            if (!existe) {
                resultado[index] = codigos[i];
                index++;
            }
        }

        return resultado;
    }

    // Combina los nombres y materiales en un solo arreglo.

    //I -> inicializador -> index

    public static String[] combinarArreglos(String[] nombres, String[] materiales) {

        String[] resultado = new String[nombres.length + materiales.length];
        int index = 0;

        for (int i = 0; i < nombres.length; i++) {
            resultado[index] = nombres[i];
            index++;

            resultado[index] = materiales[i];
            index++;
        }
        // repetir el coso hasta matar a length o tamaño del x

        return resultado;
    }

    // Muestra la informacion y los resultados.

    //IMPRIMIR

    public static void generarMensaje(String[] nombres, int[] codigos,
                                      String[] materiales, double[] kilos, double[] precios,
                                      double total, String mayor, int[] unicos, String[] combinados) {
        String mensaje = "\nRUTA VERDE S.A.S.";
        mensaje += "\nINFORMACION DE LOS PUNTOS:";

        for (int i = 0; i < nombres.length; i++) {
            mensaje += "\n\nPunto: " + nombres[i];
            mensaje += "\nCodigo: " + codigos[i];
            mensaje += "\nMaterial: " + materiales[i];
            mensaje += "\nKilogramos: " + kilos[i];
            mensaje += "\nValor por kilogramo: $" + precios[i];
            mensaje += "\nTotal del punto: $" + (kilos[i] * precios[i]);
        }
        mensaje += "\n\nTOTAL PAGADO: $" + total;
        mensaje += "\nPUNTO CON MAYOR RECOLECCION: " + mayor;
        mensaje += "\n\nCODIGOS UNICOS:";


        for (int i = 0; i < unicos.length; i++) {
            mensaje += "\n" + unicos[i];
        }
        mensaje += "\n\nNOMBRES Y MATERIALES COMBINADOS:"; //pa simplifica lo de imprimir, imprime agrega

        for (int i = 0; i < combinados.length; i++) {
            mensaje += "\n" + combinados[i];
        }
        System.out.println(mensaje);

    }
}
