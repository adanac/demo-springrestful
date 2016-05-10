<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"
		+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title> 你好</title>
<!-- PUT DELETE 就和表单不一样了, 因为表单只支持GET和POST
	这时候就需要用到ajax,  或者nodejs调用 
	-->
<script type="text/javascript" src='<%=basePath%>/public/js/jquery-2.1.0.min.js'></script>
<script type="text/javascript">
	function savepro(){
 	var saveData = {"pid":"aa"}; //发送给服务器的JSON
	  $.ajax({
		  type : "PUT",
		  url : "/RestFulMvc/api/products/info.json",
		  data:JSON.stringify(saveData),
		  contentType:"application/json",  //发送至服务器的类型
		  dataType : "json",     //预期服务器返回类型
		  success: function(data){
		   	alert(data);
		  }
	  })
	}
</script>
</head>
<body>
    ${name}
    <form action="<%=basePath%>/api/products/info" method="post">
         <input type="text" name="pid"/> 
         <input type="text" name="pname"/> 
         <input type="submit"/>
    </form>
    
    <div>
		<input type="button" value="保存" onclick="savepro()"/>
	</div>
</body>
</html>