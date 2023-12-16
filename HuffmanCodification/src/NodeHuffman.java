public class NodeHuffman implements Comparable<NodeHuffman> {


        char character;
        int frequency;
        NodeHuffman left;
        NodeHuffman right;

    public NodeHuffman getLeft() {
        return left;
    }

    public void setLeft(NodeHuffman left) {
        this.left = left;
    }

    public NodeHuffman getRight() {
        return right;
    }

    public void setRight(NodeHuffman right) {
        this.right = right;
    }

    public NodeHuffman(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;

    }
    public NodeHuffman(){

    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "NodeHuffman{" +
                "character=" + character +
                ", frequency=" + frequency +
                '}';
    }
    @Override
    public int compareTo(NodeHuffman other) {
        return Integer.compare( this.frequency,other.frequency); // Ordenar de mayor a menor frecuencia
    }


}
