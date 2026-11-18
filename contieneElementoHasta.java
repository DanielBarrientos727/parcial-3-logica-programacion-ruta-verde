public static boolean contieneElementoHasta(int[] arreglo, int limite, int buscado) {
    boolean encontrado = false;
    for (int i = 0; i < limite; i++) {
        if (arreglo[i] == buscado) {
            encontrado = true;
        }
    }
    return encontrado;
}

public static int contarUnicos(int[] arreglo) {
    int contador = 0;
    for (int i = 0; i < arreglo.length; i++) {
        if (!contieneElementoHasta(arreglo, i, arreglo[i])) {
            contador++;
        }
    }
    return contador;
}

public static int[] eliminarDuplicados(int[] arreglo) {
    int cantidadUnicos = contarUnicos(arreglo);
    int[] unicos = new int[cantidadUnicos];
    int indice = 0;
    for (int i = 0; i < arreglo.length; i++) {
        if (!contieneElementoHasta(unicos, indice, arreglo[i])) {
            unicos[indice] = arreglo[i];
            indice++;
        }
    }
    return unicos;
}

void main() {
}