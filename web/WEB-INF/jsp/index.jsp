<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <body>
        <table style=" width:50%; height:100px" border="1" cellpadding="1" cellspacing="1" align="center">
            <thead>
            <th>ID</th>
            <th>TITLE</th>
            <th>PRICE</th>
            </thead>
            <c:forEach var="book" items="${name}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td><button><a style="text-decoration: none" href="delete/${book.id}" onclick="return confirm('Are you sure you want to delete')">delete</a></button></td>
                <td><button><a style="text-decoration: none" href="edit/${book.id}">edit</a></button></td>

            </tr>
            </c:forEach>
            <tr>
                <td colspan="5"><center><button><a style="text-decoration: none" href="add">ADD NEW USER</a></button></center></td>
            </tr>
        </table>
    </body>
</html>
