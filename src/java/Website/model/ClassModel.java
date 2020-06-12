/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.model;

import Website.entity.Class;
import Website.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author doanv
 */
public class ClassModel {
    public List<Class> getAllClass() {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> listCl = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call getAllDSLop()}");
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            listCl = new ArrayList<>();
            while (rs.next()) {
                //Khởi tạo đối tượng Student
                Class cl = new Class();
                cl.setColor(rs.getString("Color"));
                cl.setTrangThai(rs.getString("TrangThai"));
                cl.setTenLop(rs.getString("TenLop"));
                cl.setTenMonHoc(rs.getString("TenMonHoc"));
                cl.setTenGiangVien(rs.getString("TenGiangVien"));
                cl.setPlace(rs.getString("place"));
                cl.setThoiGianBatDau(rs.getTime("ThoiGianBatDau"));
                cl.setThoiGianKetThuc(rs.getTime("ThoiGianKetThuc"));
                cl.setLoaiLich(rs.getString("LoaiLich"));
                cl.setId_atteSchedule(rs.getString("id_atteSchedule"));
                // add st --> listSt    
                listCl.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCl;
    }

    public List<Class> getThongTinbyTenLop(String tenLop) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> listCl = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call GetClassByTenLop(?)}");
            callSt.setString(1, tenLop);
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            listCl = new ArrayList<>();
            while (rs.next()) {
                //Khởi tạo đối tượng Student
                Class cl = new Class();
                cl.setTenLop(rs.getString("TenLop"));
                cl.setTenMonHoc(rs.getString("TenMonHoc"));
                cl.setTenGiangVien(rs.getString("TenGiangVien"));
                cl.setThoiGianBatDau(rs.getTime("ThoiGianBatDau"));
                cl.setThoiGianKetThuc(rs.getTime("ThoiGianKetThuc"));
                cl.setId_atteSchedule(rs.getString("malop"));
                // add st --> listSt
                listCl.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCl;
    }
}
