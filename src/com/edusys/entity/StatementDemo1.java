/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author teo
 */
public class StatementDemo1 {
    public static void main(String[] args) {
          String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
          String dburl = "jdbc:sqlserver://localhost;database=edeusys1";
          String username = "sa";
          String password = "songlong";  
        
          try{
              //1. Nap driver
              Class.forName(driver);
              //2. Mo ket noi den CSDL
              Connection connection = DriverManager.getConnection(dburl, username, password);
              //3. Tao Statament va thuc thi cau lenh SQL
              Statement statement = connection.createStatement();
              String name="TeoLV3";
              String sql="INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) "
                      + "VALUES ('"+name+"', N'123', N'Lê Văn Tèo', 1)";
              statement.executeUpdate(sql);
              //4. Dong ket noi den CSDL
              connection.close();
          }catch(Exception e){
              System.out.println(e);
          }
    }
}
