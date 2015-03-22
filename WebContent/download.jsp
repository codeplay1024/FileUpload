<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="demo.updown.file.model.UploadFiles"%>
<%@page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文件下载</title>
</head>
<body>
	<table align="center" width="50%" border="1">
		<tr>
			<td align="center">文件下载</td>
		</tr>
		<%
			List files = (ArrayList) request.getAttribute("fileList");
			for (int i = 0; i < files.size(); i++) {
				UploadFiles file = (UploadFiles) files.get(i);
		%>
		<tr>
			<td><a
				href="/updownfile/UpDownLoadAction.do?dispatch=downLoadFile&name=<%=file.getUploadRealName()%>&realname=<%=file.getUploadFileName()%>">
					<%=file.getUploadFileName()%></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>