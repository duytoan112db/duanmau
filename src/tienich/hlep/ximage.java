/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienich.hlep;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Duy Toan
 */
public class ximage {
    public static Image getappion(){
        URL url = ximage.class.getResource("C:\\ki 4\\duanmau\\src\\img");
        return new ImageIcon(url).getImage();
    }
    
    
    public static ImageIcon read (String filename){
        File path = new File("logos",filename);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from =Paths.get(src.getAbsolutePath());
            Path to  = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
