<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Hello word</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="h">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript">
   //点击提交的时候传递json相关的字符串
  	$(function(){
  	  $.fn.serializeJson = function() {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(
                function() {
                    if (serializeObj[this.name]) {
                        if ($.isArray(serializeObj[this.name])) {
                            serializeObj[this.name].push(this.value);
                        } else {
                            serializeObj[this.name] = [
                                    serializeObj[this.name], this.value ];
                        }
                    } else {
                        serializeObj[this.name] = this.value;
                    }
                });
        return serializeObj;
    };
	$("input[type='button']").click(function(){
		
		var obj={
				id:1,
				name:2
		};
		
		$.ajax({
			type:"POST",
			contentType:'application/json',
			url:"/save",
			data:JSON.stringify($("#frm").serializeJson()),
			dataType:'json',
			success:function(data){
				alert(data);
			},
			failure:function(data){
				alert(data);
			}
		})
	})
  	})
  </script>
  </head>
  
  <body>
     <form id="frm" >
     	<label>input</label><input type="text" name="id"/><br>
     	<label>radio</label><input type="radio" name="name" />radio1<input type="radio" name="name" />radio2<br>
     	<!-- <label>checkbox</label><input type="checkbox" name="test03">checkbox1<input type="checkbox" name="test03">checkbox2<input type="checkbox" name="test03">checkbox3<br>
     	<label>select</label>
     	<select name="test04" >
     		<option value="1" >1</option>
     		<option value="2" >2</option>
     		<option value="3" >3</option>
     		<option value="4" >4</option>
     	</select>
     	<br>
     	<label>textarea</label>
     	<textarea rows="2" cols="3" name="test05"></textarea><br> -->
     	<input type="button" value="提交" nam="btn" />
     </form>
  </body>

</html>
