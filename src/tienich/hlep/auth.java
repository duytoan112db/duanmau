/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienich.hlep;

import com.edusys.entity.nhanvien;

/**
 *
 * @author Duy Toan
 */
public class auth {

    public static nhanvien user = null;

    public static void clear() {
        auth.user = null;

    }

    public static boolean islogin() {
        return auth.user != null;

    }

    public static boolean ismanager() {
        return auth.islogin() && user.getVaiTro();

    }

}
