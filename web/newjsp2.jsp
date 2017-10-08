<%-- 
    Document   : datajsp
    Created on : 2017-7-4, 16:49:34
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"> 
        <meta name="renderer" content="ie-comp">
        <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
         

        <title>JSP Page</title>
        <link rel="stylesheet" href='http://192.168.206.153:8080/WebApplication2/newcss.css' type='text/css'>
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
        <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="http://192.168.206.153:8080/WebApplication2/selectjs.js"></script>
    </head>

    <body>
        <%
            String exportToExcel = request.getParameter("exportToExcel");

            if (exportToExcel != null && exportToExcel.toString().equalsIgnoreCase("YES")) {

                response.setContentType("application/vnd.ms-excel;charset=UTF-8");

                response.setHeader("Content-Disposition", "inline;filename=" + "excel.xls");
            }
        %>
        <div class="wrapper">
            <div id="header">
                
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default">关于</button>
                    <button type="button" class="btn btn-default">帮助</button>
                    <button type="button" class="btn btn-default">联系我们</button>
                </div>
            </div>

            <div class="sidebar">

                <ul class="nav nav-pills nav-stacked">
                    <li role="presentation" class="disabled"><a href="#">数据导入</a></li>
                    
                    <li role="presentation" class="active"><a href="http://192.168.206.153:8080/WebApplication2/newjsp2.jsp">数据查询</a></li>

                    <li class="dropdown disabled">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            数据导出 <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">全部导出</a></li>

                            <li class="divider"></li>
                            <li><a href="#">查询结果导出</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <div class="content">
                <c:set var="totalUsers" value="${requestScope.totalUsers}"/>
                <c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
                <c:set var="totalPages" value="${requestScope.totalPages}"/>
                <c:set var="beginIndex" value="${requestScope.beginIndex}"/>
                <c:set var="endIndex" value="${requestScope.endIndex}"/>
                <c:set var="page" value="${requestScope.page}"/>
                <c:set var="currentPageUsers" value="${requestScope.users.subList(beginIndex,endIndex)}"/>
                <c:set var="parentName" value="${requestScope.parentName}"/>
                <%--
                                <p>用户总数:${totalUsers}</p>
                                <p>每页用户数:${usersPerPage}</p>
                                <p>总页数:${totalPages}</p>
                                <p>当前页:${page}</p>
                                <p>parentName:${parentName}</p>

                --%>


                <form name="form1" action="ListAllServlet" method="get">
                    <table border=1>
                        <tr>
                            <td>请选择查询条件：</td>
                            <td>
                                <select id = "parent" name="parent" onclick="getChange()">
                                    <option value="0">请选择：</option>
                                    <option value="系统"<%if ("系统".equals(request.getParameter("parent"))) {
                                            out.print(" selected ");
                                        }%>>
                                        系统
                                    </option >
                                    <option value="组别"<%if ("组别".equals(request.getParameter("parent"))) {
                                            out.print(" selected ");
                                        }%>>
                                        组别
                                    </option>
                                </select>
                            </td>
                            <td>
                                <select id = "child" name="child" style="width:320px">

                                </select>
                            </td>

                            <td colspan="2" align="center"><input type="submit" value="确定"></td>

                        </tr>
                    </table>

                    <table border=1>

                        <tr>
                            <th width="100px" align="center">
                                系统
                            </th>
                            <th width="30px" align="center">
                                组别
                            </th>
                            <th width="30px" align="center">
                                组长
                            </th>
                            <th width="30px" align="center">
                                所属组
                            </th>
                            <th width="30px" align="center">
                                所属系统
                            </th>
                            <th width="100px" align="center">
                                参数名称
                            </th>
                            <th width="30px" align="center">
                                性质
                            </th>
                            <th width="30px" align="center">
                                单位
                            </th>
                            <th width="90px" align="center">
                                参数值
                            </th>
                            <th width="120px" align="center">
                                日期
                            </th>
                            <th width="100px" align="center">
                                定义
                            </th>
                            <th width="100px" align="center">
                                参考文献
                            </th>
                            <th width="50px" align="center">
                                参考文献作者
                            </th>
                            <th width="50px" align="center">
                                出版社
                            </th>
                            <th width="50px" align="center">
                                参考网址
                            </th>
                            <th width="50px" align="center">
                                关键字
                            </th>
                        </tr>
                        <c:forEach items = "${currentPageUsers}" var="Data">
                            <tr>
                                <td align="left">
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
                                <td type="date" dateStyle="short">
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

                    <ul class="pagination  pagination-sm">
                        <li><a href="ListAllServlet1?status=processRequest&page=1">首页</a></li>
                        <li><a href="<c:url value="/ListAllServlet1?page=${page-1>1?page-1:1}"/>">&laquo;</a></li>

                        <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                            <c:set var="active" value="${loop.index==page?'active':''}"/>
                            <li class="${active}"><a
                                    href="<c:url value="/ListAllServlet1?page=${loop.index}"/>">${loop.index}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="<c:url value="/ListAllServlet1?page=${page+1<totalPages?page+1:totalPages}"/>">&raquo;</a>
                        </li>
                        <li><a href="<c:url value="/ListAllServlet1?page=${totalPages}"/>">尾页</a></li>
                    </ul>

                </form>                      

            </div>             
            <div id="footer">Copyright 中国科学院高能物理研究所</div>

        </div>                     
    </body>

</html>


