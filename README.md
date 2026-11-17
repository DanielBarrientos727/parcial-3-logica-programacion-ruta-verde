# Parcial III – Lógica de Programación

**Aplicación de Registro y Análisis de Recolección – Ruta Verde S.A.S.**

**Fecha:** 17 de noviembre de 2026

**Autores:**
- Daniel Alejandro Barrientos Soto
- Jhon Alexander Escobar Pacheco

**Docente:**  
Diana Marcela Rivera Valencia

**Universidad del Quindío**  
Facultad de Ingeniería  
Programa de Ingeniería de Sistemas y Computación  
Grupo: 02 – Nocturno  
Armenia, Quindío  
2026

---

## Introducción

En este documento se presenta el desarrollo del tercer parcial de la asignatura Lógica de Programación, en el cual se da solución a los requerimientos propuestos mediante el uso de los conocimientos adquiridos durante el desarrollo del espacio académico.

El ejercicio consiste en desarrollar una aplicación en Java para la empresa Ruta Verde S.A.S., destinada al registro y análisis de información correspondiente a diferentes puntos de recolección de materiales reciclables.

Para resolver el problema se aplicaron conceptos de lógica de programación, pensamiento computacional, estructuras de control, arreglos y modularidad. El desarrollo se realizó utilizando los conocimientos trabajados durante las clases, procurando mantener un código organizado, comprensible y dividido en funciones con responsabilidades específicas.

Asimismo, se utilizaron los métodos de la clase `Reutilizacion`, trabajada durante el curso, para facilitar el ingreso y la validación de los datos proporcionados por el usuario.

### Herramientas utilizadas

