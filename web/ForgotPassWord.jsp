<%-- 
    Document   : login
    Created on : Apr 26, 2020, 2:29:33 PM
    Author     : doanv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quên Mật Khẩu</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="stylesheet" type="text/css" href="css/animate.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <img class="wave" src="img/login/wave.png">
        <div class="container">
            <div class="img">
                <img class="slideInLeft" src="img/login/bg.svg">
            </div>
            <div class="login-content">
                <form action="Login">
                    <img class="bounceInDown" src="img/login/avatar.svg">
                    <h2 class="title" style="font-size: 2.0rem;">Quên Mật Khẩu</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <h5>Nhập Email Tài Khoản</h5>
                            <input type="text" class="input" name="username">
                        </div>
                    </div>
                    <input type="submit" class="btn" value="Forgot Password" name="action">
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/login.js"></script>
    </body>
</html>

