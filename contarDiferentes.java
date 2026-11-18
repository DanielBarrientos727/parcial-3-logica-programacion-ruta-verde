public static int contarDiferentes(int[] arreglo, int elementoEliminar) {
    int contador = 0;
    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] != elementoEliminar) {
            contador++;
        }
    }
    return contador;
}

public static int[] eliminarElemento(int[] arreglo, int elementoEliminar) {
    int nuevoTamano = contarDiferentes(arreglo, elementoEliminar);
    int[] resultado = new int[nuevoTamano];
    int indice = 0;
    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] != elementoEliminar) {
            resultado[indice] = arreglo[i];
            indice++;
        }
    }
    return resultado;
}

void main() {
}