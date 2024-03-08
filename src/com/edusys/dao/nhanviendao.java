/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.nhanvien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienich.hlep.jdbchehper;

/**
 *
 * @author Duy Toan
 */
public class nhanviendao extends edusysdao<nhanvien, String> {

    String insert_sql = "insert into nhanvien (MaNV,matkhau,hoten,vaitro) values(?,?,?,?)";
    String update_sql = "update nhanvien set matkhau =?,hoten=?,vaitro=? where manv = ? ";
    String delete_sql = "delete from nhanvien where manv=? ";
    String select_all_sql = "select * from nhanvien ";
    String selectbyid_sql = "select * from  nhanvien where manv=? ";

    @Override
    public void insert(nhanvien entity) {
        jdbchehper.Update(insert_sql, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro());

    }

    @Override
    public void update(nhanvien entity) {
        jdbchehper.Update(update_sql, entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro() , entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        jdbchehper.Update(delete_sql, id);
    }

    @Override
    public List<nhanvien> selectall() {
        return this.selectbysql(select_all_sql);
    }

    @Override
    public nhanvien selectbyid(String key) {
        List<nhanvien> list = this.selectbysql(selectbyid_sql, key);
        if (list.isEmpty()) {
            return null;

        }
        return list.get(0);

    }

    @Override
    protected List<nhanvien> selectbysql(String sql, Object... args) {
        List<nhanvien> list = new ArrayList<nhanvien>();
        try {
            ResultSet rs = jdbchehper.query(sql, args);
            while (rs.next()) {
                nhanvien entity = new nhanvien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }



}
