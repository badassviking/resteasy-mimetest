<%-- 
    Document   : index
    Created on : Apr 25, 2013, 2:13:19 PM
    Author     : Andrej Galád <agalad@redhat.com>
--%>

<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mime Type Test</title>
    </head>
    <body>
        <h1>New Request</h1>
        
        <form action="${pageContext.request.contextPath}/" method="post">
            <table>
                <tr>
                    <th>Requested URL</th>
                    <td>${pageContext.request.contextPath}/content_type</td>
                </tr>
                <tr>
                    <th>Accepts</th>
                    <td><input type="text" name="accept" /></td>
                </tr>
                <tr>
                    <th><input type="Submit" value="Run" /></th>
                </tr>
            </table>   
        </form>
            
    </body>
</html>
