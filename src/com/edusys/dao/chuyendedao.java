/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.chuyende;
import com.edusys.entity.nhanvien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienich.hlep.jdbchehper;

/**
 *
 * @author Duy Toan
 */
public class chuyendedao extends edusysdao<chuyende, String>{

     String insert_sql= "insert into chuyende (Macd,tencd,hocphi,thoiluong,hinh,mota) values(?,?,?,?,?,?)";
    String update_sql= "update chuyende set tencd =?,hocphi=?,thoiluong=?,hinh=?,mota=?  where macd = ? ";
    String delete_sql= "delete from chuyende where macd=? ";
    String select_all_sql= "select * from chuyende ";
    String selectbyid_sql= "select * from  chuyende where macd=? ";
    
    
    
    
    @Override
    public void insert(chuyende entity) {
        jdbchehper.Update(insert_sql,entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }

    @Override
    public void update(chuyende entity) {
       jdbchehper.Update(update_sql,entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }

    @Override
    public void delete(String id) {
        jdbchehper.Update(delete_sql,id);
    }

    @Override
    public List<chuyende> selectall() {
        return this.selectbysql(select_all_sql);
    }

    @Override
    public chuyende selectbyid(String key) {
         List<chuyende> list = this.selectbysql(selectbyid_sql, key);
        if(list.isEmpty()){
            return null;
            
        }
        return list.get(0);
    }

    @Override
    protected List<chuyende> selectbysql(String sql, Object... args) {
          List<chuyende> list= new ArrayList<chuyende>();
        try {
            ResultSet rs = jdbchehper.query(sql,args);
            while(rs.next()){
                chuyende entity = new chuyende();
                entity.setMaCD(rs.getString("macd"));
                entity.setTenCD(rs.getString("tencd"));
                entity.setHocPhi(rs.getFloat("hocphi"));
                entity.setThoiLuong(rs.getInt("thoiluong"));   
                 entity.setHinh(rs.getString("thoiluong"));   
                  entity.setMoTa(rs.getString("mota"));   
                
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
    }
    
}
