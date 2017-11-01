<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>

<%@page isELIgnored="false"%>
<%
  java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  java.util.Date currentTime = new java.util.Date();//得到当前系统时间

  String str_date1 = formatter.format(currentTime); //将日期时间格式化
  String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式
%>
<html>
<jsp:include page="/commonpage/header.jsp" flush="true"/>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">



  <jsp:include page="/commonpage/meau.jsp" flush="true"/>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
  <center style="padding-top: 200px;"> 欢迎登录管理页面!<%=str_date2%></center>
  </div>
  <jsp:include page="/commonpage/footer.jsp" flush="true"/>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<jsp:include page="/commonpage/js.jsp" flush="true"/>
</body>
</html>
