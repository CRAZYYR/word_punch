<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>"/>

<%@page isELIgnored="false" %>
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
        <center><h1 style="color: #4c4c4c">考勤查询</h1></center>
        <section class="content">

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">
                                <form >
                                开始:<input id="startDate" type="date" name="startDate">结束:<input id="endDate" type="date" name="endDate"> 状态<select id="attendStatus" name="attendStatus">
                                <option  value="0">全部</option>
                                <option  value="1">正常</option>
                                <option  value="2">异常</option>
                            </select> <input id="search_all" type="button" value="查询"/></form> </h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                                <div class="row">
                                    <div class="col-sm-6"></div>
                                    <div class="col-sm-6"></div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table id="example2" class="table table-bordered table-hover dataTable"
                                               role="grid" aria-describedby="example2_info">
                                            <thead>
                                            <tr role="row">
                                                <th class="sorting_asc" tabindex="0" aria-controls="example2"
                                                    rowspan="1" colspan="1" aria-sort="ascending"
                                                    aria-label="Rendering engine: activate to sort column descending">
                                                    序号
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1" aria-label="Browser: activate to sort column ascending">
                                                    考勤日期
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1"
                                                    aria-label="Platform(s): activate to sort column ascending">
                                                   早大打卡
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1"
                                                    aria-label="Engine version: activate to sort column ascending">
                                                    晚打卡
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending">缺勤时长
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending">考勤状态
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1"
                                                    colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending">操作
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="tr_append">



                                            </tbody>
                                          
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-5" id="page_draw">
                           
                                    </div>
                                    <div class="col-sm-7">
                                        <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button previous disabled" id="example2_previous"><a
                                                        href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">Previous</a>
                                                </li>
                                                <li class="paginate_button active"><a href="#" aria-controls="example2"
                                                                                      data-dt-idx="1" tabindex="0">1</a>
                                                </li>
                                                <li class="paginate_button "><a href="#" aria-controls="example2"
                                                                                data-dt-idx="2" tabindex="0">2</a></li>
                                                <li class="paginate_button "><a href="#" aria-controls="example2"
                                                                                data-dt-idx="3" tabindex="0">3</a></li>
                                                <li class="paginate_button "><a href="#" aria-controls="example2"
                                                                                data-dt-idx="4" tabindex="0">4</a></li>
                                                <li class="paginate_button "><a href="#" aria-controls="example2"
                                                                                data-dt-idx="5" tabindex="0">5</a></li>
                                                <li class="paginate_button "><a href="#" aria-controls="example2"
                                                                                data-dt-idx="6" tabindex="0">6</a></li>
                                                <li class="paginate_button next" id="example2_next"><a href="#"
                                                                                                       aria-controls="example2"
                                                                                                       data-dt-idx="7"
                                                                                                       tabindex="0">Next</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->


                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
    </div>
    <jsp:include page="/commonpage/footer.jsp" flush="true"/>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>

<%--异步数据处理--%>
<script src="/static/jquery/jquery-2.2.3.min.js"></script>
<script>

function getMyDate(str){  
    if ( str== undefined) {return '无记录';}
            var oDate = new Date(str),  
            oYear = oDate.getFullYear(),  
            oMonth = oDate.getMonth()+1,  
            oDay = oDate.getDate(),  
            oHour = oDate.getHours(),  
            oMin = oDate.getMinutes(),  
            oSen = oDate.getSeconds(),  
            oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' ';//最后拼接时间  
            return oTime;  
        }; 

function getDateMy(str){  
     if ( str== undefined) {return '无记录';}
            var oDate = new Date(str),  
            oYear = oDate.getFullYear(),  
            oMonth = oDate.getMonth()+1,  
            oDay = oDate.getDate(),  
            oHour = oDate.getHours(),  
            oMin = oDate.getMinutes(),  
            oSen = oDate.getSeconds(),  
            oTime =  getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
            return oTime;  
        }; 

        //补0操作
      function getzf(num){  
          if(parseInt(num) < 10){  
              num = '0'+num;  
          }  
          return num;  
      }

    $("#search_all").click(function(){
        var startDate=$("#startDate").val();
        var endDate=$("#endDate").val();
        var attendStatus=$("#attendStatus").val();
        var url= "<%=basePath%>attend/signList.do";
      

var str='';






        if (attendStatus=='0') {
    $.ajax({
    url: url,
    data:{"startDate":startDate,"endDate":endDate},
    type: "POST",
    dataType:'json',
    success:function(data){
// var data=eval('('+data+')');
 // var data=JSON.parse(data["items"]);
 var str_pagea=  '<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">总页数:'+


data["totalPage"]+'每页显示:'+ data["pageSize"] + '数据总数:'+data["totalRows"]+'</div>';

$("#page_draw").append(str_pagea);
var data1=data["items"];
 for(var i=0;i<data1.length;i++){  
if (data1[i]["absence"]==1) {data1[i]["absence"]='正常';}
if (data1[i]["absence"]==2) {data1[i]["absence"]='异常';}
     str+=  '<tr role="row" class="odd">';
    str+='<th rowspan="1" colspan="1">'+data1[i]["attendId"]+'</th>';
    str+='<th rowspan="1" colspan="1">'+getMyDate(data1[i]["attendDate"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+getDateMy(data1[i]["attendMoning"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+getDateMy(data1[i]["attendEvening"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+data1[i]["absence"]+'</th>';
 str+='<th rowspan="1" colspan="1">'+data1[i]["attendStatus"]+'</th>';
 str+='<th rowspan="1" colspan="1">修改|删除</th>';
 str+='</tr>';
}  
$("#tr_append").append(str);


// alert(str);
    },
    error:function(er){
    BackErr(er);}
    });

        }else{
              $.ajax({
    url: url,
    data:{"startDate":startDate,"endDate":endDate,"attendStatus":attendStatus},
    type: "POST",
    dataType:'json',
    success:function(status){
 var str_pagea=  '<div class="dataTables_info" id="example2_info" role="status" aria-live="polite">总页数:'+


data["totalPage"]+'每页显示:'+ data["pageSize"] + '数据总数:'+data["totalRows"]+'</div>';

$("#page_draw").append(str_pagea);
var data1=data["items"];
 for(var i=0;i<data1.length;i++){  
if (data1[i]["absence"]==1) {data1[i]["absence"]='正常';}
if (data1[i]["absence"]==2) {data1[i]["absence"]='异常';}
     str+=  '<tr role="row" class="odd">';
    str+='<th rowspan="1" colspan="1">'+data1[i]["attendId"]+'</th>';
    str+='<th rowspan="1" colspan="1">'+getMyDate(data1[i]["attendDate"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+getDateMy(data1[i]["attendMoning"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+getDateMy(data1[i]["attendEvening"])+'</th>';
    str+='<th rowspan="1" colspan="1">'+data1[i]["absence"]+'</th>';
 str+='<th rowspan="1" colspan="1">'+data1[i]["attendStatus"]+'</th>';
 str+='<th rowspan="1" colspan="1">修改|删除</th>';
 str+='</tr>';
}  
$("#tr_append").append(str);

    },
    error:function(er){
    BackErr(er);}
    });  
        }




   })


</script>

<!-- ./wrapper -->
<jsp:include page="/commonpage/js.jsp" flush="true"/>
</body>
</html>

