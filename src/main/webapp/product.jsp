<%--
  Created by IntelliJ IDEA.
  User: xin.lee
  Date: 2017/3/11
  Time: 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品页面</title>
    <style type="text/css">
        .product {
            width: 200px;
            height: 180px;
        }
        .history {
            width: 100px;
            height: 90px;
        }
    </style>
</head>
<body>
    <img class="product" src="${pageContext.request.contextPath}/img/1.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=1">手电筒</a>
    <img class="product" src="${pageContext.request.contextPath}/img/2.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=2">电话</a>
    <img class="product" src="${pageContext.request.contextPath}/img/3.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=3">电视</a>
    <br/>
    <img class="product" src="${pageContext.request.contextPath}/img/4.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=4">冰箱</a>
    <img class="product" src="${pageContext.request.contextPath}/img/5.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=5">手表</a>
    <img class="product" src="${pageContext.request.contextPath}/img/6.jpg"><a href="${pageContext.request.contextPath}/browsingHistoryServlet?id=6">电脑</a>

    <h4>浏览记录 <a href="${pageContext.request.contextPath}/browsingHistoryRemoveServlet">清除记录</a></h4>
    <c:if test="${requestScope.ids != null}">
        <c:forEach items="${requestScope.ids}" var="id">
            <img class="history" src="${pageContext.request.contextPath}/img/${id}.jpg">
        </c:forEach>
    </c:if>
</body>
</html>
