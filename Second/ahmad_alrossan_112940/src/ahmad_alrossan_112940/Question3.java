/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmad_alrossan_112940;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csexam
 */
public class Question3 implements Runnable{
    private String file_name;

    public Question3(String file_name) {
        this.file_name = file_name;
    }
    
    
    
    public static void main(String[] args) {
        String[] files = { "File1.txt", "File2.txt", "File3.txt" };
        
        for(int i = 0; i < files.length; i++) {
            Question3 q = new Question3(files[i]);
            Thread th = new Thread(q);
            th.start();
        }
        
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(file_name);
            //BufferedInputStream bin = new BufferedInputStream(in);
            
            int count = 0;
            while(true) {
                int b = in.read();
                if(b == -1) break;
                if((char)b == 'A' || (char)b == 'a') {
                    count++;
                }
            }
            
            in.close();
            System.out.println(file_name + " " + count);
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(Question3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
