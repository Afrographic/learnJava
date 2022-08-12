package countWord;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strSplitted = splitString(str);
        WordOccurence[] words = countOccurence(strSplitted);
        printWordOccurence(words);
        input.close();

    }

    public static String[] splitString(String str) {
        return str.trim().split("\\s+");
    }

    public static WordOccurence[] countOccurence(String[] words) {
        WordOccurence[] wordOccurence = new WordOccurence[words.length];
        for (String wordItem : words) {
            int index = inWordsOccurenceObject(wordOccurence, wordItem);
            if (index == -1) {
                WordOccurence wordOccItem = new WordOccurence(wordItem);
                wordOccurence[WordOccurence.indexTracker] = wordOccItem;
                WordOccurence.indexTracker++;
            } else {
                wordOccurence[index].increment();
            }
        }
        return wordOccurence;
    }

    public static int inWordsOccurenceObject(WordOccurence[] words, String word) {
        for (int i = 0; i <= words.length - 1; i++) {
            if (words[i] != null && words[i].getWord().equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static void printWordOccurence(WordOccurence[] words) {
        for (int i = 0; i <= WordOccurence.indexTracker-1; i++) {
            System.out.println(words[i]);
        }

    }
}
