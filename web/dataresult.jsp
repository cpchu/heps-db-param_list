<%-- 
    Document   : datajsp
    Created on : 2017-7-4, 16:49:34
    Author     : Administrator
--%>

<%@page import="jpa.entities.Team"%>

<%@page import="jpa.controller.TeamJpaController"%>
<%@page import="java.util.List"%>
<%@page import="jpa.controller.SystemJpaController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%!
    
            TeamJpaController teamJpaController = new TeamJpaController();
            List<Team> teamList = teamJpaController.findTeamEntities();
            String[] teamString=new String[teamList.size()];
            SystemJpaController systemJpaController = new SystemJpaController();
            List<jpa.entities.System> systemList = systemJpaController.findSystemEntities();
            String[] sysString=new String[systemList.size()];
    %>
    <%
        for(int i=0;i<sysString.length;i++){
            sysString[i]=systemList.get(i).getName();
        }
        for(int j=0;j<teamString.length;j++){
            teamString[j]=teamList.get(j).getName();
        }
        %>
        <script language="JavaScript">
    function getChange() {
var p = document.getElementById("parent");
var c = document.getElementById("child");
var len=c.options.length;
var index=p.selectedIndex;
   
                    if(index===0){
                         c.options.length=0;     
                                        
                       <%for(int j=0;j<sysString.length;j++){%>
                                   
                                c.options.add(new Option('<%=sysString[j]%>','<%=sysString[j]%>'));
                        <%}%>
                         
                    } 
                    if(index===1){
                        c.options.length=0; 
                        <%for(int j=0;j<teamString.length;j++){%>
                                  
                                c.options.add(new Option('<%=teamString[j]%>','<%=teamString[j]%>'));
                        <%}%>
                    }
    
    }
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <form method="post" action="DataServlet">
            <table border=1 width=100% >
                <tr>
                    <td>请选择查询条件：</td>
                    <td>
                        <select id = "parent" name="parent" onclick="getChange()">
                            <option value="系统"<%if ("系统".equals(request.getParameter("parent")))out.print(" selected ");%>>
                                系统
                            </option >
                            <option value="组别"<%if ("组别".equals(request.getParameter("parent")))out.print(" selected ");%>>
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
        <table border=1 width=100% >

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
    </body>

</html>
