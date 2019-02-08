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
/* SQARIM PER PROGRAMIN MEPOSHTE
   KOMPRESIMI PERMES KESAJ KLASE MUND TE I BEHET VETEM FILES QE NDODHEN NE HARD DISK(PRA JO SSD)
   POR DESTINACIONI MUND TE PERCAKTOHET NE SSD
*/
import java.io.*;
import java.util.zip.*;

public class DataCompression {
    
    public static void compress (File source, File destination) throws IOException{
        byte [] buffer  = new byte [1024];
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPOutputStream gzos =  new GZIPOutputStream(fos);
        int read ;
        while((read = fis.read(buffer)) != -1){
            gzos.write(buffer, 0, read);    
        }
        gzos.finish();
        gzos.close();
        fos.close();
        fis.close();
                
    }
    public static void main(String[] args) {
        File source = new File("C:\\Users\\PC\\Desktop\\decompressed\\FOTOEPAKOMPRESUME.png");
        File destination = new File("C:\\Users\\PC\\Desktop\\compressed\\FOTOEKOMPRESUME.png");
        try{
            compress(source, destination);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
