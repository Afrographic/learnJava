package countWord;

public class WordOccurence {
    private String word;
    private int occurrence;
    static int indexTracker = 0;

    public WordOccurence(String word) {
        this.word = word;
        this.occurrence = 1;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurrence() {
        return this.occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public void increment() {
        this.occurrence++;
    }

    @Override
    public String toString() {
        return "{" +
            " word='" + getWord() + "'" +
            ", occurrence='" + getOccurrence() + "'" +
            "}";
    }

}
