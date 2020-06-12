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
public class SearchingModel {

    public List<Class> getDistinctTime() {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> listCl = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call GetTimeStartEnd()}");
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            listCl = new ArrayList<>();
            while (rs.next()) {
                //Khởi tạo đối tượng Student
                Class cl = new Class();
                cl.setThoiGianBatDau(rs.getTime("ThoiGianBatDau"));
                cl.setThoiGianKetThuc(rs.getTime("ThoiGianKetThuc"));
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

    public List<Class> getStatusClass() {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> listCl = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call GetStatusClass()}");
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            listCl = new ArrayList<>();
            while (rs.next()) {
                //Khởi tạo đối tượng Student
                Class cl = new Class();
                cl.setTrangThai(rs.getString("TrangThai"));
                cl.setIdTrangThai(Integer.parseInt(rs.getString("IDTrangThai")));
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

    public List<Class> getClassbyTime(String thoigianbatdau, String thoigianketthuc) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> KQ = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call getClassbyTime(?,?)}");
            callSt.setString(1, thoigianbatdau);
            callSt.setString(2, thoigianketthuc);
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            KQ = new ArrayList<>();
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
                KQ.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return KQ;
    }

    public List<Class> getClassbyType(String theloai) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> KQ = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call GetClassByType(?)}");
            callSt.setString(1, theloai);
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            //B4. Chuyển dữ liệu rs => listSt trả về
            // Khởi tạo đối tượng listSt
            KQ = new ArrayList<>();
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
                KQ.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return KQ;
    }

    public List<Class> getClassbyStatus(String type) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        List<Class> listCl = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call GetClassByStatus(?)}");
            callSt.setString(1, type);
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

    public List<Class> getClassBySearchingKey(String key) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Class> listCl = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call GetClassBySearchingKey(?)}");
            callSt.setString(1, key);
            ResultSet rs = callSt.executeQuery();
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

    public List<Class> getClassBySearchingDateTime(String time) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Class> listCl = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call GetClassByLichDate(?)}");
            callSt.setString(1, time);
            ResultSet rs = callSt.executeQuery();
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
