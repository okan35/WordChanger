package wordchanger;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class WordChanger {

    public static void main(String[] args) {

        //  HashMap<String,String> wordMap = new HashMap<>();
        try {
            // Finds the file to edit
            FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);

            String file = dialog.getDirectory() + "\\" + dialog.getFile();

            File txtFile = new File(file);
            File filePath = txtFile.getCanonicalFile();

            Path path = Paths.get(filePath.getAbsolutePath());

            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);

            content = content.replaceAll("cd", "cdcd");
            Files.write(path, content.getBytes(charset));
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY DONE", "PROCESS", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());

        }

        System.exit(0);

    }

}
