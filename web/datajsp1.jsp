<%-- 
    Document   : datajsp1
    Created on : 2017-7-4, 16:49:34
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
        <div class="wrapper">
            <div id="header">页眉</div>
            <div class="sidebar">侧边拦</div>
            <div class="content">主内容
                <form name = "form1" method="post">
                    <table border=1 width=1000px >
                        <tr>
                            <td>请选择查询条件：</td>
                            <td>
                                <select id = "parent" name="parent" onclick="getChange()">
                                    <option value="0">请选择：</option>
                                    <option value="1">
                                        系统
                                    </option >
                                    <option value="2">
                                        组别
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
                <table border=1 width=1000px >

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

<style type="text/css">
    *{
        margin:0;
        padding:0;
    }
    .wrapper{
        width:1220px;
        margin-left: auto;
        margin-right: auto;
        color:#fff;
        font-size: 30px;
        text-align: center;
    }
    #header{
        height: 100px;
        background: #38382e;
        margin-bottom: 10px;
    }
    .sidebar{
        float: left;
        width: 200px;
        margin-right: 20px;
        margin-bottom: 10px;
        height: 900px;
        background: #5d33cf;
    }
    
    .content{
        float: left;
        width: 1000px;
        height: 900px;
        background: #c8ca30;
        margin-bottom: 10px;
    }
    
    #footer{
        background: #cc4ad5;
        height: 100px;
        clear: both;
    }
    </style>

