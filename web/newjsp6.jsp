<%-- 
    Document   : newjsp6
    Created on : 2017-7-26, 10:31:43
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
　　<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
　　<html>
　　<head>
　　<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
　　<title>Export to Excel - Demo</title>
　　</head>
　　<body>
        <%
            String exportToExcel = request.getParameter("exportToExcel");

            if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {

                response.setContentType("application/vnd.ms-excel;charset=gb2312");

                response.setHeader("Content-Disposition", "attachment;filename=" + "excel.xls");
            }
        %>
　　<table align="left" border="2">
　　<thead>
　　<tr bgcolor="lightgreen">
　　<th>Sr. No.</th>
　　<th>Text Data</th>
　　<th>Number Data</th>
　　</tr>
　　</thead>
　　<tbody>
　　<% for (int i = 0; i < 10; i++) { %>
　　<tr bgcolor="lightblue">
　　<td align="center"><%=i + 1%></td>
　　<td align="center">This is text data <%=i%></td>
　　<td align="center"><%=i * i%></td>
　　</tr>
　　<%}%>

　　</tbody>
　　</table>
　　
　　<%if (exportToExcel == null) {%>

　　<a href="newjsp6.jsp?exportToExcel=YES">Export to Excel</a>
  <input type="button" name="saveAs" value="saveAs" onclick="newjsp6.jsp?exportToExcel=YES">

　　<%}%>

　　</body>
　　</html>
