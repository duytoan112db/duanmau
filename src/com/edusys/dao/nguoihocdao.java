/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.dao;

import com.edusys.entity.khoahoc;
import com.edusys.entity.nguoihoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tienich.hlep.jdbchehper;

/**
 *
 * @author Duy Toan
 */
public class nguoihocdao extends edusysdao<nguoihoc, String> {

    String insert_sql = "insert into nguoihoc (Manh,hoten,ngaysinh,gioitinh,dienthoai,email,ghichu,manv,ngaydk) values(?,?,?,?,?,?,?,?,?)";
    String update_sql = "update nguoihoc set hoten =?,gioitinh=?,ngaysinh=?,dienthoai=? , email=?,ghichu=?,manv=?,ngaydk=?  where manh = ? ";
    String delete_sql = "delete from NguoiHoc where manh=? ";
    String select_all_sql = "select * from nguoihoc";
    String selectbyid_sql = "select * from  nguoihoc where manh=? ";

    @Override
    public void insert(nguoihoc entity) {
        jdbchehper.Update(insert_sql, entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(), entity.getGioiTinh(), entity.getDienThoai(),entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgaytao());
    }

    @Override
    public void update(nguoihoc entity) {
        jdbchehper.Update(update_sql, entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(), entity.getGioiTinh(), entity.getDienThoai(),entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgaytao());
    }

    @Override
    public void delete(String id) {
        jdbchehper.Update(delete_sql, id);
    }

    @Override
    public List<nguoihoc> selectall() {
        return this.selectbysql(select_all_sql);
    }

    @Override
    public nguoihoc selectbyid(String key) {
        List<nguoihoc> list = this.selectbysql(selectbyid_sql, key);
        if (list.isEmpty()) {
            return null;

        }
        return list.get(0);
    }

    @Override
    protected List<nguoihoc> selectbysql(String sql, Object... args) {
        List<nguoihoc> list = new ArrayList<nguoihoc>();
        try {
            ResultSet rs = jdbchehper.query(sql, args);
            while (rs.next()) {
                nguoihoc entity = new nguoihoc();
                entity.setMaNH(rs.getString("manh"));
                entity.setHoTen(rs.getString("hoten"));
                entity.setNgaySinh(rs.getDate("ngaysinh"));
                entity.setGioiTinh(rs.getBoolean("gioitinh"));
                entity.setDienThoai(rs.getString("dienthoai"));
                entity.setEmail(rs.getString("email"));
                entity.setGhiChu(rs.getString("ghichu"));
                entity.setMaNV(rs.getString("manv"));
                entity.setNgaytao(rs.getDate("ngaydk"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
     public List<nguoihoc> selectbykeyword(String keyword){
        String sql = "select * from  nguoihoc where hoten like ?";
        return this.selectbykeyword(sql, "%" +keyword + "%");
    }

    private List<nguoihoc> selectbykeyword(String sql, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
