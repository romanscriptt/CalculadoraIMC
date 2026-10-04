# Calculadora de IMC (Índice de Masa Corporal)

Aplicación de escritorio desarrollada en Java Swing aplicando el patrón de arquitectura Modelo-Vista-Controlador (MVC) para el cálculo y evaluación del Índice de Masa Corporal (IMC).

El desarrollo se ha realizado tomando como referencia la estructura del proyecto de ejemplo proporcionado por el docente para mantener una metodología coherente y modular.

```text
CalculadoraIMC/
├── src/
│   └── com/
│       └── calculadora/
│           └── imc/
│               ├── main/
│               │   └── Main.java              # Punto de entrada de la aplicación
│               ├── model/
│               │   └── CalculadoraIMC.java    # Lógica de negocio y fórmulas
│               ├── view/
│               │   └── VentanaIMC.java        # Interfaz gráfica (Swing Form / JFrame)
│               └── controller/
│                   └── IMCController.java     # Manejador de eventos e integración
└── README.md
```

PARTE 3 (Copia y pega esto al final)
## Justificación del Diseño y Arquitectura

1. CalculadoraIMC.java (Modelo):
* Contiene la lógica de negocio, incluyendo la fórmula matemática del cálculo del IMC y la clasificación por rangos. Es totalmente independiente de la interfaz gráfica.

2. VentanaIMC.java (Vista):
* Construida con el diseñador visual de NetBeans. Contiene la disposición de los componentes y expone los elementos necesarios mediante métodos de acceso (getters).

3. IMCController.java (Controlador):
* Gestiona la interacción entre la vista y el modelo mediante ActionListener. Recoge las entradas, gestiona las validaciones, solicita el cálculo al modelo y actualiza el estado y el color de los componentes visuales.

4. Main.java (Lanzador):
* Inicializa el entorno gráfico aplicando el Look and Feel Nimbus para asegurar la consistencia entre distintos sistemas operativos y lanza la vista dentro del hilo de eventos de Swing (Event Dispatch Thread).

## Conceptos Visuales y Formato

### ¿Para qué sirve Nimbus?
Nimbus es un Look and Feel (motor de aspecto visual) propio de Java Swing. Sirve para que la interfaz gráfica mantenga una apariencia moderna, limpia y homogénea en cualquier sistema operativo (macOS, Windows o Linux). Sin Nimbus, Java aplica por defecto el estilo gráfico nativo o el estilo clásico de Swing (Metal), lo que suele provocar incoherencias visuales como botones transparentes, bordes extraños o desalineación de componentes al ejecutar la aplicación fuera del diseñador gráfico.

### Formateo de texto: String.format("Tu IMC es: %.2f", imc)
El uso de String.format("Tu IMC es: %.2f", imc) sirve para formatear el valor numérico decimal devuelto por el cálculo matemático antes de mostrarlo en la interfaz:

* %f: Indica que en esa posición se insertará un número decimal de tipo flotante (double o float).
* .2: Especifica que el número debe redondearse a exactamente 2 decimales.
* Propósito: Evita que en la pantalla se muestre un resultado con infinitos decimales (por ejemplo, 24.891234567891), presentando al usuario un valor limpio y redondeado (ej. 24.89).

## Dificultades Encontradas y Soluciones

### 1. Inconsistencia de diseño en macOS
* Problema: Al ejecutar la aplicación en macOS, los botones e interfaces cambiaban de aspecto respecto a la vista previa del IDE.
* Solución: Se forzó el uso del Look and Feel Nimbus en Main.java mediante UIManager.setLookAndFeel() para homogeneizar la apariencia visual.

### 2. Texto cortado en el campo de resultado
* Problema: La etiqueta (JLabel) que muestra el resultado recortaba el texto agregando puntos suspensivos.
* Solución: Se reconfiguró la alineación horizontal a SwingConstants.CENTER y se ajustó el espacio de visualización en el layout de la vista.

### 3. Validación de unidades de altura
* Problema: Error de cálculo si el usuario introduce la altura en centímetros (ej. 175) en lugar de metros (ej. 1.75).
* Solución: Se añadió una condición en el controlador que detecta valores superiores a 3.0 y realiza la conversión automática dividiendo entre 100.0.

### 4. Asignación de colores en formato RGB
* Problema: Necesidad de diferenciar visualmente cada categoría según el resultado obtenido.
* Solución: Se implementó un método en el controlador que modifica el color del texto mediante valores RGB explícitos (Color(R, G, B)):
* Bajo Peso: RGB(0, 102, 204)
* Peso Normal: RGB(0, 153, 76)
* Sobrepeso: RGB(230, 126, 34)
* Obesidad: RGB(204, 0, 0)
