<%-- 
    Document   : newjsp1
    Created on : 2017-7-5, 11:24:12
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <link rel="stylesheet" href='newcss.css' type='text/css'>
    </head>
    <body>
         <div class="wrapper">
            <div id="header">页眉</div>
            <div class="sidebar">侧边拦</div>
            <div class="content">主内容
        <form method="post" action="NewServlet">
                    <table border=1 width=100%>
                        <tr>
                            <td>请选择查询条件：</td>
                            <td>
                                <select id = "parent" name="parent">
                                    <option value="直线加速器"<%if ("直线加速器".equals(request.getParameter("parent"))){out.print(" selected ");}%>>
                                        直线加速器
                                    </option >
                                    <option value="增强器"<%if ("增强器".equals(request.getParameter("parent"))){out.print(" selected ");}%>>
                                        增强器
                                    </option>
                                </select>
                            </td>
                            <td>
                                <select id = "child" name="child" >
                                    
                                </select>
                            </td>

                            <td colspan="2" align="center"><input type="submit" value="Ok"></td>
                        </tr>
                    </table>
                </form>
        <table border=1 width=100%>

                    <tr>
                        <td align = "center">
                            系统
                        </td>
                        <td align="center">
                            组别
                        </td>
                        <td align="center">
                            组长
                        </td>
                        <td align="center">
                            所属组
                        </td>
                        <td align="center">
                            所属系统
                        </td>
                        <td align="center">
                            参数名称
                        </td>
                        <td align="center">
                            性质
                        </td>
                        <td align="center">
                            单位
                        </td>
                        <td align="center">
                            参数值
                        </td>
                        <td align="center">
                            日期
                        </td>
                        <td align="center">
                            定义
                        </td>
                        <td align="center">
                            参考文献
                        </td>
                        <td align="center">
                            参考文献作者
                        </td>
                        <td align="center">
                            出版社
                        </td>
                        <td align="center">
                            参考网址
                        </td>
                        <td align="center">
                            关键字
                        </td>
                    </tr>
                    <c:forEach items = "${dataList}" var="Data">
                        <tr>
                            <td>
                                ${Data.system.name}
                            </td>
                            <td>
                                ${Data.team.name}
                            </td>
                            <td>
                                ${Data.team.managerid.name}
                            </td>
                            <td>
                                ${Data.team.parentid.name}
                            </td>
                            <td>
                                ${Data.system.parentid.name}
                            </td>
                            <td>
                                ${Data.parameter.name}
                            </td>
                            <td>
                                ${Data.attribute.name}
                            </td>
                            <td>
                                ${Data.parameter.unitid.name}
                            </td>
                            <td>
                                ${Data.value}
                            </td>
                            <td>
                                ${Data.datemodified}
                            </td>
                            <td>
                                ${Data.comment}
                            </td>
                            <td>
                                ${Data.parameter.referenceid.title}
                            </td>
                            <td>
                                ${Data.parameter.referenceid.author}
                            </td>
                            <td>
                                ${Data.parameter.referenceid.publication}
                            </td>
                            <td>
                                ${Data.parameter.referenceid.url}
                            </td>
                            <td>
                                ${Data.parameter.referenceid.keywords}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
              </div>             
            <div id="footer">页脚</div>

        </div>                                    
    </body>
</html>
