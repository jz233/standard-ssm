<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div style="text-align:center;">
    <ul class="pagination">
        <c:if test="${!pageInfo.isFirstPage}">
            <li><a href="page-1">&lt;&lt;</a></li>
            <li><a href="page-${pageInfo.prePage}">&lt;</a></li>
        </c:if>
        <c:forEach items="${pageInfo.navigatepageNums}" var="naviPageNum">
            <c:if test="${naviPageNum==pageInfo.pageNum}">
                <li class="active"><a href="page-${naviPageNum}">${naviPageNum}</a></li>
            </c:if>
            <c:if test="${naviPageNum!=pageInfo.pageNum}">
                <li><a href="page-${naviPageNum}">${naviPageNum}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${!pageInfo.isLastPage}">
            <li><a href="page-${pageInfo.nextPage}">&gt;</a></li>
            <li><a href="page-${pageInfo.lastPage}">&gt;&gt;</a></li>
        </c:if>
    </ul>
</div>