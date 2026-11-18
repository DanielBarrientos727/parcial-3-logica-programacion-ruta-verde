import java.util.Scanner;

public class MateriaFavorita {

    static final int VALOR_MINIMO = 0;

    public static void main(String[] args) {
        int cantidadEstudiantes = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de estudiantes:", VALOR_MINIMO);
        String[] nombres = Reutilizacion.ingresarNTextos("Ingrese el nombre del estudiante", cantidadEstudiantes);
        String[] materiasFavoritas = Reutilizacion.ingresarNTextos("Ingrese la materia favorita del estudiante", cantidadEstudiantes);

        String[] matematicas = filtrarPorMateria(nombres, materiasFavoritas, "matematicas");
        String[] literatura = filtrarPorMateria(nombres, materiasFavoritas, "literatura");
        String[] ciencias = filtrarPorMateria(nombres, materiasFavoritas, "ciencias");

        generarMensaje(matematicas, literatura, ciencias);
    }

    public static String[] filtrarPorMateria(String[] nombres, String[] materias, String materiaBuscada) {
        int contador = 0;
        for (int i = 0; i < materias.length; i++) {
            if (materias[i].equals(materiaBuscada)) {
                contador++;
            }
        }

        String[] resultado = new String[contador];
        int index = 0;
        for (int i = 0; i < materias.length; i++) {
            if (materias[i].equals(materiaBuscada)) {
                resultado[index] = nombres[i];
                index++;
            }
        }
        return resultado;
    }

    public static void generarMensaje(String[] matematicas, String[] literatura, String[] ciencias) {
        String mensaje = "\nEstudiantes que prefieren Matemáticas:";
        for (int i = 0; i < matematicas.length; i++) {
            mensaje += "\n" + matematicas[i];
        }

        mensaje += "\n\nEstudiantes que prefieren Literatura:";
        for (int i = 0; i < literatura.length; i++) {
            mensaje += "\n" + literatura[i];
        }

        mensaje += "\n\nEstudiantes que prefieren Ciencias:";
        for (int i = 0; i < ciencias.length; i++) {
            mensaje += "\n" + ciencias[i];
        }

        System.out.println(mensaje);
    }
}