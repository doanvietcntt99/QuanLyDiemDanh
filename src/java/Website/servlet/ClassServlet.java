/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.servlet;

import Website.entity.Class;
import Website.model.ClassModel;
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
public class ClassServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ClassModel clModel = new ClassModel();
        SearchingModel srModel = new SearchingModel();

        // Lấy tham số action từ Request
        String action = request.getParameter("action");
        if (action.equals("GetAllClass")) {
            getAllClass(clModel, srModel, request, response);
        } else if (action.equals("SearchByTime")) {
            String thoigianbatdau = request.getParameter("ThoiGianBatDau");
            String thoigianketthuc = request.getParameter("ThoiGianKetThuc");
            List<Class> listClassByTime = srModel.getClassbyTime(thoigianbatdau, thoigianketthuc);
            List<Class> listStatus = srModel.getStatusClass();
            List<Class> listTime = srModel.getDistinctTime();
            request.setAttribute("listCl", listClassByTime);
            request.setAttribute("listTime", listTime);
            request.setAttribute("listStatus", listStatus);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (action.equals("GetClassByType")) {
            String type = request.getParameter("Type");
            if (type.equals("HangNgay")) {
                String theloai = "Hằng Ngày";
                List<Class> listClassbyType = srModel.getClassbyType(theloai);
                List<Class> listTime = srModel.getDistinctTime();
                List<Class> listStatus = srModel.getStatusClass();
                request.setAttribute("listCl", listClassbyType);
                request.setAttribute("listTime", listTime);
                request.setAttribute("listStatus", listStatus);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (type.equals("TinChi")) {
                String theloai = "Tín Chỉ";
                List<Class> listClassbyType = srModel.getClassbyType(theloai);
                List<Class> listTime = srModel.getDistinctTime();
                List<Class> listStatus = srModel.getStatusClass();
                request.setAttribute("listCl", listClassbyType);
                request.setAttribute("listTime", listTime);
                request.setAttribute("listStatus", listStatus);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (type.equals("LichHop")) {
                String theloai = "Lịch Họp";
                List<Class> listClassbyType = srModel.getClassbyType(theloai);
                List<Class> listTime = srModel.getDistinctTime();
                List<Class> listStatus = srModel.getStatusClass();
                request.setAttribute("listCl", listClassbyType);
                request.setAttribute("listTime", listTime);
                request.setAttribute("listStatus", listStatus);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (type.equals("LichThi")) {
                String theloai = "Lịch Thi";
                List<Class> listClassbyType = srModel.getClassbyType(theloai);
                List<Class> listTime = srModel.getDistinctTime();
                List<Class> listStatus = srModel.getStatusClass();
                request.setAttribute("listCl", listClassbyType);
                request.setAttribute("listTime", listTime);
                request.setAttribute("listStatus", listStatus);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        } else if (action.equals("SearchByStatus")) {
            String theloai = request.getParameter("theloai");
            List<Class> listClassByStatus = srModel.getClassbyStatus(theloai);
            List<Class> listTime = srModel.getDistinctTime();
            List<Class> listStatus = srModel.getStatusClass();
            request.setAttribute("listCl", listClassByStatus);
            request.setAttribute("listTime", listTime);
            request.setAttribute("listStatus", listStatus);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (action.equals("Searching")) {
            String key = request.getParameter("searchingkey");
            List<Class> listClassbyType = srModel.getClassBySearchingKey(key);
            List<Class> listTime = srModel.getDistinctTime();
            List<Class> listStatus = srModel.getStatusClass();
            request.setAttribute("listCl", listClassbyType);
            request.setAttribute("listTime", listTime);
            request.setAttribute("listStatus", listStatus);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (action.equals("Tim")) {
            String key = request.getParameter("datetime");
            List<Class> listClass = srModel.getClassBySearchingDateTime(key);
            List<Class> listTime = srModel.getDistinctTime();
            List<Class> listStatus = srModel.getStatusClass();
            request.setAttribute("listCl", listClass);
            request.setAttribute("listTime", listTime);
            request.setAttribute("listStatus", listStatus);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    public void getAllClass(ClassModel clModel, SearchingModel srModel, HttpServletRequest request, HttpServletResponse response) {
        try {
            // thực hiện lấy dữ liệu về sinh viên
            List<Class> listClass = clModel.getAllClass();
            List<Class> listTime = srModel.getDistinctTime();
            List<Class> listStatus = srModel.getStatusClass();
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
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
