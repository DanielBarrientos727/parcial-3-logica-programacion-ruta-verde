
import java.util.Scanner;

//https://www.youtube.com/watch?v=8NkHXYVpciI

//[] es el coso universal de los arrays, String []

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sumaPrecios = 0;

        String[] apellidos = new String[5]; //se crea el nuevo string

        apellidos[0] = "Labrada";
        apellidos[1] = "Arteaga";
        apellidos[2] = "Suarez";
        apellidos[3] = "Romo";
        apellidos[4] = "García";

        // Mostrar los apellidos.
        for (int i = 0; i < apellidos.length; i++) {
            System.out.println(apellidos[i]);
        }

        int[] precios = new int[3];

        // Solicitar los precios.
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Dame el precio: ");
            precios[i] = sc.nextInt();
        }

        // Mostrar los precios.
        for (int i = 0; i < precios.length; i++) {
            System.out.println(precios[i]);
        }

        // Sumar los precios.
        for (int i = 0; i < precios.length; i++) {
            sumaPrecios = sumaPrecios + precios[i];
        }

        System.out.println("Suma de los precios: " + sumaPrecios);

        // Calcular el promedio.
        double promedio = (double) sumaPrecios / precios.length;

        System.out.println("Promedio: " + promedio);

        sc.close();
    }
}
