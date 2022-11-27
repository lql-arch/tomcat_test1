<%--
  Created by IntelliJ IDEA.
  User: bronya
  Date: 2022/11/27
  Time: 下午4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello jsp</h1>
<%--    写java代码--%>
<%
    System.out.println("hello jsp!");
%>

<%--    输出到out.write()--%>
<%="d2qw34r23"%>

<%--    放servlet()外面--%>
<%!
    void show(){

    }
    String name = "123";
%>

<c:if test="${status == 1}">
    <h1>true</h1>
</c:if>

</body>
</html>
