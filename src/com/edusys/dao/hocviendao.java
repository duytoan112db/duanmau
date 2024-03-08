/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.chuyende;
import com.edusys.entity.hocvien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienich.hlep.jdbchehper;

/**
 *
 * @author Duy Toan
 */
public class hocviendao extends edusysdao<hocvien, Integer>{

         String insert_sql= "insert into hocvien (Mahv,makh,manh,diem) values(?,?,?,?)";
    String update_sql= "update hocvien set makh =?,manh=?,diem=?  where mahv = ? ";
    String delete_sql= "delete from hocvien where mahv=? ";
    String select_all_sql= "select * from hocvien ";
    String selectbyid_sql= "select * from  hocvien where mahv=? ";
    
    
    
    @Override
    public void insert(hocvien entity) {
       jdbchehper.Update(insert_sql,entity.getMaHV(),entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void update(hocvien entity) {
        jdbchehper.Update(update_sql,entity.getMaHV(),entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    public void delete(Integer id) {
        jdbchehper.Update(delete_sql,id);
    }

    @Override
    public List<hocvien> selectall() {
        return this.selectbysql(select_all_sql);
    }

    @Override
    protected List<hocvien> selectbysql(String sql, Object... args) {
          List<hocvien> list= new ArrayList<hocvien>();
        try {
            ResultSet rs = jdbchehper.query(sql,args);
            while(rs.next()){
                hocvien entity = new hocvien();
                entity.setMaHV(rs.getInt("mahv"));
                entity.setMaKH(rs.getInt("makh"));
                entity.setMaNH(rs.getString("manh"));
                entity.setDiem(rs.getFloat("diem"));   
              
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        
    }

    @Override
    public hocvien selectbyid(Integer key) {
       List<hocvien> list = this.selectbysql(selectbyid_sql, key);
        if(list.isEmpty()){
            return null;
            
        }
        return list.get(0);
    }

}
