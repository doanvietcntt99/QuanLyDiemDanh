<%-- 
    Document   : chitietlop
    Created on : Apr 25, 2020, 3:42:23 PM
    Author     : doanv
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/webdd.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
        <title>[EPU] Chi tiết điểm danh</title>
    </head>

    <body>
        <div class="flex fl-ju-be nen-mau-xanh">
            <div>
                <a href="home.jsp">
                    <img src="img/Group1.png" class="picture ml-3 mt-3 mb-3" width="35rem" alt="">
                </a>
            </div>
            <div class="flex ">
                <div>
                    <a href="">
                        <img src="img/avatar.jpg" class="img-circle picture mt-3 mb-3" width="35rem" height="35rem" alt="">
                    </a>
                </div>
                <div>
                    <a href="login.jsp" onclick="return  confirm('Bạn có chắc muốn đăng xuất không?')">
                        <img src="img/Group1226.png" class="picture mr-3 ml-3 mt-3 mb-3" width="35rem" alt="">
                    </a>
                </div>
            </div>
        </div>
        <div class="container mt-3 " >
            <c:forEach items="${dataLop}" var="dt">
                <div class="jumbo animate__animated animate__fadeInUp" style="animation-delay: 200ms;">
                    <div class="row mb-4">
                        <div class="col-2">Lớp:</div>
                        <div class="col-3">${dt.tenLop}</div>
                        <div class="col-2">Môn học:</div>
                        <div class="col-2">${dt.tenMonHoc}</div>
                        <div class="col-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-2">Giảng viên:</div>
                        <div class="col-3">${dt.tenGiangVien}</div>
                        <div class="col-2">Thời gian:</div>
                        <div class="col-2">${dt.thoiGianBatDau} - ${dt.thoiGianKetThuc}</div>
                        <div class="col-3">
                            <img src="img/sea.png" class="picture" width="14rem" alt="">&nbsp; Đã điểm danh
                        </div>
                    </div>
                </div>
            </c:forEach>
            <table class="table mt-3 fs-14 animate__animated animate__fadeInUp" style="animation-delay: 300ms;">
                <thead>
                    <tr class="nen-mau-xanh mautrang">
                        <td scope="col">MÃ SINH VIÊN</td>
                        <td scope="col">TÊN SINH VIÊN</td>
                        <td scope="col">MÃ LỚP</td>
                        <td scope="col">ĐIỂM DANH</td>
                        <td scope="col">GHI CHÚ</td>
                        <td scope="col"><center>HÀNH ĐỘNG</center></td>
                </tr>
                </thead>

                <tbody class="cl-text-xanhthan">
                    <c:forEach items="${dataLop}" var="dt">
                        <c:forEach items="${listST}" var="st">
                            <tr>
                                <td scope="col">${st.maSV}</td>
                                <td scope="col">${st.tenSV}</td>
                                <td scope="col">${st.lopCN}</td>
                                <td scope="col">
                                    <a href="StudentServlet?action=UpdateStatus&TrangThai=${st.isDiemDanh}&tenLop=${dt.id_atteSchedule}&MaSV=${st.maSV}" onclick="return  confirm('Bạn có chắc chắn cập nhật trạng thái cho sinh viên ${st.tenSV} không?')">
                                        <img src="img/${st.color}.png" class="picture" width="16rem" alt="" style="margin-left: 30px;">
                                    </a>
                                </td>
                                <td scope="col">
                                    ${st.noteDiemDanh}
                                </td>
                                <td scope="col">
                        <center>
                            <a data-toggle="modal" href="#${st.idUser}"><button class="btn btn-primary mg-auto" type="button">
                                    <i class="fas fa-times"></i>
                                    Update
                                </button></a>
                        </center>
                        </td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </tbody>

            </table>
            <c:forEach items="${dataLop}" var="dt">
                <c:forEach items="${listST}" var="st">
                    <div class="DoiNhom-modal modal fade" id="${st.idUser}" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <form action="StudentServlet">
                                    <div class="container">
                                        <div class="row">
                                            <div class="modal-body">
                                                <!-- Project Details Go Here -->
                                                <h2 class="text-uppercase text-lg-center" >Chi tiết</h2>
                                                <div class="thongtinchitiet" style="width:100%">
                                                    <table class="table">
                                                        <tr>
                                                            <td class="cantrai">Mã Sinh Viên </td>
                                                            <td class="canphai"><input type="text" name="masv" value="${st.maSV}" readonly="true" style="border:none; text-align: right;"></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="cantrai">Họ và Tên Sinh Viên: </td>
                                                            <td class="canphai">${st.tenSV}</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="cantrai">Lớp Biên Chế :</td>
                                                            <td class="canphai">${st.lopCN}</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="cantrai">Lớp Tín Chỉ :</td>
                                                            <td class="canphai"><input type="text" name="idlop" value="${dt.id_atteSchedule}" readonly="true" style="border:none; text-align: right;"></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="cantrai">Trạng Thái Điểm Danh:</td>
                                                            <td class="canphai"><img src="img/${st.color}.png" class="picture" width="16rem" alt="" style="margin-left: 30px;"></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="cantrai">Ghi Chú</td>
                                                            <td class="canphai"><input type="text" name="note" value="${st.noteDiemDanh}"></td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <center>
                                                    <input class="btn btn-primary mg-auto" type="submit" value="Save" name="action" onclick="return  confirm('Bạn có chắc muốn lưu không?')">
                                                    <i class="fas fa-times"></i>
                                                    </input>
                                                    <button class="btn btn-primary mg-auto" data-dismiss="modal" type="button">
                                                        <i class="fas fa-times"></i>
                                                        Đóng
                                                    </button>
                                                </center>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </c:forEach>
            
        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!--        <script src="js/MenuJS.js"></script>-->
    </body>

</html>

