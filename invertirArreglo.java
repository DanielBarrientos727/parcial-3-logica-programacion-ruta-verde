public static int[] invertirArreglo(int[] arreglo) {
    int[] invertido = new int[arreglo.length];
    int j = 0;
    for (int i = arreglo.length - 1; i >= 0; i--) {
        invertido[j] = arreglo[i];
        j++;
    }
    return invertido;
}

void main() {
}