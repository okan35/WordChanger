package wordchanger;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WordChanger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            String file = dialog.getDirectory() + "\\" + dialog.getFile();
            File txtFile = new File(file);
            File filePath = txtFile.getCanonicalFile();

            Path path = Paths.get(filePath.getAbsolutePath());

            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            System.out.println("Write the string you want to change");
            String toChange = scanner.next();

            System.out.println("Write the replacement");
            String replacement = scanner.next();

            content = content.replaceAll(toChange, replacement);
            Files.write(path, content.getBytes(charset));

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());

        }
        JOptionPane.showMessageDialog(null, "IT IS SUCCESSFULLY DONE", "PROCESS", JOptionPane.WARNING_MESSAGE);
        System.exit(0);

    }

}
