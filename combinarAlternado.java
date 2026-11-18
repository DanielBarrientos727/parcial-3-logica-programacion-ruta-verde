public static int[] combinarAlternado(int[] arreglo1, int[] arreglo2) {
    int tamanoTotal = arreglo1.length + arreglo2.length;
    int[] combinado = new int[tamanoTotal];
    int indiceCombinado = 0;
    int i = 0;

    while (indiceCombinado < tamanoTotal) {
        if (i < arreglo1.length) {
            combinado[indiceCombinado] = arreglo1[i];
            indiceCombinado++;
        }
        if (i < arreglo2.length) {
            combinado[indiceCombinado] = arreglo2[i];
            indiceCombinado++;
        }
        i++;
    }
    return combinado;
}

void main() {
}