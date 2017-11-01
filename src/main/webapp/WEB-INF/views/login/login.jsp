<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>欢迎来到登陆界面!</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.min.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
      <b>管理 </b>For Your
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">随风、随心</p>


        <span style="color: red">${message}</span>

        <form action="<%=basePath%>login/login.do" method="post" id="login">
            <div class="form-group has-feedback">
                <input id="uname" name="uname" type="text" class="form-control" placeholder="请输入你的邮箱地址!">
                <span class="fa fa-fw fa-user form-control-feedback"></span>
                <span id="user_ualert" style="color: #b92c28;visibility: hidden;">请输入帐号！</span>
            </div>
            <div class="form-group has-feedback">
                <input name="upw" id="upwd" type="password" class="form-control" placeholder="请输入你的密码!">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span id="pwd_ualert" style="color: #b92c28;visibility: hidden;">请输入密码！</span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 记住
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button id="subID" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <%--<div class="social-auth-links text-center">--%>
            <%--<p>- OR -</p>--%>
            <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using--%>
                <%--Facebook</a>--%>
            <%--<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using--%>
                <%--Google+</a>--%>
        <%--</div>--%>
        <!-- /.social-auth-links -->



    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $("#subID").click(function () {
            var veryfiy=true;
            var uname=$("#uname").val();
            var upwd=$("#upwd").val();
            if (uname.length==0){
                $("#user_ualert").css("visibility","visible");
                veryfiy=false;
            }else{
                $("#user_ualert").css("visibility","hidden");
            }
            if (upwd.length==0){
                $("#pwd_ualert").css("visibility","visible");
                veryfiy=false;
            }else {
                $("#user_ualert").css("visibility","hidden");
            }
            if (   veryfiy){
                $("#login").submit();
            }

        })
    });
</script>
</body>
</html>

