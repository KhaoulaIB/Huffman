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


    public int chaExists(ArrayList<NodeHuffman> list, char c) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCharacter() == c) {
                    return i;
                }
            }
            return -1;

        }

    public static void filtrarCaracteresAlfabeticos(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char character = (char) currentChar;


                    writer.write(character);
             //   }
            }
        }
    }

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
