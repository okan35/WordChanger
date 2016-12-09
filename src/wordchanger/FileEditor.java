/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordchanger;

/**
 *
 * @author pc
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class FileEditor {
    
    private File textFile;
    private Scanner scanner; 
    private ArrayList<String> list = new ArrayList<String>();

    public FileEditor(String fileName) throws Exception {
        
        this.textFile = new File(fileName);
        this.scanner = new Scanner(textFile);
        
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
    }
    
    public void changeString(String string){
        for (String string1 : list) {
            if (string1.contains(string)) {
                string1 = "changedString";
            }
        }
        
        
        
    }
}
