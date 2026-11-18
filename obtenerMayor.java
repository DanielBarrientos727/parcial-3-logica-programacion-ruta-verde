public static int obtenerMayor(int[] arreglo) {
    int mayor = arreglo[0];
    for (int i = 1; i < arreglo.length; i++) {
        if (arreglo[i] > mayor) {
            mayor = arreglo[i];
        }
    }
    return mayor;
}

void main() {
}