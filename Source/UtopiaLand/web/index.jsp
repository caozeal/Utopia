<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	This is my JSP page.
	<br>
	<!-- <img src=":E:/FY_PRD_zhinengzhushou/60_source/testHtml/icon.png"> -->


	<form action="uploadFile" method="post" enctype="multipart/form-data">
		   <input type="file" name="file" /> <input type="submit"
			value="Submit" />
	</form>
	<!-- <div id="pdfShow" style="width:700px; height:600px;"></div>  -->
	<iframe id="pdfShow" width="700px" height="600px"></iframe>
	
<!-- jQuery -->
<script src="vendor/jquery/jquery.js"></script>

<script type="text/javascript">
   $(document).ready(function(){
	   $.post("openFile",function(data, status){
		   if(status=="success"){
			   $("#pdfShow").attr("src",data);
		   }
	   });
   });
</script>
</body>
</html>
