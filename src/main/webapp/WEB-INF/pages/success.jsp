<%--
  Created by IntelliJ IDEA.
  User: 汤成
  Date: 2019/7/28
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>成功页面</h3>
<c:forEach items="${list}" var="item">
    姓名:${item.userName}
    密码:${item.password}<br>
</c:forEach>

</body>
</html>
