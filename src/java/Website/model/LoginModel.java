/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.model;

import Website.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author doanv
 */
public class LoginModel {

    public String checkTKMK(String tk, String mk) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        String kq = null;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call checkTKMK(?,?)}");
            callSt.setString(1, tk);
            callSt.setString(2, mk);
            //B3. Thực hiện gọi procedure và lưu kết quả trả ra là resultSet
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                //Khởi tạo đối tượng Student
                kq = rs.getString("check");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return kq;
    }

}

