<%-- 
    Document   : error
    Created on : May 13, 2020, 9:58:45 AM
    Author     : doanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hệ Thống Đang Bảo Trì</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Hệ Thống Đang Bảo Trì" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Custom Theme files -->
        <link href="css/error.css" rel="stylesheet" type="text/css" media="all" />
        <!-- //Custom Theme files -->
        <!-- web font -->
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->
        <!-- //web font -->
    </head>
    <body>
        <!-- main -->
        <div class="agileits-main"> 
            <div class="agileinfo-row">

                <div class="w3layouts-errortext">
                    <h2>4<span>0</span>4</h2>
                    <h1>Xin Lỗi! Chức Năng Bạn Vừa Truy Cập Hiện Đang Được Bảo Trì</h1>
                    <p class="w3lstext">Chúng tôi sẽ cố gắng làm việc để xứ lý!<br> Trong lúc đó, bạn có thể quay lại trang đăng nhập với <a href="login.jsp">Đăng nhập</a> Vui lòng để lại thông tin của bạn để chúng tôi có thể thông báo tới bạn khi hệ thống sẵn sàng:</p>
                    <div class="agile-search"> 
                        <form action="errorServlet">
                            <input type="text" name="email" placeholder="Nhập Email của bạn tại đây ...."/>
                            <input type="submit" name="action" value="Send" />
                        </form> 
                    </div>
                    <div class="w3top-nav-right">	
                        <ul>
                            <li><a href="home.jsp">Home</a></li>
                            <li><a href="#">About</a></li>  
                            <li><a href="#">Blog</a></li> 
                            <li><a href="#">Contact</a></li>
                        </ul> 
                    </div>	
                </div>	
            </div>	
        </div>	
        <!-- //main -->
        <!-- copyright -->
        <div class="copyright w3-agile">
            <p>© 2020 Electric Power University . All rights reserved | Design by <a href="https://www.facebook.com/Crystal.Viet.99" target="_blank">Đinh Doãn Việt</a></p>
        </div>
        <!-- //copyright --> 
    </body>
</html>
