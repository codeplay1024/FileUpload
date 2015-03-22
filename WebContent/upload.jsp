<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/taglib/struts-html.tld" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<!--addMore函数可以提供上传多个文件上传-->
	var index = 1;
	function addMore() {
		var td = document.getElementById("more");
		var br = document.createElement("br");
		var input = document.createElement("input");
		var button = document.createElement("input");
		input.type = "file";
		input.name = "file[" + index + "]";
		button.type = "button";
		button.value = "   删除    ";
		button.onclick = function() {
			td.removeChild(br);
			td.removeChild(input);
			td.removeChild(button);
		}
		td.appendChild(br);
		td.appendChild(input);
		td.appendChild(button);
		index++;
	}
</script>
</head>
<body>
	<!--<h3><font color="red">上传文件类型后缀为doc,ppt,xls,pdf,txt,java，每个文件大小不能大于50M</font></h3>-->
	<html:form action="/UpDownLoadAction.do?dispatch=upLoadFile"
		method="post" enctype="multipart/form-data">
		<table align="center" width="50%" border="1">
			<tr>
				<td>上传文件</td>
				<td id="more"><input type="file" id="file_0" name="file[0]" />
					<input type="button" value="上传更多..." onclick="addMore()"></td>
			</tr>
			<tr>
				<td><html:submit value=" 确认 "></html:submit></td>
				<td><html:reset value=" 重置 "></html:reset></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>