/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.servlet;

import Website.model.ClassModel;
import Website.model.LoginModel;
import Website.model.SearchingModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author doanv
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoginModel lgModel = new LoginModel();
        ClassModel clModel = new ClassModel();
        SearchingModel srModel = new SearchingModel();
        // Lấy tham số action từ Request
        String action = request.getParameter("action");
        if (action.equals("Login")) {
            String tk = request.getParameter("username");
            String mk = request.getParameter("password");
            if (tk.length() == 0 && mk.length() == 0) {
                String kq = "Vui lòng nhập Tài khoản và Mật khẩu!";
                request.setAttribute("error", kq);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (tk.length() == 0) {
                String kq = "Vui lòng nhập Tài khoản!";
                request.setAttribute("error", kq);
                request.setAttribute("taikhoan", tk);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (mk.length() == 0) {
                String kq = "Vui lòng nhập Mật khẩu!";
                request.setAttribute("error", kq);
                request.setAttribute("matkhau", mk);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                String check = lgModel.checkTKMK(tk, mk);
                if (check.equals("1")) {
                    getAllClass(clModel, srModel, request, response);
                } else {
//                request.getRequestDispatcher("error.jsp").forward(request, response);
                    String kq = "Đăng nhập thất bại!";
                    request.setAttribute("error", kq);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

        }

    }

    public void getAllClass(ClassModel clModel, SearchingModel srModel, HttpServletRequest request, HttpServletResponse response) {
        try {
            // thực hiện lấy dữ liệu về sinh viên
            List<Website.entity.Class> listClass = clModel.getAllClass();
            List<Website.entity.Class> listTime = srModel.getDistinctTime();
            List<Website.entity.Class> listStatus = srModel.getStatusClass();
            // add listStudent vào REquest
            request.setAttribute("listCl", listClass);
            // add option Time Start - End
            request.setAttribute("listTime", listTime);
            // add option Status
            request.setAttribute("listStatus", listStatus);
            // Gọi sang trang students.jsp
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ClassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
