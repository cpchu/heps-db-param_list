<%-- 
    Document   : newjsp
    Created on : 2017-6-29, 10:06:17
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border=1 width=10%>
            <tr>
                <td align = "center">
                    单位编号
                </td>
                <td align="center">
                    单位名称
                </td>
                    
            </tr>
            <c:forEach items = "${unitList}" var="Unit">
                <tr>
                    <td>
                        ${Unit.id}
                    </td>
                    <td>
                        ${Unit.name}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
