/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.model;

import Website.entity.Student;
import Website.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author doanv
 */
public class StudentModel {
    public List<Student> getAllStudentbyTenLop(String tenLop) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Student> listSt = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call getDSSV(?)}");
            callSt.setString(1, tenLop);
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            listSt = new ArrayList<>();
            while (rs.next()) {
                //Khởi tạo đối tượng Student
                Student cl = new Student();
                cl.setTenLop(rs.getString("TenLop"));
                cl.setIdUser(rs.getString("IdUser"));
                cl.setMaSV(rs.getString("MaSV"));
                cl.setTenSV(rs.getString("TenSV"));
                cl.setLopCN(rs.getString("LopCN"));
                cl.setIsDiemDanh(rs.getBoolean("isDiemDanh"));
                cl.setColor(xuLyMauSac(rs.getBoolean("isDiemDanh")));
                cl.setNoteDiemDanh(rs.getString("noteDiemDanh"));
                listSt.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listSt;
    }

    public String xuLyMauSac(Boolean isDiemDanh) {
        String color = null;
        if (isDiemDanh) {
            color = "blue      ";
        } else {
            color = "red       ";
        }
        return color;
    }

    public Boolean UpdateStatusDiemDanh(String maLop, String maSV, Boolean checkafter) {
        Connection conn = null;
        CallableStatement callSt = null;
        Boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call UpdateStatusDiemDanh(?,?,?)}");
            callSt.setString(1, maLop);
            callSt.setString(2, maSV);
            callSt.setBoolean(3, checkafter);
            callSt.execute();
            check = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    public Boolean UpdateNote(String maLop, String maSV, String note)
    {
        Connection conn = null;
        CallableStatement callSt = null;
        Boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call UpdateNoteDiemDanh(?,?,?)}");
            callSt.setString(1, maLop);
            callSt.setString(2, maSV);
            callSt.setString(3, note);
            callSt.execute();
            check = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

}
