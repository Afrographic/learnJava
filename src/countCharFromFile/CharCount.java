package countCharFromFile;

public class CharCount {
    private char character;
    private int totalOccurence;

    public CharCount(char character) {
        this.character = character;
        this.totalOccurence = 0;
    }

    public char getCharacter() {
        return this.character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getTotalOccurence() {
        return this.totalOccurence;
    }

    public void setTotalOccurence(int totalOccurence) {
        this.totalOccurence = totalOccurence;
    }

    public void increment() {
        this.totalOccurence++;
    }

    @Override
    public String toString() {
        return "{" +
            " character='" + getCharacter() + "'" +
            ", totalOccurence='" + getTotalOccurence() + "'" +
            "}";
    }

}
