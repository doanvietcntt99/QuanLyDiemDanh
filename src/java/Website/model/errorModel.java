/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.model;

import Website.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author doanv
 */
public class errorModel {
    public Boolean insertEmail(String email) {
        Connection conn = null;
        CallableStatement callSt = null;
        // Khoi tao listStudent trả về
        boolean check = false;
        try {
            //B1. Khởi tạo đối tượng Connnection
            conn = ConnectionDB.openConnection();
            //B2. Khởi t ạo đối tượng callST  từ conn để gọi proc
            callSt = conn.prepareCall("{call insertEmail(?)}");
            callSt.setString(1, email);
            callSt.execute();
            // Lấy giá trị tham số trả ra
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
}
