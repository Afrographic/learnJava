package countCharFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CountChar {
    static int alphabetIndexTracker = 0;
    static CharCount[] alphabetsCharsCounter = new CharCount[26];
    static char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public static void main(String[] args) {
        initCounterAlphabtet();
        pickFile();
    }

    public static void pickFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Editable Files", "txt", "js", "css", "ts", "java", "dart");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            processFile(chooser.getSelectedFile());
        }
    }

    public static void initCounterAlphabtet() {
        for (int i = 0; i <= alphabets.length - 1; i++) {
            CharCount charCount = new CharCount(alphabets[i]);
            alphabetsCharsCounter[alphabetIndexTracker] = charCount;
            alphabetIndexTracker++;
        }
    }

    public static void processFile(File file) {
        System.out.println("==========================");
        System.out.println("File : " + file.getName());
        System.out.println("==========================");
        try {
            StringBuilder fileContent = new StringBuilder();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileContent.append(removeWhiteSpace(data));
            }
            myReader.close();
            // Init the counter
            countOccurences(fileContent);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String removeWhiteSpace(String str) {
        return str.toLowerCase().replaceAll("\s+", "");
    }

    public static void countOccurences(StringBuilder str) {
        for (int i = 0; i <= str.length() - 1; i++) {
            if (inAlphabetsArray(str.charAt(i))) {

                int alphabetIndex = getIndexFromCharCounter(str.charAt(i));
                alphabetsCharsCounter[alphabetIndex].increment();
            }
        }

        // render
        printOccurences();
    }

    public static int getIndexFromCharCounter(char character) {
        for (int i = 0; i <= alphabetsCharsCounter.length - 1; i++) {
            if (alphabetsCharsCounter[i].getCharacter() == character) {
                return i;
            }
        }
        return -1;
    }

    public static boolean inAlphabetsArray(char character) {
        for (int i = 0; i <= alphabets.length - 1; i++) {
            if (alphabets[i] == character) {
                return true;
            }
        }
        return false;
    }

    public static void printOccurences() {
        for (CharCount charCount : alphabetsCharsCounter) {
            System.out.println(charCount.toString());
        }
    }

}