- **Lenguaje de programación:** Java.
- **Entorno de desarrollo:** IntelliJ IDEA Community y Ultimate.
- **Sistemas operativos:** Windows 11 Home y Fedora Linux 44 KDE Plasma.
- **Visualización del código:** [Carbon](https://carbon.now.sh/).

El desarrollo se realizó en equipos con arquitectura x86. Una parte del trabajo fue desarrollada en un equipo HP ProDesk 600 G4 con Fedora Linux 44 y entorno de escritorio KDE Plasma.

---

# Aplicación de Registro y Análisis de Recolección (Ruta Verde S.A.S.)

## 1. Abstracción

### ¿Qué se solicita finalmente?

Se debe desarrollar un programa en Java para la empresa Ruta Verde S.A.S. que permita registrar y procesar la información de los diferentes puntos de recolección visitados durante una jornada de trabajo.

A partir de los datos ingresados por el usuario, el programa debe realizar las siguientes operaciones:

1. Calcular el valor total pagado por los kilogramos recolectados.
2. Identificar el punto de recolección que registró la mayor cantidad de kilogramos.
3. Generar un nuevo arreglo con los códigos de identificación sin elementos duplicados.
4. Combinar los nombres de los puntos de recolección y sus respectivos materiales en un solo arreglo, alternando ambos elementos.
5. Presentar un mensaje resumen con la información registrada y los resultados obtenidos.

### ¿Qué información es relevante?

Para resolver el problema se identificaron los siguientes datos:

- Cantidad de puntos de recolección visitados.
- Nombre de cada punto de recolección.
- Código de identificación de cada punto.
- Tipo de material recolectado: plástico, cartón o vidrio.
- Cantidad de kilogramos recolectados en cada punto.
- Valor pagado por cada kilogramo.
- Valor total pagado durante la jornada.
- Punto que registró la mayor cantidad de kilogramos.
- Códigos de identificación sin valores repetidos.
- Combinación de nombres y materiales.
- Resumen final de la información procesada.

## 2. Descomposición

### ¿Cómo dividir el problema en partes más manejables?

Para facilitar su solución, el problema se dividió en las siguientes etapas:

**Entrada de datos**

Inicialmente, el programa solicita la cantidad de puntos de recolección visitados. Posteriormente, solicita la información correspondiente a cada punto: nombre, código de identificación, material recolectado, kilogramos y valor pagado por kilogramo.

**Validación de datos**

Se utilizan los métodos de la clase `Reutilizacion` para comprobar que los valores numéricos ingresados correspondan al tipo de dato esperado y cumplan con los límites establecidos.

La cantidad de puntos debe ser un entero positivo. Los kilogramos y el valor por kilogramo se ingresan mediante métodos que permiten establecer un valor mínimo.

**Procesamiento de datos**

El procesamiento se divide en funciones independientes:

- Calcular el valor total pagado mediante la multiplicación de los kilogramos recolectados por el valor correspondiente a cada kilogramo.
- Identificar la posición del punto con mayor cantidad de kilogramos.
- Recorrer los códigos de identificación para almacenar únicamente aquellos que no se encuentren repetidos.
- Combinar los arreglos de nombres y materiales, alternando sus elementos.
- Construir y presentar un mensaje con los resultados obtenidos.

**Salida de información**

Finalmente, el programa presenta en la terminal un resumen con los datos registrados, el valor total pagado, el punto con mayor recolección, los códigos únicos y el arreglo combinado.

## 3. Reconocimiento de patrones

### ¿Qué se puede reutilizar de la solución de otros problemas?

Se reutilizan los métodos de la clase `Reutilizacion` para solicitar y validar información, entre ellos:

- `ingresarEntero()`
- `ingresarRealD()`
- `ingresarTexto()`
- `ingresarEnteroMayorQue()`
- `ingresarRealMayorQue()`

También se emplean estructuras y procedimientos trabajados durante las clases, como los ciclos `for`, las estructuras condicionales `if`, los arreglos y las funciones independientes.

### ¿Qué patrones lógicos se repiten en la solución?

Se identificaron los siguientes patrones:

1. **Arreglos paralelos:** permiten almacenar los diferentes datos de cada punto de recolección utilizando la misma posición para relacionar la información.
2. **Recorrido de arreglos:** se utilizan ciclos `for` para consultar y procesar sus elementos.
3. **Acumulación:** se suman los resultados de multiplicar los kilogramos por el valor correspondiente a cada kilogramo.
4. **Búsqueda del máximo:** se comparan los elementos de un arreglo para encontrar la mayor cantidad de kilogramos.
5. **Búsqueda secuencial:** se comprueba si un código ya fue registrado antes de agregarlo al nuevo arreglo.
6. **Combinación de arreglos:** se construye un nuevo arreglo alternando los nombres de los puntos y sus respectivos materiales.

## 4. Codificación

### Organización del programa

La solución se desarrolla mediante dos clases principales:

**`RutaVerde`**

Contiene el método principal y las funciones encargadas del procesamiento de la información y la presentación de los resultados.

**`Reutilizacion`**

Contiene métodos reutilizables para solicitar datos al usuario y validar las entradas numéricas.

### Métodos implementados

| Método | Responsabilidad |
|---|---|
| `main()` | Coordinar la ejecución mediante llamadas a funciones. |
| `ingresarNCantidades()` | Ingresar los valores numéricos correspondientes a un arreglo. |
| `calcularTotalPagado()` | Calcular el valor total pagado durante la jornada. |
| `buscarMayorRecoleccion()` | Obtener la posición del punto con mayor cantidad de kilogramos. |
| `filtrarCodigosUnicos()` | Generar un arreglo sin códigos duplicados. |
| `combinarArreglos()` | Combinar nombres y materiales de forma alternada. |
| `generarMensaje()` | Construir y presentar el resumen de los resultados. |

### Criterios de implementación

Durante la codificación se tuvieron en cuenta los siguientes criterios:

- Utilizar arreglos para almacenar la información.
- Implementar ciclos y estructuras condicionales estudiados en clase.
- Separar las operaciones en funciones con responsabilidades específicas.
- Mantener un único `return` por función.
- Evitar realizar operaciones de procesamiento directamente en el método `main()`.
- Reutilizar los métodos de ingreso de datos de la clase `Reutilizacion`.
- Mantener una implementación sencilla y comprensible, sin recurrir a estructuras o bibliotecas que no hayan sido trabajadas durante el curso.

## 5. Pruebas y resultados

Para comprobar el funcionamiento del programa se deben realizar pruebas con diferentes cantidades de puntos de recolección y valores de entrada.

Se consideran los siguientes escenarios:

| Prueba | Resultado esperado |
|---|---|
| Ingresar una cantidad válida de puntos | El programa continúa con el registro. |
| Ingresar texto donde se espera un número | Se solicita nuevamente un valor numérico. |
| Ingresar un valor inferior o igual al mínimo establecido | Se solicita un nuevo valor. |
| Registrar varios puntos de recolección | Se almacenan sus datos en los arreglos correspondientes. |
| Ingresar códigos repetidos | El nuevo arreglo conserva una sola aparición de cada código. |
| Registrar diferentes cantidades de kilogramos | Se identifica el punto con la mayor cantidad. |
| Combinar nombres y materiales | Se obtiene un arreglo con elementos alternados. |
| Completar el registro | Se presenta el resumen de los resultados. |

## 6. Ejecución del programa

Para ejecutar el proyecto es necesario contar con un entorno de desarrollo compatible con Java o con el JDK instalado.

Los archivos principales del proyecto son:

```text
ruta-verde-java/
│
├── RutaVerde.java
├── Reutilizacion.Reutilizacion.java
└── README.md
```

Desde una terminal, ubicándose en el directorio del proyecto, se puede compilar y ejecutar mediante los siguientes comandos:

**Compilación:**

```bash
javac RutaVerde.java Reutilizacion.Reutilizacion.java
```

**Ejecución:**

```bash
java RutaVerde
```

También es posible ejecutar el programa directamente desde IntelliJ IDEA.

---

## Conclusión

El desarrollo de este ejercicio permitió aplicar los conceptos fundamentales de lógica de programación y pensamiento computacional en la solución de un problema contextualizado.

Mediante el uso de arreglos, ciclos, condicionales y funciones, fue posible organizar el registro de información y realizar las operaciones solicitadas de manera modular.

Asimismo, la reutilización de métodos de la clase `Reutilizacion` permitió centralizar el ingreso de datos y reducir la repetición de código.

Finalmente, este trabajo permitió fortalecer la capacidad de analizar un problema, dividirlo en partes más pequeñas, identificar patrones y construir una solución utilizando los fundamentos de programación en Java adquiridos durante el primer semestre de Ingeniería de Sistemas y Computación.

---

**Daniel Alejandro Barrientos Soto**  
**Jhon Alexander Escobar Pacheco**

Universidad del Quindío  
Facultad de Ingeniería  
Ingeniería de Sistemas y Computación  
Armenia, Quindío – 2026