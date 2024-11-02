# Parcial Back End - Detección de Mutantes

Alumno: Roberto García Nieto  
Legajo: 47576  
Curso: 3K09  
Materia: Desarrollo de Software

## Descripción

Este proyecto es una aplicación Spring Boot que permite detectar si una secuencia de ADN pertenece a un mutante o a un humano. La aplicación también proporciona estadísticas sobre las secuencias de ADN analizadas.

## Herramientas Utilizadas

- **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
- **H2 Database**: Base de datos en memoria para el almacenamiento de datos.
- **JUnit 5**: Framework para pruebas unitarias.
- **JaCoCo**: Herramienta para medir la cobertura de código.
- **Swagger**: Herramienta para documentar la API.
- **Render**: Plataforma para el despliegue de aplicaciones.

## Introducción del Problema

El objetivo de este proyecto es determinar si una secuencia de ADN dada pertenece a un mutante o a un humano. Una secuencia de ADN se considera mutante si contiene al menos una secuencia repetitiva de cuatro letras iguales (por ejemplo, "AAAA", "TTTT", "CCCC", "GGGG") en cualquier dirección (horizontal, vertical, diagonal).

## Funcionamiento

### Entrada

El algoritmo recibe una matriz de cadenas de ADN, donde cada cadena representa una fila de la matriz.

### Definición de Secuencia Mutante

Una secuencia mutante es una secuencia de cuatro letras iguales (por ejemplo, "AAAA", "TTTT", "CCCC", "GGGG") en cualquier dirección (horizontal, vertical, diagonal).

### Recorrido de la Matriz

- **Horizontal**: El algoritmo verifica cada fila de la matriz para encontrar secuencias de cuatro letras iguales.
- **Vertical**: El algoritmo verifica cada columna de la matriz para encontrar secuencias de cuatro letras iguales.
- **Diagonal Descendente**: El algoritmo verifica las diagonales que van desde la parte superior izquierda a la parte inferior derecha para encontrar secuencias de cuatro letras iguales.
- **Diagonal Ascendente**: El algoritmo verifica las diagonales que van desde la parte superior derecha a la parte inferior izquierda para encontrar secuencias de cuatro letras iguales.
- Para optimizar el funcionamiento, con la primera secuencia que encuentre determina que es mutante y no sigue en busca de más secuencia

### Función de Verificación

La función `checkSequence` se utiliza para verificar si una secuencia de cuatro letras iguales existe en una dirección específica (horizontal, vertical, diagonal). Esta función toma como parámetros la matriz de ADN, las coordenadas iniciales (x, y), y los incrementos (dx, dy) que determinan la dirección de la secuencia.

### Uso de IntStream

El algoritmo utiliza `IntStream` para recorrer eficientemente las filas y columnas de la matriz y verificar las secuencias en las direcciones especificadas.

### Retorno del Resultado

Si se encuentra al menos una secuencia mutante en cualquier dirección, el algoritmo devuelve `true`, indicando que la secuencia de ADN es mutante. Si no se encuentra ninguna secuencia mutante, el algoritmo devuelve `false`.

## Instrucciones de Ejecución

### 1. Descargar archivos
### 2. Construir el Proyecto
  "./gradlew build"
### 3. Ejecutar la Aplicación
  "./gradlew bootRun"
### 4. Acceder a la API localmente
  URL Base: http://localhost:8080
  Endpoint /mutant: http://localhost:8080/mutant
  Endpoint /stats: http://localhost:8080/stats
### 5. Ejecutar Pruebas
  "./gradlew test"
### 6. Ver Reporte de Cobertura de Código
  "./gradlew jacocoTestReport"
  El reporte de cobertura estará disponible en: build/reports/jacoco/test/html/index.html
  Las URLs de la API son:
  - URL Base: https://garcianieto-parical-back-3k9.onrender.com
  - Endpoint /mutant: https://garcianieto-parical-back-3k9.onrender.com/mutant
  - Endpoint /stats: https://garcianieto-parical-back-3k9.onrender.com/stats
