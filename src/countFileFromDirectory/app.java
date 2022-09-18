package countFileFromDirectory;

import java.io.File;

public class app {
    private static double totalSize = 0;

    public static void main(String[] args) {
        traverseDirectory();
        System.out.println("Total size " + totalSize);
    }

    public static void traverseDirectory() {
        String dirPath = "D:/laragon";
        System.out.println("App");
        final File folder = new File(dirPath);
        extractFiles(folder);
    }

    public static void extractFiles(File folders) {
        File[] files = folders.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                totalSize += file.length();
                // System.out.println(" " + file.getName());
                extractFiles(file);
            } else {
                totalSize += file.length();
                System.out.println(" " + file.getName() + " - " + file.length());
            }
        }
        
    }
}
