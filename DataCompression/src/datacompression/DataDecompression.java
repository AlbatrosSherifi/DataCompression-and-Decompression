/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datacompression;

/**
 *
 * @author Albatros
 */
import java.io.*;
import java.util.zip.*;

public class DataDecompression {
    
    public static void decompress (File source, File destination) throws IOException{
        byte [] buffer  = new byte [1024];
        FileInputStream fis = new FileInputStream(source);
        GZIPInputStream gzis = new GZIPInputStream(fis);
        FileOutputStream fos =  new FileOutputStream(destination);
        int read ;
        while((read = fis.read(buffer)) != -1){
            fos.write(buffer, 0, read);    
        }
        gzis.close();
        fis.close();
        fos.close();          
    }
    public static void main(String[] args) {
        File source = new File("C:\\Users\\PC\\Desktop\\compressed\\kompresumebrerobt.txt");
        File destination = new File("C:\\Users\\PC\\Desktop\\decompressed\\edekompresume.txt");
        try{
            decompress(source, destination);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}