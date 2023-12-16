import java.io.IOException;
import java.util.*;

public class HuffmanAlgorithm {

    public static void main(String[] args) throws IOException {
        // Crear una instancia de file_managment para leer y procesar el archivo
        file_managment f = new file_managment();
        // Obtener una PriorityQueue de NodeHuffman a partir del archivo
        PriorityQueue<NodeHuffman> q = f.rwfile("ASCIILIBRO.txt");
        int totalchrs =q.size();

        long start = System.nanoTime();
        // Imprimir encabezado de la tabla
        System.out.println("Character \t Frecuencia\t\t Codificación");

        // Invocar la función encodig para construir el árbol de Huffman y mostrar las codificaciones
        encodig(q);
        long end = System.nanoTime();
        double timeInSeconds = (double) (end-start)/1000000000;
        System.out.println("time in seconds : "+ timeInSeconds);
        double velocity = timeInSeconds/totalchrs;
        System.out.println("velocidad nominal: "+ velocity);
    }

    public static void encodig(PriorityQueue<NodeHuffman> q) {
        // Imprimir la PriorityQueue para visualizar los elementos en cada paso
        System.out.println(Arrays.toString(q.toArray()));

        // Inicializar el nodo raíz
        NodeHuffman root = null;

        // Construir el árbol de Huffman
        while (q.size() > 1) {
            // Extraer el primer nodo mínimo
            NodeHuffman x = q.peek();
            q.poll();

            // Extraer el segundo nodo mínimo
            NodeHuffman y = q.peek();
            q.poll();

            // Crear un nuevo nodo 'f' cuya frecuencia es la suma de las frecuencias de 'x' e 'y'
            NodeHuffman f = new NodeHuffman();

            // Asignar valores al nodo 'f' que representa la suma de las frecuencias de 'x' e 'y'
            f.frequency = x.frequency + y.frequency;
            f.character = '-';

            // Establecer 'x' como hijo izquierdo y 'y' como hijo derecho de 'f'
            f.left = x;
            f.right = y;

            // Marcar 'f' como el nodo raíz
            root = f;

            // Agregar 'f' de nuevo a la PriorityQueue para el siguiente paso
            q.add(f);
        }

        // Imprimir las codificaciones al recorrer el árbol
        printCode(root, "");
    }

    public static void printCode(NodeHuffman root, String s) {
        // Caso base: si el nodo es nulo, retornar
        if (root == null) {
            return;
        }

        // Caso base: si el nodo es una hoja, imprimir el carácter, la frecuencia y la codificación
        if (root.left == null && root.right == null) {
            // 'c' es el carácter en el nodo
            System.out.println(root.character + "\t" + root.frequency + "\t\t" + ":" + s);

            return;
        }

        // Si vamos a la izquierda, agregar "0" a la codificación.
        // Si vamos a la derecha, agregar "1" a la codificación.

        // Llamadas recursivas para el subárbol izquierdo y derecho con la codificación actualizada
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }
}
