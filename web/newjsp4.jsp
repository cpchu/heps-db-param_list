<%-- 
    Document   : newjsp4
    Created on : 2017-7-13, 10:59:34
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"> 
        <title>Parameter_list参数文件导入页面</title>
        <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
        <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <form name="form1" action="FileImportServlet" method="post">
        <table>
            <tr>
                <td>
                    请选择需要导入的文件：
                </td>
            </tr>

            <tr>
                <td>
                    <input type="file" name="FileName" class="file" /> 
                </td>
            </tr>

            <tr>

                <td>
                    <input type="submit" value="提交"> 
                    <input type="reset" value="重置"> 
                </td>
            </tr>
            
            <tr>
                <td>
                    <textarea cols="50" rows="20" name="myself" readonly="yes">${fileImportResult}</textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input id="paramSaveAs" type="button" value="另存为"/>
                </td>
            </tr>
            <tr>
                <td>
                    <ul class="nav nav-pills">
                        <li role="presentation"><a href="http://localhost:8080/WebApplication2/newjsp2.jsp">HomePage</a></li>
                    </ul>
                </td>
            </tr>
        </table>
        </form>
    </body>
</html>