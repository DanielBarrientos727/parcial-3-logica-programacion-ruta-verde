public static int buscarPrimeraOcurrencia(int[] arreglo, int elementoBuscado) {
    int indiceEncontrado = -1;
    for (int i = 0; i < arreglo.length; i++) {
        if (indiceEncontrado == -1 && arreglo[i] == elementoBuscado) {
            indiceEncontrado = i;
        }
    }
    return indiceEncontrado;
}

void main() {
}