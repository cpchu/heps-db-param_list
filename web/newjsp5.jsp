<%-- 
    Document   : newjsp5
    Created on : 2017-7-25, 10:18:48
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script language='javascript' type='text/javascript'>
    function getimg()
//另存为存放在服务器上图片到本地的方法
    {
        event.returnValue = false;
        show.window.location.href = imgSrc.src;

        timer = setInterval(checkload, 100)
    }

    function checkload()
    {
        if (show.readyState !== "complete")
        {
            //调用document.execCommand方法，'Saveas'表示打开文件另存为对话框命令
            show.document.execCommand('SaveAs');
            clearInterval(timer)
        }
    }
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br>
        <br>
        <img id="imgSrc" width="320px" height="200px" src="bannerV2.jpg" alt=""/></br>
        <br>
        <br>
        <br>
        <input id="btnSaveAs" type="button" value="上图另存为" onclick="getimg()"/>
        <iframe src="" name="show"  style="width:0;height:0"></iframe>
    </body>
</html>
