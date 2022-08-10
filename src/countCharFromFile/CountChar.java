package countCharFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CountChar {
    static int alphabetIndexTracker = 0;
    static CharCount[] alphabetsCharsCounter = new CharCount[26];
    static char[] alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    static String fileName = "none";

    public static void main(String[] args) {

        initCounterAlphabtet();
        pickFile();
        initRenderer();

    }

    public static void initCounterAlphabtet() {
        for (int i = 0; i <= alphabets.length - 1; i++) {
            CharCount charCount = new CharCount(alphabets[i]);
            alphabetsCharsCounter[alphabetIndexTracker] = charCount;
            alphabetIndexTracker++;
        }
    }

    public static String extractLabelsForTemplate() {
        StringBuilder stringToReplace = new StringBuilder();
        stringToReplace.append("[");
        for (char character : alphabets) {
            stringToReplace.append("'" + character + "',");
        }
        stringToReplace.append("]");
        return stringToReplace.toString();
    }

    public static String extractCharOccurenceForTemplate() {
        StringBuilder stringToReplace = new StringBuilder();
        stringToReplace.append("[");
        for (CharCount charCount : alphabetsCharsCounter) {
            stringToReplace.append("'" + charCount.getTotalOccurence() + "',");
        }
        stringToReplace.append("]");
        return stringToReplace.toString();
    }

    public static File getFileFromLocale(String relativePath) {
        File directory = new File("");
        String workingDir = directory.getAbsolutePath();
        return new File(workingDir + relativePath);
    }

    public static void initRenderer() {
        // Get the working directory
        File renderFile = getFileFromLocale("/src/countCharFromFile/render/template.html");
        StringBuilder fileContent = extractFileContent(renderFile);
        System.out.println(fileContent);

        replaceTemplateVariable(fileContent.toString());
    }

    public static void replaceTemplateVariable(String fileContent) {
        File renderFile = getFileFromLocale("/src/countCharFromFile/render/render.html");
        String labels = extractLabelsForTemplate();
        String data = extractCharOccurenceForTemplate();
        fileContent = fileContent.replace("Ankh_file_name", fileName);
        fileContent = fileContent.replace("Ankh_labels", labels);
        fileContent = fileContent.replace("Ankh_data", data);
        replaceFileContent(fileContent, renderFile);
    }

    public static void replaceFileContent(String fileContent, File renderFile) {
        try {

            FileWriter fooWriter = new FileWriter(renderFile, false);
            fooWriter.write(fileContent);
            fooWriter.close();

            // Open the renderer
            openFile(renderFile);
        } catch (Exception e) {
            System.out.println("Unable to open the renderer");
        }

    }

    public static void openFile(File file) {
        try {
            Runtime.getRuntime()
                    .exec(new String[] { "rundll32", "url.dll,FileProtocolHandler", file.getAbsolutePath() });
        } catch (IOException e) {
          
            e.printStackTrace();
        }
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

    public static StringBuilder extractFileContent(File file) {
        try {
            StringBuilder fileContent = new StringBuilder();
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileContent.append(data);
            }
            myReader.close();
            return fileContent;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return new StringBuilder();
        }

    }

    public static void processFile(File file) {
        fileName = file.getName();
        StringBuilder fileContent = extractFileContent(file);
        countOccurences(fileContent);
    }

    public static String removeWhiteSpace(String str) {
        return str;
        // return str.replaceAll("\s+", "");
    }

    public static void countOccurences(StringBuilder str) {
        str = new StringBuilder(removeWhiteSpace(str.toString()).toUpperCase());
        for (int i = 0; i <= str.length() - 1; i++) {
            if (inAlphabetsArray(str.charAt(i))) {
                int alphabetIndex = getIndexFromCharCounter(str.charAt(i));
                alphabetsCharsCounter[alphabetIndex].increment();
            }
        }

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
