/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienich.hlep;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Duy Toan
 */
public class msgbox {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "he thong quan ly dao tao", JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message, "he thong quan ly dao tao", JOptionPane.YES_NO_OPTION);
        return result== JOptionPane.YES_OPTION;
        
    }
    public static String prompt(Component parent, String message){
       return JOptionPane.showInputDialog(parent, message, "he thong quan ly dao tao", JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    
}
