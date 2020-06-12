<%-- 
    Document   : login
    Created on : Apr 26, 2020, 2:29:33 PM
    Author     : doanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EPU - Đăng Nhập</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <!--<link href="css/animate.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="img/logo.png"/>
    </head>
    <body>
        <img class="wave" src="img/login/wave.png">
        <div class="container">
            <div class="img">
                <img class="animate__animated animate__backInUp" src="img/login/bg.svg">
            </div>
            <div class="login-content ">
                <form action="Login">
                    <div class ="animate__animated animate__backInDown">
                        <img  src="img/login/avatar.svg">
                        <h2 class="title">Welcome</h2>
                    </div>
                    <div class="animate__animated animate__backInUp">
                        <div class="input-div one">
                            <div class="i">
                                <i class="fas fa-user"></i>
                            </div>
                            <div class="div">
                                <h5>Tài Khoản</h5>
                                <input type="text" class="input" name="username" value="${taikhoan}">
                            </div>
                        </div>
                        <div class="input-div pass">
                            <div class="i"> 
                                <i class="fas fa-lock"></i>
                            </div>
                            <div class="div">
                                <h5>Mật Khẩu</h5>
                                <input type="password" class="input" name="password" value="${matkhau}">
                            </div>
                        
                    </div>
                    <a href="ForgotPassWord.jsp">Quên Mật Khẩu?</a>
                    <div class="error" style="color:red;">${error}</div>
                    <input type="submit" class="btn" value="Login" name="action">
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/login.js"></script>
    </body>
</html>

