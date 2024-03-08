/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.hocvien;
import com.edusys.entity.khoahoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienich.hlep.jdbchehper;

/**
 *
 * @author Duy Toan
 */
public class khoahocdao extends edusysdao<khoahoc, Integer> {

    String insert_sql = "insert into khoahoc (macd,hocphi,thoiluong,ngaykg,ghichu,manv,ngaytao) values(?,?,?,?,?,?,?)";
    String update_sql = "update khoahoc set macd =?,hocphi=?,thoiluong=?,ngaykg=?,ghichu=?,manv=?,ngaytao=?  where makh = ? ";
    String delete_sql = "delete from khoahoc where makh=? ";
    String select_all_sql = "select * from khoahoc ";
    String selectbyid_sql = "select * from  khoahoc where makh=? ";

    @Override
    public void insert(khoahoc entity) {
        jdbchehper.Update(insert_sql, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgaytao());
    }

    @Override
    public void update(khoahoc entity) {
        jdbchehper.Update(update_sql, entity.getMaKH(), entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgaytao());
    }

    @Override
    public void delete(Integer id) {
        jdbchehper.Update(delete_sql,id);
    }

    @Override
    public List<khoahoc> selectall() {
        return this.selectbysql(select_all_sql);
    }

    @Override
    public khoahoc selectbyid(Integer key) {
        List<khoahoc> list = this.selectbysql(selectbyid_sql, key);
        if(list.isEmpty()){
            return null;
            
        }
        return list.get(0);
    }

    @Override
    protected List<khoahoc> selectbysql(String sql, Object... args) {
        List<khoahoc> list = new ArrayList<khoahoc>();
        try {
            ResultSet rs = jdbchehper.query(sql, args);
            while (rs.next()) {
                khoahoc entity = new khoahoc();
                entity.setMaKH(rs.getInt("makh"));
                entity.setMaCD(rs.getString("macd"));
                entity.setHocPhi(rs.getFloat("hocphi"));
                entity.setThoiLuong(rs.getInt("thoiluong"));
                entity.setNgayKG(rs.getDate("ngaykg"));
                entity.setGhiChu(rs.getString("ghichu"));
                entity.setMaNV(rs.getString("manv"));
                entity.setNgaytao(rs.getDate("ngaytao"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public List<khoahoc> selectbychuyende(String macd){
        String sql ="select * from khoahoc where macd=?";
        return this.selectbysql(sql, macd);
    }

    public khoahoc selectbyid(String makh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
