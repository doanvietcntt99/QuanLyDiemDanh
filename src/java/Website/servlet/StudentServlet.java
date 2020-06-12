/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Website.servlet;

import Website.entity.Class;
import Website.entity.Student;
import Website.model.ClassModel;
import Website.model.ExportModel;
import Website.model.StudentModel;

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
public class StudentServlet extends HttpServlet {

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
        StudentModel stModel = new StudentModel();
        ClassModel clModel = new ClassModel();
        ExportModel exModel = new ExportModel();
        // Lấy tham số action từ Request
        String action = request.getParameter("action");
        if (action.equals("initListSt")) {
            String tenLop = request.getParameter("tenLop");
            try {
                //Gọi sang model lấy thông tin sinh viên
                List<Student> listSt = stModel.getAllStudentbyTenLop(tenLop);
                // Thực hiện lấy dữ liệu của lớp
                List<Class> dataLop = clModel.getThongTinbyTenLop(tenLop);
                // add listStudent vào REquest
                request.setAttribute("listST", listSt);
                request.setAttribute("dataLop", dataLop);
                
                // Gọi sang trang chitietlop.jsp
                request.getRequestDispatcher("listStudent.jsp").forward(request, response);

            } catch (ServletException | IOException ex) {
                Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("UpdateStatus")) {
            String maLop = request.getParameter("tenLop");
            String maSV = request.getParameter("MaSV");
            Boolean check = Boolean.parseBoolean(request.getParameter("TrangThai"));
            Boolean checkafter = false;
            if (check) {
                checkafter = false;
            } else {
                checkafter = true;
            }
            Boolean KetQua = stModel.UpdateStatusDiemDanh(maLop, maSV, checkafter);
            if (KetQua) {
                String tenLop = request.getParameter("tenLop");
                try {
                    //Gọi sang model lấy thông tin sinh viên
                    List<Student> listSt = stModel.getAllStudentbyTenLop(tenLop);
                    // Thực hiện lấy dữ liệu của lớp
                    List<Class> dataLop = clModel.getThongTinbyTenLop(tenLop);
                    // add listStudent vào REquest
                    request.setAttribute("listST", listSt);
                    request.setAttribute("dataLop", dataLop);
                    // Gọi sang trang chitietlop.jsp
                    request.getRequestDispatcher("listStudent.jsp").forward(request, response);

                } catch (ServletException | IOException ex) {
                    Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if (action.equals("createfile")) {
            String tenLop = request.getParameter("tenLop");
            try {
                List<Student> listSt = stModel.getAllStudentbyTenLop(tenLop);
                String tenfile = exModel.exportfile(listSt);
                request.setAttribute("tenfile", tenfile);
                request.getRequestDispatcher("download.jsp").forward(request, response);

            } catch (ServletException | IOException ex) {
                Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("Save")) {
            String idLop = request.getParameter("idlop");
            String masv = request.getParameter("masv");
            String note = request.getParameter("note");
            boolean check = stModel.UpdateNote(idLop, masv, note);
            if (check) {
                String tenLop = request.getParameter("idlop");
                try {
                    //Gọi sang model lấy thông tin sinh viên
                    List<Student> listSt = stModel.getAllStudentbyTenLop(tenLop);
                    // Thực hiện lấy dữ liệu của lớp
                    List<Class> dataLop = clModel.getThongTinbyTenLop(tenLop);
                    // add listStudent vào REquest
                    request.setAttribute("listST", listSt);
                    request.setAttribute("dataLop", dataLop);
                    
                    // Gọi sang trang chitietlop.jsp
                    request.getRequestDispatcher("listStudent.jsp").forward(request, response);

                } catch (ServletException | IOException ex) {
                    Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }    
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
