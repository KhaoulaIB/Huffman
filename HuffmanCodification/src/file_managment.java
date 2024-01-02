import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
* @author : KIB
 */
public class file_managment {

    BufferedReader br;
    PriorityQueue<NodeHuffman> q;


    long lengthFile;

/*
* Devuelve true si el caracter 'c' esta en list. False en caso contrario.
*/
    public int chaExists(ArrayList<NodeHuffman> list, char c) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCharacter() == c) {
                    return i;
                }
            }
            return -1;

        }

       /*
        * Metodo que lee los caracteres desde el fichero libro.txt, calcula sus frecuencias con la ayuda del metodo charExists
        * y los guarda en el riorityQueue<NodeHuffman> q.
        */
        public PriorityQueue<NodeHuffman> rwfile(String nameFile) {

            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile), "UTF-8"));
               q  = new PriorityQueue<NodeHuffman>();

                String line;
                ArrayList<NodeHuffman> caracteres = new ArrayList<>();
                line = br.readLine();
                while (br.ready()) {
                    for (int i = 0; i < line.length(); i++) {
                        lengthFile++;
                        //consideramos el mismo caracter tanto en Mayuscula como minusicula
                       // char c = Character.toLowerCase(line.charAt(i));
                        char c = line.charAt(i);
                       // if (Character.isAlphabetic(c)){
                        int index = chaExists(caracteres, c);
                        if (index != -1) {
                            int tmp = caracteres.get(index).frequency + 1;   //guardar frecuencia anterior
                            caracteres.set(index, new NodeHuffman(c, tmp));
                        } else {
                            caracteres.add(new NodeHuffman(c, 1));  //añadir nuevo caracter
                       // }
                        }

                    }
                    line = br.readLine();
                }
                System.out.println("number of total characters is : " + caracteres.size());
                for (NodeHuffman caractere : caracteres) {
                    q.add(new NodeHuffman(caractere.character, caractere.frequency));

                }
                br.close();
                return q;
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }




}
