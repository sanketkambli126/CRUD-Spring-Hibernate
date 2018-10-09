<%-- 
    Document   : update
    Created on : 29 Aug, 2018, 7:26:23 PM
    Author     : sanke
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <script>
        window.onload=function ()
        {
            var getUrl=window.location;
            var baseUrl=getUrl.protocol+"//"+getUrl.host+"/"+getUrl.pathname.split("/")[1];
            var form=document.getElementById("command");
            if(getUrl.href.includes("add"))
                form.action=baseUrl+"/a/add";
            else
                form.action=baseUrl+"/a/edit";
            debugger;
        };
    </script>
</head>
<html>
    <body>
        <form:form method="post">
            <pre>
               ID<form:hidden path="id"/>
               
               TITLE<form:input path="title"/>

               PRICE<form:input path="price"/>

               <input type="submit" value="save"/>
            </pre>
        </form:form>
    </body>
</html>
