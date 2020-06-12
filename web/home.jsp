<%-- 
    Document   : home
    Created on : Apr 25, 2020, 3:39:08 PM
    Author     : doanv
--%>
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

        <title>Web điểm danh</title>
    </head>

    <body>
        <div class="flex fl-ju-be nen-mau-xanh">
            <div>
                <a href="">
                    <img src="img/Group1.png" class="picture ml-3 mt-3 mb-3" width="35rem" alt="">
                </a>
            </div>
            <div>
                <h1 STYLE="color: white; padding-top: 12px;">ĐẠI HỌC ĐIỆN LỰC</h1>
            </div>
            <div class="flex ">
                <div>
                    <a data-toggle="modal" href="#thongtinsinhvien">
                        <img src="img/avatar/avatar.jpg" class="img-circle picture mt-3 mb-3" width="35rem" height="35rem" alt="">
                    </a>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="thongtinsinhvien" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <center><h5 class="modal-title" id="exampleModalLabel">THÔNG TIN SINH VIÊN</h5> </center>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <table border="1">
                                    
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                <a href="export/ThongKeSinhVien.xlsx" download><button type="button" class="btn btn-primary">Tải Xuống</button></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <a href="login.jsp" onclick="return  confirm('Bạn có chắc muốn đăng xuất không?')">
                        <img src="img/Group1226.png" class="picture mr-3 ml-3 mt-3 mb-3" width="35rem" alt="">
                    </a>
                </div>
            </div>
        </div>
        <!-- end header -->

        <div class="flex fl-ju-be mr-5 ml-5 mt-4 mb-5 fs-14">
            <div class="flex" 
                 >
                <div class="flex mr-5">
                    <div class="search" >
                        <button type="submit" class="btn btn-block" name="action"/>
                        <img src="img/iconsearch.png " class="picture " width="20rem" alt=" "x>
                        </button>
                    </div>
                    <div>
                        <form action="ClassServlet">
                            <input type="text" class="p-3 search" placeholder="Nhập khóa tìm kiếm" name="searchingkey">
                            <input type="submit" name="action" value="Searching">
                        </form>
                    </div>
                </div>
                <div class="mr-5" style="padding-top: 5px;">
                    <form action="ClassServlet">
                        <input type="date"  class="date1 text-center " name="datetime" id="">
                        <input type="submit" name="action" value="Tim">
                    </form>
                </div>
                <div class="mr-5 date1 text-center dropdown">
                    <button class="btn fs-14" style="width: 13.7rem;" data-toggle="dropdown">
                        <span class="fs-14">Thời gian</span>&nbsp;&nbsp;
                        <span>                 
                            <img src="img/chevron-down.png" class="picture " width="10rem"  alt=" ">
                        </span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${listTime}" var="time">
                            <li> <a href="ClassServlet?action=SearchByTime&ThoiGianBatDau=${time.thoiGianBatDau}&ThoiGianKetThuc=${time.thoiGianKetThuc}">
                                    ${time.thoiGianBatDau} - ${time.thoiGianKetThuc}
                                </a></li>
                            </c:forEach>
                    </ul>

                </div>
                <div class="mr-5 date1 text-center dropdown">
                    <button class="btn" style="width: 14rem;" data-toggle="dropdown">
                        <span class="fs-14">Thể loại</span>
                        &nbsp;&nbsp;
                        <span>                 
                            <img src="img/chevron-down.png" class="picture " width="10rem"  alt=" ">
                        </span>
                    </button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${listStatus}" var="status">
                            <li>
                                <a href="ClassServlet?action=SearchByStatus&theloai=${status.idTrangThai}">${status.trangThai}</a>
                            </li>
                        </c:forEach>
                    </ul>

                </div>

            </div>
            <div class="menu-right">
                <ul class="flex">
                    <li class ="active">
                        <a href="ClassServlet?action=GetAllClass">Tất cả</a>
                    </li>
                    <li>
                        <a href="ClassServlet?action=GetClassByType&Type=HangNgay">Hàng ngày</a>
                    </li>
                    <li>
                        <a href="ClassServlet?action=GetClassByType&Type=TinChi">Tín chỉ</a>
                    </li>
                    <li>
                        <a href="ClassServlet?action=GetClassByType&Type=LichHop">Lịch họp</a>
                    </li>
                    <li>
                        <a href="ClassServlet?action=GetClassByType&Type=LichThi">Lịch thi</a>
                    </li>
                </ul>
            </div>

        </div>

        <div class="container fs-14">
            <table class="table animate__animated animate__fadeInUp" style="animation-delay: 200ms;">
                <thead>
                    <tr>
                        <th scope="col">Type</th>
                        <th scope="col">Branch</th>
                        <th scope="col">Title</th>
                        <th scope="col">Name</th>
                        <th scope="col">Place</th>
                        <th scope="col">Time</th>
                        <th scope="col">Category</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCl}" var="cl" >
                        <tr >
                            <td>
                                <img src="img/${cl.color}.png" class="picture" width="14rem" alt="">&nbsp; ${cl.trangThai}
                            </td>
                            <td>${cl.tenLop}</td>
                            <td>${cl.tenMonHoc}</td>
                            <td>${cl.tenGiangVien}</td>
                            <td>${cl.place}</td>
                            <td>${cl.thoiGianBatDau} - ${cl.thoiGianKetThuc}</td>
                            <td>${cl.loaiLich}</td>
                            <td><a data-toggle="modal" href="#${cl.id_atteSchedule}">Thống kê</a></td>
                            <td>
                                <a data-toggle="modal" href="#xuatExcel">Xuất ra Excel &nbsp;
                                    <img src="img/icondownload.png"  alt="Tải Xuống">
                                </a>
                                <!--<a data-toggle="modal" href="#xuatExcel" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> <img src="img/icondownload.png"  alt="Tải Xuống">Tải Xuống</a>-->
                            </td>
                            <td>
                                <a href="StudentServlet?action=initListSt&tenLop=${cl.id_atteSchedule}">Chi tiết</a>

                            </td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>
            <c:forEach items="${listCl}" var="cl">
                <div class="DoiNhom-modal modal fade" id="${cl.id_atteSchedule}" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="close-modal" data-dismiss="modal">
                                <div class="lr">
                                    <div class="rl"></div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="row">
                                    <div class="modal-body">
                                        <!-- Project Details Go Here -->
                                        <h2 class="text-uppercase text-lg-center">Thống kê</h2>
                                        <table class="table">
                                            <tr>
                                                <td class="cantrai">Tên lớp : </td>
                                                <td class="canphai">${cl.tenLop}</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Thể loại : </td>
                                                <td class="canphai">${cl.loaiLich}</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Giảng Viên</td>
                                                <td class="canphai">${cl.tenGiangVien}</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Tên môn học : </td>
                                                <td class="canphai">${cl.tenMonHoc}</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Tiết : </td>
                                                <td class="canphai">${cl.thoiGianBatDau} - ${cl.thoiGianKetThuc}</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Ngày : </td>
                                                <td class="canphai">20/03/2020</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">Sĩ số lớp : </td>
                                                <td class="canphai">50/74</td>
                                            </tr>
                                            <tr>
                                                <td class="cantrai">% nghỉ học : </td>
                                                <td class="canphai">33%</td>
                                            </tr>
                                        </table>
                                        <center>
                                            <button class="btn btn-primary mg-auto" data-dismiss="modal" type="button">
                                                <i class="fas fa-times"></i>
                                                Đóng
                                            </button>
                                        </center>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <!-- Modal -->
            <div class="modal fade" id="xuatExcel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Xuất File Excel</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Bạn có chắc muốn tải xuống danh sách điểm danh của lớp này không?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                            <a href="export/ThongKeSinhVien.xlsx" download><button type="button" class="btn btn-primary">Tải Xuống</button></a>
                        </div>
                    </div>
                </div>
            </div>
            <a class="border rounded d-inline scroll-to-top" href="#page-top" style=""><i class="fas fa-angle-up"></i></a>
        </div>
        <script type="text/javascript">
            $(function () {
                $('.flex a').filter(function () {
                    return this.href == location.href
                }).parent().addClass('active').siblings().removeClass('active')
                $('.flex a').click(function () {
                    $(this).parent().addClass('active').siblings().removeClass('active')
                })
            })
        </script>
        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!--        <script src="js/MenuJS.js"></script>-->
    </body>

</html>
